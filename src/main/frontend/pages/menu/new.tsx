import axios from "axios";
import { useFieldArray, useForm } from "react-hook-form";
import { useRouter } from "next/router";
import InputMenu from "@/components/inputMenu";
import { useState } from "react";

export type Category = {
	categoryNum: number;
	categoryName: string;
	storeId: string;
};

export type Option = {
	optionNum: number;
	optionName: string;
	optionValue: string;
	optionPrice: number;
};

type Menu = {
	menuName: string;
	menuPrice: number;
	menuImg: string;
	menuDesc: string;
};

export type ICreateMenu = {
	category: Category;
	menu: Menu;
	options: Option[];
};
const CreateMenuForm = () => {
	const { control, register, handleSubmit } = useForm<ICreateMenu>();
	const { fields, append, remove } = useFieldArray({
		control,
		name: "options", // 폼 필드 배열의 이름
	});
	const router = useRouter();
	const onSubmit = async (data: ICreateMenu) => {
		console.log(data);
		const { menu, options } = data;
		await axios.post("/api/menu/create", {
			menu,
			options,
		});
		await router.push("/");
		return;
	};

	return (
		<div>
			<form
				onSubmit={handleSubmit(onSubmit)}
				className={`grid grid-cols-2 place-content-center w-1/2 gap-y-4 `}>
				<InputMenu register={register} append={append} />
				{fields &&
					fields.map((field, index) => (
						// TODO: Component 화 해보기 by @Sshujung
						<div
							key={field.id}
							className={`col-span-2 grid grid-cols-2 gap-2 place-items-center border border-gray-300 rounded-md`}>
							<label htmlFor={`optionName`}>optionName</label>
							<input
								className={`bg-gray-100 rounded-md border-black border`}
								id={`optionName`}
								{...register(`options.${index}.optionName`, { required: true })}
								type="text"
							/>
							<label htmlFor={`optionValue`}>optionValue</label>
							<input
								className={`bg-gray-100 rounded-md border-black border`}
								id={`optionValue`}
								{...register(`options.${index}.optionValue`, { required: true })}
								type="text"
							/>
							<label htmlFor={`optionValue`}>optionPrice</label>
							<input
								className={`bg-gray-100 rounded-md border-black border`}
								id={`optionPrice`}
								{...register(`options.${index}.optionPrice`, { required: true })}
								type="number"
							/>
							<input type="hidden" {...register(`options.${index}.optionNum`)} />
							<button
								className={`bg-red-400 rounded-md text-white px-4`}
								type="button"
								onClick={() => remove(index)}>
								Remove
							</button>
						</div>
					))}
				<input
					className={`bg-blue-400 rounded-md w-1/2`}
					id={`submit`}
					type="submit"
					value="저장"
				/>
			</form>
		</div>
	);
};

export default CreateMenuForm;
