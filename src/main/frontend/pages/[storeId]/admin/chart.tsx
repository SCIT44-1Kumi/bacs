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
	orderRecipes: OrderRecipe[];
};

type OrderRecipe = {
	id: number;
	menuAmount: number;
	recipePrice: number;
	menu: Menu;
	recipeOptions: RecipeOption[];
};

type RecipeOption = {
	id: number;
	roAmount: number;
	option: MenuOption;
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
					<div className={`grid grid-cols-1 overflow-x-scroll`}>
						{orderList.map(order => (
							<div key={order.id}>
								<div>
									<div>주문 번호</div>
									<div>{order.id}</div>
								</div>
								<div>
									<div>주문 시각</div>
									<div>{order.orderDate}</div>
								</div>
								<div>
									{order.orderRecipes.map(orderRecipe => (
										<div key={orderRecipe.id}>
											<span>{orderRecipe.menu.menuName}</span>
											<span>{orderRecipe.menuAmount}</span>
											<div>
												{orderRecipe.recipeOptions.map(recipeOption => (
													<div key={recipeOption.id}>
														<span>{recipeOption.option.optionName}</span>
														<span>{recipeOption.roAmount}</span>
													</div>
												))}
											</div>
										</div>
									))}
								</div>
							</div>
						))}
					</div>
			<div>
				<div className={`grid grid-cols-2`}>
					<div className={`chart1`}>
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
					<div className={`chart2 col-span-2`}>
						<span>주간 매출</span>
						<div className={`h-[100]`}>
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
										height: 100,
										width: 300,
									},
								}}
								height={350}
							/>
						</div>
					</div>
					<div className={`chart3 col-span-3 grid grid-cols-1 place-items-center`}>
						<span>현재 주문 현황</span>
						{/*<div className={`grid grid-cols-1 overflow-x-scroll`}>{}</div>*/}
					</div>
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
