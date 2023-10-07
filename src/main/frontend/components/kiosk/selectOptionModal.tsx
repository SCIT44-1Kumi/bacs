import { Dispatch, SetStateAction } from "react";
import { MenuOption } from "@/pages/[storeId]/kiosk/menu";

type SelectOptionModalTypes = {
	clickModal: Dispatch<SetStateAction<boolean>>;
	options: MenuOption[];
	setOption: (optionId: number) => {};
};
const SelectOptionModal = ({ clickModal, options, setOption }: SelectOptionModalTypes) => {
	return (
		<div
			onClick={() => clickModal}
			className={`fixed top-0 left-0 w-full h-full bg-black/40 flex justify-center items-end`}>
			<div className={`w-[90%] h-[80%] bg-stone-300 rounded-t-2xl p-12 grid grid-cols-1 gap-4`}>
				<div className={`row-span-2 bg-stone-200 rounded-xl p-4 grid grid-cols-2`}>
					{options.map(option => (
						<div
							key={option.id}
							onClick={() => {
								console.log(option.id);
								setOption(option.id);
							}}>
							<div>{option.optionName}</div>
							<div>
								<span>{option.optionValue}</span>
								<span>{option.optionPrice}</span>
							</div>
						</div>
					))}
				</div>
				<div className={`bg-stone-200 rounded-xl p-4 flex justify-center items-center`}>
					<div
						onClick={clickModal}
						className={`bg-red-400 rounded-xl h-full w-1/2 text-white flex justify-center items-center text-4xl`}>
						장바구니 추가
					</div>
				</div>
			</div>
		</div>
	);
};
export default SelectOptionModal;
