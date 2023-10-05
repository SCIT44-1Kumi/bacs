"use client";
import AdminNavBar from "@/components/admin/adminNavBar";
import API from "@/utils/axiosApi";
import { Store } from "@/pages/[storeId]/kiosk";
import { useEffect, useState } from "react";

import dynamic from "next/dynamic";
const ApexChart = dynamic(() => import("react-apexcharts"), { ssr: false });

type AdminChartProps = {
	store: Store;
	data: Data[];
	orderList: Order[];
};

type Order = {
	id: number;
	totalPrice: number;
	toGo: boolean;
	cancelled: boolean;
	orderDate: string;
	orderRecipes:
};

type Data = {
	order_Date: string;
	daily_Total_Price: number;
};

const AdminChart = ({ store, data, orderList }: AdminChartProps) => {
	// useEffect(() => {
	// 	(async () => {
	// 		const { data } = await API.get(`/${store.storeId}/admin/salesWeek`);
	// 		console.log(data);
	// 	})();
	// }, []);

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
					<div>
						<ApexChart
							type={`line`}
							series={[
								{
									data: data.map(d => {
										return {
											x: d.order_Date,
											y: d.daily_Total_Price,
										};
									}),
								},
							]}
							options={{
								chart: {
									height: 350,
									width: 500,
								},
							}}
						/>
					</div>
				</div>
				<div className={`col-span-3 grid grid-cols-1 place-items-center`}>
					<span>현재 주문 현황</span>
					<div className={`grid grid-cols-1 overflow-x-scroll`}>{}</div>
				</div>
			</div>
		</div>
	);
};

export const getServerSideProps = async (context: { query: { storeId: string } }) => {
	const { storeId } = context.query;
	const { data: store } = await API.get(`/store/get/${storeId}`);
	const { data: data } = await API.post(`/${storeId}/admin/salesWeek`);
	const { data: orderList } = await API.get(`/${storeId}/admin/orderPendingList`);

	return {
		props: {
			store: JSON.parse(JSON.stringify(store)),
			data: JSON.parse(JSON.stringify(data)),
			orderList: JSON.parse(JSON.stringify(orderList)),
		},
	};
};

export default AdminChart;
