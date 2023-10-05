import { ComponentTypes } from "@/pages/_app";

type KioskMainTypes = ComponentTypes & {
	color: string;
	className: string;
};
const KioskMain = ({ color, children, className }: KioskMainTypes) => {
	return <div className={`kioskMain ${color} ${className}`}>{children}</div>;
};
export default KioskMain;
