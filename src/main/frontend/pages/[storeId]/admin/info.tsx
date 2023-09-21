import AdminNavBar from "@/components/admin/adminNavBar";

const AdminInfo = () => {
	return (
		<div>
			<AdminNavBar />
			<div className={`grid grid-cols-3`}>
				<div>
					{/*<p>{storeId}</p>*/}
					<div>
						<p>전일 매장 매출</p>
						{/*<p>{totalSales}</p>*/}
					</div>
					<div>
						<p>현재 매장 매출</p>
						{/*<p>{todaySales}</p>*/}
					</div>
					<button>조회</button>
				</div>
				<div className={`col-span-2`}>
					<span>주간 매출</span>
				</div>
				<div className={`col-span-3`}>
					<span>현재 주문 현황</span>
				</div>
			</div>
		</div>
	);
};

export default AdminInfo;
