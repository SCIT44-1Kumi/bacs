import Link from "next/link";
import KioskBG from "@/components/kiosk/kioskBG";
import KioskMain from "@/components/kiosk/kioskMain";
import { useEffect, useState } from "react";
import SelectOrderBtn from "@/components/kiosk/selectOrderBtn";
import { useRouter } from "next/router";
import API from "@/utils/axiosApi";
import { GetServerSideProps } from "next";

type Store = {
	storeNo: number;
	storeName: string;
	storeId: string;
	storeAddress: string;
	crNum: string;
	storePhone: string;
	createdAt: string;
};

export type { Store };

const Kiosk = ({ store }: { store: Store }) => {
	const [color, setColor] = useState("bg-[#E71817]");
	return (
		<KioskBG color={`${color}`}>
			<KioskMain className={`grid grid-cols-1 row-span-4`} color={`bg-[#D9D9D9]`}>
				<div className={`flex justify-center`}>
					<span className={`kioskMainHeaderString`}>어떤 매장이든지 편하게 BACS!</span>
				</div>
				<div className={`flex justify-center`}>
					<span className={`kioskMainStoreName`}>{store?.storeName}</span>
				</div>
				<div className={`flex justify-around`}>
					<Link href={`/${store.storeId}/kiosk/menu`}>
						<SelectOrderBtn color={`${color}`}>
							<span className={`SelectOrderBtnString`}>일반 주문</span>
						</SelectOrderBtn>
					</Link>
					<Link href={`/${store.storeId}/kiosk/voice`}>
						<SelectOrderBtn color={`${color}`}>
							<span className={`SelectOrderBtnString`}>음성 주문</span>
						</SelectOrderBtn>
					</Link>
				</div>
			</KioskMain>
			<div className={`flex justify-center`}>
				<span className={``}>앉은 자리에서 QR코드로 주문 가능!</span>
			</div>
		</KioskBG>
	);
};

export const getServerSideProps = async (context: { query: { storeId: string } }) => {
	const { storeId } = context.query;
	const { data } = await API.get(`/store/get/${storeId}`);
	return { props: { store: JSON.parse(JSON.stringify(data)) } };
};
export default Kiosk;