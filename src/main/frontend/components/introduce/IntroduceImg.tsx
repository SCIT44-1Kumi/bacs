const IntroduceImg = () => {
	return (
		<div className={`grid grid-cols-2 gap-4 `}>
			<div className={`col-span-2 place-self-center`}>
				<span className={`text-4xl`}>BACS, 기존과 무엇이 다를까요?</span>
			</div>
			<div>
				<div>이미지</div>
				<div>
					<p>비싸다?</p>
					<p>기존에 비싸서 도입못한 키오스크 매장에 패드 하나만으로 BACS!</p>
				</div>
			</div>
			<div>
				<div>이미지</div>
				<div>
					<p>Only 키오스크?</p>
					<p>키오스크 기능뿐만 아니라 매장관리까지 한번에 BACS!</p>
				</div>
			</div>
			<div>
				<div>이미지</div>
				<div>
					<p>불편하다?</p>
					<p>돌아다닐 필요없이 자리에서 NFC를 통해 BACS!</p>
				</div>
			</div>
			<div>
				<div>이미지</div>
				<div>
					<p>어렵다?</p>
					<p>어르신들뿐만 아니라 모두가 어려운 키오스크 음성인식 기능으로 쉽게 BACS!</p>
				</div>
			</div>
		</div>
	);
};

export default IntroduceImg;
