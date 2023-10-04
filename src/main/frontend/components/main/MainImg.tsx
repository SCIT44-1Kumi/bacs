import Image from "next/image";
import React from "react";
// import { createFont } from "fonts";
//
// const font = createFont`
// @font-face{
//     font-family: 'LibreBarcode39Text-Regular';
//     src: url('./LibreBarcode39Text-Regular.woff') format('woff');
// }`;

const MainImg = () => {
	{
	}
	return (
		<div className={`flex flex-col h-full gap-4 justify-center items-center`}>
			<span className={`text-5xl text-white`}>매장관리, 키오스크 한번에 BACS!</span>
			<div className={`flex flex-col items-center`}>
				<p className={`text-2xl text-white`}>그동안 키오스크 비싸서 고민만 하셨나요?</p>
				<p className={`text-2xl text-white`}>이제 고민없이 싸게 BACS!</p>
			</div>
			{/* 로고이미지 */}
			<span className={`text-6xl text-white`}> B A C S</span>
		</div>
	);
};

export default MainImg;
