import { useRouter } from "next/router";
import API from "@/utils/axiosApi";

const OrderCheck = ({ storeId }: { storeId: string }) => {
	const router = useRouter();
	return (
		<div>
			<div>주문 완료</div>
			<div
				className={`w-[300px] h-[300px] bg-red-400 rounded-xl  text-4xl flex justify-center items-center text-white`}
				onClick={() => router.push(`/${storeId}/kiosk`)}>
				처음으로
			</div>
		</div>
	);
};

export const getServerSideProps = async (context: { query: { storeId: string } }) => {
	const { storeId } = context.query;

	return {
		props: {
			storeId: JSON.parse(JSON.stringify(storeId)),
		},
	};
};
export default OrderCheck;
