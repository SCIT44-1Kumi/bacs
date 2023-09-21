import Link from "next/link";

const MainNavBar = () => {
	return (
		<div className={`grid grid-cols-7 w-full place-content-between`}>
			<div className={`place-self-center`}>
				<Link href={`/`}>B A C S</Link>
			</div>
			<div className={`grid grid-cols-4 place-items-center col-span-6`}>
				<div>
					<Link href={`/introduce`}>제품소개</Link>
				</div>
				<div>
					<Link href={`/installed`}>설치현황</Link>
				</div>
				<div>
					<Link href={`/login`}>회원가입</Link>
				</div>
				<div>
					<Link href={`/changeLang`}>언어변경</Link>
				</div>
			</div>
		</div>
	);
};

export default MainNavBar;
