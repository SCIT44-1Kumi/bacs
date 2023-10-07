import Link from "next/link";
import KioskBG from "@/components/kiosk/kioskBG";
import KioskMain from "@/components/kiosk/kioskMain";
import { useEffect, useState } from "react";
import SelectOrderBtn from "@/components/kiosk/selectOrderBtn";
import { useRouter } from "next/router";
import API from "@/utils/axiosApi";
import { GetServerSideProps } from "next";
import Image from "next/image";

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
			<div className={`grid grid-cols-3 place-items-center row-span-1`}>
				<div className={`relative w-[100px] h-[100px]`}>
					<Image
						src={`http://api.qrserver.com/v1/create-qr-code/?data=http://10.10.17.246:3000/${store.storeId}/kiosk&size=100x100`}
						alt={`qrcode`}
						fill
					/>
				</div>

				<span className={`col-span-2 items-center justify-self-start text-3xl`}>
					앉은 자리에서 QR코드로 주문 가능!
				</span>
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
