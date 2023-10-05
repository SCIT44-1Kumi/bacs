"use client";
import KioskBG from "@/components/kiosk/kioskBG";
import { useEffect, useState } from "react";
import KioskMain from "@/components/kiosk/kioskMain";
import API from "@/utils/axiosApi";
import { Store } from "@/pages/[storeId]/kiosk/index";
import Image from "next/image";

type Category = {
	id: number;
	categoryName: string;
};

type Menu = {
	id: number;
	menuName: string;
	menuPrice: number;
	menuImg: string;
	menuDesc: string;
	menuOptions: MenuOption[];
};

type MenuOption = {
	id: number;
	optionName: string;
	optionValue: string;
	optionPrice: number;
};

type MenuOrderProps = {
	categories: Category[];
	store: Store;
};

const MenuOrder = ({ categories, store }: MenuOrderProps) => {
	const [menuList, setMenuList] = useState<Menu[]>();
	const [categoryNo, setCategoryNo] = useState<number>(categories[0].id);
	const [color, setColor] = useState("bg-[#E71817]");
	const [selectList, setSelectList] = useState<Menu[]>();
	const getMenus = async () => {
		const { data } = await API.get(`/${store.storeId}/menu/getMenus`, {
			params: {
				categoryNo,
			},
		});
		console.log(data);
		return data;
	};
	useEffect(() => {
		(async () => {
			const menuList = await getMenus();
			setMenuList(menuList);
		})();
	}, [categoryNo]);

	return (
		<div>
			<KioskBG color={color}>
				<KioskMain className={`grid grid-cols-1 gap-4 row-span-6`} color={`bg-[#D9D9D9]`}>
					<div className={`flex justify-center items-center text-5xl`}>
						<span>{store.storeName}</span>
					</div>
					<div
						className={`overflow-x-auto flex justify-evenly items-center rounded-xl bg-stone-200 mx-12`}>
						{categories.map(category => (
							<div
								className={`min-w-max`}
								key={category.id}
								onClick={() => setCategoryNo(category.id)}>
								{category.categoryName}
							</div>
						))}
					</div>
					<div
						className={`row-span-5 grid grid-cols-4 place-items-center rounded-xl bg-stone-200 mx-12`}>
						{menuList?.map(menu => (
							<div key={menu.id}>
								<div className={`grid place-items-center`}>이미지</div>
								<div className={`grid grid-cols-1 place-items-center`}>
									<span>{menu.menuName}</span>
									<span>{menu.menuPrice}</span>
									<span>{menu.menuDesc}</span>
								</div>
							</div>
						))}
					</div>
					<div className={`grid grid-cols-6 row-span-2 p-12 gap-6`}>
						<div className={`col-span-5 bg-stone-200 rounded-xl`}></div>
						<div className={`${color} text-white rounded-xl grid place-items-center text-2xl`}>
							주문하기
						</div>
					</div>
				</KioskMain>
				<div className={`grid grid-cols-3 place-items-center row-span-1`}>
					<div className={`relative w-[100px] h-[100px]`}>
						<Image
							src={`http://api.qrserver.com/v1/create-qr-code/?data=http://10.10.17.246:3000/${store.storeId}/kiosk&size=100x100`}
							alt={`qrcode`}
							fill
						/>
					</div>

					<span className={`col-span-2 items-center justify-self-start text-3xl`}>
						앉은 자리에서 QR코드로 주문 가능!
					</span>
				</div>
			</KioskBG>
		</div>
	);
};

export const getServerSideProps = async (context: { query: { storeId: string } }) => {
	const { storeId } = context.query;
	const { data: store } = await API.get(`/store/get/${storeId}`);
	const { data: categoryList } = await API.get(`/${storeId}/category/getCategories`);

	return {
		props: {
			store: JSON.parse(JSON.stringify(store)),
			categories: JSON.parse(JSON.stringify(categoryList)),
		},
	};
};
export default MenuOrder;
