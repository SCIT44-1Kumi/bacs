import { UseFieldArrayAppend, UseFormRegister } from "react-hook-form";
import { ICreateMenu } from "@/pages/menu/new";

const InputMenu = ({register, append}: {register: UseFormRegister<ICreateMenu>, append: UseFieldArrayAppend<ICreateMenu>}) => {
	return <>
		<label htmlFor="menuName">Name</label>
		<input className={`border border-black bg-gray-100 rounded-md`} id={`menuName`} type="text" {...register("menu.menuName", { required: true })} />
		<label htmlFor="menuPrice">Price</label>
		<input className={`border border-black bg-gray-100 rounded-md`} id={`menuPrice`} type="number" {...register("menu.menuPrice", { required: true })}/>
		<label htmlFor="menuImg">Img</label>
		<input className={`border border-black bg-gray-100 rounded-md`} id={`menuImg`} type="string" {...register("menu.menuImg", { required: false })}/>
		<label htmlFor="menuDesc">Desc</label>
		<input className={`border border-black bg-gray-100 rounded-md`} id={`menuDesc`} type="string" {...register("menu.menuDesc", { required: false })}/>
		<button type="button" onClick={() => append({ optionNum: 0, optionName: '', optionValue: '', optionPrice: 0})}>
			Add Option
		</button>
	</>
}

export default InputMenu;