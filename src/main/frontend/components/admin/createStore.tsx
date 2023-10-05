import { UseFormRegister } from "react-hook-form";
import { ISignForm } from "@/pages/login";
import localFont from "next/font/local";
import { CreateStoreFormTypes } from "@/pages/admin/[userId]/store";

type CreateStoreFormProps = {
	register: UseFormRegister<CreateStoreFormTypes>;
};

const myFont = localFont({ src: "../../public/fonts/BMHANNA.otf" });
const CreateStoreForm = ({ register }: CreateStoreFormProps) => {
	return (
		<>
			<div className={`text-3xl`}>매장 등록</div>
			<div className={`grid grid-cols-1 gap-4 place-items-center w-full`}>
				<div className={`${myFont.className} grid grid-cols-2 place-content-between items-center`}>
					<div>매장 ID</div>
					<input
						type="text"
						{...register("storeId", { required: true })}
						className={`bg-gray-100 rounded-md`}
					/>
				</div>
				<div className={`${myFont.className} grid grid-cols-2 place-content-between items-center`}>
					<div>매장 이름</div>
					<input
						type="text"
						{...register("storeName", { required: true })}
						className={`bg-gray-100 rounded-md`}
					/>
				</div>
				<div className={`${myFont.className} grid grid-cols-2 place-content-between items-center`}>
					<div>매장 번호</div>
					<input
						type="text"
						{...register("storePhone", { required: true })}
						className={`bg-gray-100 rounded-md`}
					/>
				</div>
				<div className={`${myFont.className} grid grid-cols-2 place-content-between items-center`}>
					<div>매장 주소</div>
					<input
						type="text"
						{...register("storeAddress", { required: true })}
						className={`bg-gray-100 rounded-md`}
					/>
				</div>
				<div className={`${myFont.className} grid grid-cols-2 place-content-between items-center`}>
					<div>사업자등록번호</div>
					<input
						type="text"
						{...register("crNum", { required: true })}
						className={`bg-gray-100 rounded-md`}
					/>
				</div>
			</div>
		</>
	);
};
export default CreateStoreForm;
