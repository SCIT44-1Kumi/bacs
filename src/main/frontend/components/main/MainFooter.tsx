const MainFooter = () => {
	return (
		<div className={`grid grid-cols-4 place-items-center`}>
			<div className={`flex flex-col`}>
				{/* <Image /> */}
				<div>
					<p>키오스크</p>
					<p>음성인식</p>
					<p>기능제공</p>
				</div>
			</div>
			<div className={`flex flex-col`}>
				{/* <Image /> */}
				<div>
					<p>홍보용</p>
					<p>페이지</p>
					<p>자동생성</p>
				</div>
			</div>
			<div className={`flex flex-col`}>
				{/* <Image /> */}
				<div>
					<p>앉은자리에서</p>
					<p>NFC TAG로</p>
					<p>주문가능</p>
				</div>
			</div>
			<div className={`flex flex-col`}>
				{/* <Image /> */}
				<div>
					<p>보기편한</p>
					<p>매출통계</p>
					<p>기능제공</p>
				</div>
			</div>
		</div>
	);
};

export default MainFooter;
