import Link from "next/link";

const AdminNavBar = () => {
	return (
		<div className={`flex justify-between mx-6`}>
			<div>
				<span>B A C S</span>
				<span>환영합니다!</span>
			</div>
			<div className={`grid grid-cols-3`}>
				<div>
					<Link href={`{storeId}/admin/info`}>홍보페이지 관리</Link>
				</div>
				<div>
					<Link href={`{storeId}/admin/kiosk`}>키오스크 관리</Link>
				</div>
				<div>
					<Link href={`{storeId}/admin/menu`}>메뉴 관리</Link>
				</div>
			</div>
		</div>
	);
};

export default AdminNavBar;
