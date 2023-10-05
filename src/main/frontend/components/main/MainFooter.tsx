import Image from "next/image";
import FooterImg from "@/components/main/footerImg";
import localFont from "next/font/local";

const myFont = localFont({ src: "../../public/fonts/BMHANNA.otf" });

const MainFooter = () => {
	return (
		<div className={`grid grid-cols-4 place-items-center`}>
			<div className={`${myFont.className} flex flex-col`}>
				<FooterImg strings={["키오스크", "음성인식", "기능제공"]} src={"/images/mic.png"} />
			</div>
			<div className={`${myFont.className} flex flex-col`}>
				<FooterImg strings={["홍보용", "페이지", "자동생성"]} src={"/images/homePage.png"} />
			</div>
			<div className={`${myFont.className} flex flex-col`}>
				<FooterImg strings={["앉은자리에서", "QR코드로", "주문가능"]} src={"/images/qr.png"} />
			</div>
			<div className={`${myFont.className} flex flex-col`}>
				<FooterImg strings={["보기편한", "매출통계", "기능제공"]} src={"/images/sales.png"} />
			</div>
		</div>
	);
};

export default MainFooter;
