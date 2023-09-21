import Image from "next/image";

const MainImg = () => {
	{
		/* 배경이미지 */
	}
	return (
		<div className={`grid grid-cols-1 gap-4 place-items-center`}>
			<span className={`text-5xl`}>매장관리, 키오스크 한번에 BACS!</span>
			<div className={`flex flex-col items-center`}>
				<p className={`text-2xl`}>그동안 키오스크 비싸서 고민만 하셨나요?</p>
				<p className={`text-2xl`}>이제 고민없이 싸게 BACS!</p>
			</div>
			{/* 로고이미지 */}
			<span className={`text-6xl`}>B A C S</span>
		</div>
	);
};

export default MainImg;
