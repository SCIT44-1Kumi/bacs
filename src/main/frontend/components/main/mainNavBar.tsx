import Link from "next/link";

const MainNavBar = () => {
	return (
		<div className={`px-12 mainTop flex justify-between items-center w-full`}>
			<div className={`text-5xl`}>
				<Link href={`/`}>B A C S</Link>
			</div>
			<div className={`text-3xl`}>
				<Link href={`/introduce`}>제품소개</Link>
			</div>
			<div className={`text-3xl`}>
				<Link href={`/installed`}>설치현황</Link>
			</div>
			<div className={`text-3xl`}>
				<Link href={`/login`}>회원가입</Link>
			</div>
			<div className={`text-3xl`}>
				<Link href={`/changeLang`}>언어변경</Link>
			</div>
		</div>
	);
};

export default MainNavBar;
