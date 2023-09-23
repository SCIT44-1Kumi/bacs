import AdminNavBar from "@/components/admin/adminNavBar";
import { useForm } from "react-hook-form";

type SubmitDataType = {
	template: string;
};

const AdminInfoPage = () => {
	const { control, register, handleSubmit } = useForm<SubmitDataType>();
	const onSubmit = (data: SubmitDataType) => {
		console.log(data);
		return;
	};
	return (
		<div>
			<AdminNavBar />
			<div className={`grid grid-cols-4 place-items-center`}>
				<div className={`col-span-3`}>홈페이지 미리보기 화면</div>
				<form onSubmit={handleSubmit(onSubmit)} className={`w-full`}>
					<div className={`flex flex-col justify-around w-full`}>
						<div className={`w-full flex justify-evenly`}>
							<input type="radio" {...register("template")} defaultValue={`template 1`} />
							보기1
						</div>
						<div className={`w-full flex justify-evenly`}>
							<input type="radio" {...register("template")} defaultValue={`template 2`} />
							보기2
						</div>
						<div className={`w-full flex justify-evenly`}>
							<input type="radio" {...register("template")} defaultValue={`template 3`} />
							보기3
						</div>
						<div className={`flex justify-evenly w-full`}>
							<input type="reset" value="취소" />
							<input type="submit" value="저장" />
						</div>
					</div>
				</form>
			</div>
		</div>
	);
};

export default AdminInfoPage;
