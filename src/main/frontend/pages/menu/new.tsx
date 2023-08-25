
import axios from "axios";
import { useFieldArray, useForm } from "react-hook-form";
import { useRouter } from "next/router";

type Option = {
	optionNum: number;
	optionName: string,
	optionValue: string,
	optionPrice: number,
}

type ICreateMenu = {
	menuName: string,
	menuPrice: number,
	menuImg: string,
	menuDesc: string,
	options: Option[],
}
const CreateMenuForm = () => {
	const { control, register, handleSubmit } = useForm<ICreateMenu>();
	const { fields, append, remove } = useFieldArray({
		control,
		name: 'options', // 폼 필드 배열의 이름
	});
	const router = useRouter();
	const onSubmit = async (data: ICreateMenu) => {
		console.log(data);
		await axios.post('/menu/menuForm', {data});
		await router.push("/");
		return;
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
			<button type="button" onClick={() => append({ optionNum: 0, optionName: '', optionValue: '', optionPrice: 0})}>
				Add Option
			</button>
			{fields && fields.map((field, index) => (
				<div key={field.id} className={`col-span-2 grid grid-cols-2 gap-2 place-items-center border border-gray-300 rounded-md`}>
					<label htmlFor={`optionName`}>optionName</label>
					<input className={`bg-gray-100 rounded-md border-black border`} id={`optionName`} {...register(`options.${index}.optionName`, { required: true})} type="text" />
					<label htmlFor={`optionValue`}>optionValue</label>
					<input className={`bg-gray-100 rounded-md border-black border`} id={`optionValue`} {...register(`options.${index}.optionValue`, { required: true})} type="text" />
					<label htmlFor={`optionValue`}>optionPrice</label>
					<input className={`bg-gray-100 rounded-md border-black border`} id={`optionPrice`} {...register(`options.${index}.optionPrice`, { required: true})} type="number" />
					<input type="hidden" {...register(`options.${index}.optionNum`)} />
					<button className={`bg-red-400 rounded-md text-white px-4`} type="button" onClick={() => remove(index)}>
						Remove
					</button>
				</div>
			))}
			{/*<div key={index} className={`col-span-2 grid grid-cols-2 gap-2 place-items-center border border-gray-300 rounded-md`}>*/}
			{/*	<label htmlFor={`optionName`}>optionName</label>*/}
			{/*	<input className={`bg-gray-100 rounded-md border-black border`} id={`optionName`} {...register("optionName", { required: false })} type="text" />*/}
			{/*	<label htmlFor={`optionValue`}>optionValue</label>*/}
			{/*	<input className={`bg-gray-100 rounded-md border-black border`} id={`optionValue`} {...register("optionValue", { required: false })} type="text" />*/}
			{/*	<label htmlFor={`optionValue`}>optionPrice</label>*/}
			{/*	<input className={`bg-gray-100 rounded-md border-black border`} id={`optionPrice`} {...register("optionPrice", { required: false })} type="number" />*/}
			{/*	<input type="hidden" {...register("optionNum", { required: false })} />*/}
			{/*</div>*/}
			<input className={`bg-blue-400 rounded-md w-1/2`} id={`submit`} type="submit" value="저장" />
		</form>
	</div>
}

export default CreateMenuForm;