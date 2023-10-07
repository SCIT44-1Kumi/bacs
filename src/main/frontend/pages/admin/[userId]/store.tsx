import { useForm } from "react-hook-form";
import CreateStoreForm from "@/components/admin/createStore";
import { useRouter } from "next/router";
import API from "@/utils/axiosApi";

type CreateStoreFormTypes = {
	storeId: string;
	storeName: string;
	storeAddress: string;
	storePhone: string;
	crNum: string;
};

export type { CreateStoreFormTypes };

const AdminStore = () => {
	const { control, register, handleSubmit } = useForm<CreateStoreFormTypes>();
	const router = useRouter();
	const onSubmit = async (data: CreateStoreFormTypes) => {
		console.log(data);
		const { userId } = router.query;
		const { storeId, storeName, storePhone, storeAddress, crNum } = data;
		// const { data: store } = await API.post(`/store/create`, { ...data });
		// console.log(store);
		return await router.push(`/${storeId}/admin/chart`);
	};
	return (
		<div className={`loginBackground p-12`}>
			<div className={`login grid grid-cols-2`}>
				<div className={`grid place-items-center`}>
					<div>
						<div className={`text-2xl `}>매장관리, 키오스크 한번에 BAC!</div>
						<div className={`text-2xl text-center`}>B A C S</div>
					</div>
				</div>
				<form
					onSubmit={handleSubmit(onSubmit)}
					className={`grid grid-cols-1 place-items-center gap-4`}>
					<CreateStoreForm register={register} />
					<div className={`grid grid-cols-1 place-items-center w-full`}>
						<div className={`flex justify-between w-1/2`}>
							<div></div>
							<input className={`signButton`} type="submit" value="확인" />
						</div>
					</div>
				</form>
			</div>
		</div>
	);
};
export default AdminStore;
