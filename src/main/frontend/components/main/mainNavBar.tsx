import Link from "next/link";

import localFont from "next/font/local";

const myFont = localFont({ src: "../../public/fonts/BMHANNA.otf" });

const MainNavBar = () => {
	return (
		<div className={`px-12 mainTop flex justify-between items-center w-full`}>
			<div className={`${myFont.className} text-6xl grid`}>
				<Link href={`/`}>
					<div className={`mt-1`}>B A C S</div>
				</Link>
			</div>
			<div className={`${myFont.className} text-2xl`}>
				<Link href={`/introduce`}>제품소개</Link>
			</div>
			<div className={`${myFont.className} text-2xl`}>
				<Link href={`/installed`}>설치현황</Link>
			</div>
			<div className={`${myFont.className} text-2xl`}>
				<Link href={`/login`}>회원가입</Link>
			</div>
			<div className={`${myFont.className} text-2xl`}>
				<Link href={`/changeLang`}>언어변경</Link>
			</div>
		</div>
	);
};

export default MainNavBar;
