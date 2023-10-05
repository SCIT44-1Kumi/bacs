import KioskBG from "@/components/kiosk/kioskBG";
import { SetStateAction, useState } from "react";
import KioskMain from "@/components/kiosk/kioskMain";
import Image from "next/image";
import API from "@/utils/axiosApi";
import { Store } from "@/pages/[storeId]/kiosk/index";
// @ts-ignore
import * as speech from "react-speech-kit";

type VoiceOrderProps = {
	store: Store;
};

const VoiceOrder = ({ store }: VoiceOrderProps) => {
	const [value, setValue] = useState("결과");

	const { listen, listening, stop } = speech.useSpeechRecognition({
		onResult: async (result: SetStateAction<string>) => {
			setValue(result);
			await API.post("/nlp/test1", {
				text: result,
			});
		},
	});
	const onClickRecord = async () => {
		listen();
		setTimeout(async () => {
			await stop();
		}, 6000);
	};
	const [color, setColor] = useState("bg-[#E71817]");
	return (
		<div>
			<KioskBG color={color}>
				<KioskMain
					className={`grid grid-cols-1 row-span-6 place-content-center items-center`}
					color={`bg-[#D9D9D9]`}>
					<div className={`grid grid-cols-1 place-items-center gap-4 text-5xl text-center`}>
						<pre className={``}>
							마이크 버튼을 누른 뒤<br />
							원하는 상품을
							<br />
							하나만 말해주세요
						</pre>
						<div
							onClick={onClickRecord}
							className={`w-[200px] h-[200px] text-center rounded-full bg-red-500 flex justify-center items-center`}>
							마이크 버튼
						</div>
					</div>
					<div className={`text-center text-2xl`}>{value}</div>
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
		</div>
	);
};

export const getServerSideProps = async (context: { query: { storeId: string } }) => {
	const { storeId } = context.query;
	const { data: store } = await API.get(`/store/get/${storeId}`);

	return {
		props: {
			store: JSON.parse(JSON.stringify(store)),
		},
	};
};
export default VoiceOrder;
