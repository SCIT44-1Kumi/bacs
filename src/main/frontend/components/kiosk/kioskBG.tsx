import { ComponentTypes } from "@/pages/_app";

type KioskBGTypes = ComponentTypes & {
	color: string;
};
const KioskBG = ({ color, children }: KioskBGTypes) => {
	return <div className={`${color} grid grid-cols-1 h-screen`}>{children}</div>;
};
export default KioskBG;
