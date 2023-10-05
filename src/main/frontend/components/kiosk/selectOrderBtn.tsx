import { ComponentTypes } from "@/pages/_app";

type SelectOrderBtnTypes = ComponentTypes & {
	color: string;
};
const SelectOrderBtn = ({ color, children }: SelectOrderBtnTypes) => {
	return <div className={`kioskSelectOrderBtn ${color} grid place-items-center`}>{children}</div>;
};

export default SelectOrderBtn;
