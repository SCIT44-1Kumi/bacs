import Link from "next/link";
import { useRouter } from "next/router";
import localFont from "next/font/local";

const myFont = localFont({ src: "../../public/fonts/BMHANNA.otf" });

const AdminNavBar = () => {
	const router = useRouter();
	const storeId = router.asPath.split("/")[1];
	console.log(storeId);
	return (
		<div className={`px-12 mainTop flex justify-between items-center w-full`}>
			<div className={`${myFont.className} text-6xl grid`}>
				<span className={`mt-1`}>B A C S</span>
			</div>
			<div className={`${myFont.className} text-2xl`}>
				<Link href={`/${storeId}/admin/chart`}>매출조회/통계</Link>
			</div>
			<div className={`${myFont.className} text-2xl`}>
				<Link href={`/${storeId}/admin/info`}>홍보페이지 관리</Link>
			</div>
			<div className={`${myFont.className} text-2xl`}>
				<Link href={`/${storeId}/admin/kiosk`}>키오스크 관리</Link>
			</div>
			<div className={`${myFont.className} text-2xl`}>
				<Link href={`/${storeId}/admin/menu`}>메뉴 관리</Link>
			</div>
		</div>
	);
};

export default AdminNavBar;
