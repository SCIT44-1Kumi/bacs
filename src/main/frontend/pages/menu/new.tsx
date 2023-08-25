
import axios from "axios";
import { useForm } from "react-hook-form";
import { useRouter } from "next/router";
import { useState } from "react";

type ICreateMenu = {
	menuName: string,
	menuPrice: number,
	menuImg: string,
	menuDesc: string,
	optionName: string,
	optionValue: string,
	optionPrice: number,
}
const CreateMenuForm = () => {
	const { register, handleSubmit } = useForm<ICreateMenu>();
	const router = useRouter();
	const [options, setOptions] = useState<number>(0);
	const onSubmit = async (data: ICreateMenu) => {
		await axios.post('/menu/menuForm', {data});
		await router.push("/");
		return;
	}
	const onClickAddOption = () => {
		setOptions(perv => perv + 1);
	}
	return <div>
		<form onSubmit={handleSubmit(onSubmit)} className={`grid grid-cols-2 place-content-center w-1/2 gap-y-4 `}>
			<label htmlFor="menuName">Name</label>
			<input className={`border border-black bg-gray-100 rounded-md`} id={`menuName`} type="text" {...register("menuName", { required: true })} />
			<label htmlFor="menuPrice">Price</label>
			<input className={`border border-black bg-gray-100 rounded-md`} id={`menuPrice`} type="number" {...register("menuPrice", { required: true })}/>
			<label htmlFor="menuImg">Img</label>
			<input className={`border border-black bg-gray-100 rounded-md`} id={`menuImg`} type="string" {...register("menuImg", { required: false })}/>
			<label htmlFor="menuDesc">Desc</label>
			<input className={`border border-black bg-gray-100 rounded-md`} id={`menuDesc`} type="string" {...register("menuDesc", { required: false })}/>
			<input className={`bg-blue-400 rounded-md w-1/2`} onClick={onClickAddOption} id={`addOption`} type="button" value="메뉴옵션 추가" />
			{options != 0 && [...Array(options)].map((n, index) => {
				return ( 
					<div key={index} className={`col-span-2 grid grid-cols-2 gap-2 place-items-center border border-gray-300 rounded-md`}>
						<label htmlFor={`optionName`}>optionName</label>
						<input className={`bg-gray-100 rounded-md border-black border`} id={`optionName`} {...register("optionName", { required: false })} type="text" />
						<label htmlFor={`optionValue`}>optionValue</label>
						<input className={`bg-gray-100 rounded-md border-black border`} id={`optionValue`} {...register("optionValue", { required: false })} type="text" />
						<label htmlFor={`optionValue`}>optionPrice</label>
						<input className={`bg-gray-100 rounded-md border-black border`} id={`optionPrice`} {...register("optionPrice", { required: false })} type="number" />
					</div>
				)
			})}
			<input className={`bg-blue-400 rounded-md w-1/2`} id={`submit`} type="submit" value="저장" />
		</form>
	</div>
}

export default CreateMenuForm;