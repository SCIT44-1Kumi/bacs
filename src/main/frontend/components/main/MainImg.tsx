import React from "react";
import { Libre_Barcode_39_Text } from "next/font/google";
import localFont from "next/font/local";

const myFont = localFont({ src: "../../public/fonts/BMHANNA.otf" });

const barcode39 = Libre_Barcode_39_Text({ subsets: ["latin"], weight: "400" });
const MainImg = () => {
	{
	}
	return (
		<div className={`flex flex-col h-full gap-4 justify-center items-center`}>
			<span className={`${myFont.className} text-5xl text-white`}>
				매장관리, 키오스크 한번에 BACS!
			</span>
			<div className={`flex flex-col items-center`}>
				<p className={`${myFont.className} text-2xl text-white`}>
					그동안 키오스크 비싸서 고민만 하셨나요?
				</p>
				<p className={`${myFont.className} text-2xl text-white`}>이제 고민없이 싸게 BACS!</p>
			</div>
			{/* 로고이미지 */}
			<span className={`text-8xl text-white ${barcode39.className}`}> B A C S</span>
		</div>
	);
};

export default MainImg;
