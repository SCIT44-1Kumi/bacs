import Image from "next/image";

type FooterImgTypes = {
	strings: string[];
	src: string;
};

const FooterImg = ({ strings, src }: FooterImgTypes) => {
	return (
		<div className={`flex flex-col`}>
			{/* <Image /> */}
			<div className={`text-center grid place-items-center`}>
				<Image alt="homePage" width={50} height={50} src={src} />
				<p>{strings[0]}</p>
				<p>{strings[1]}</p>
				<p>{strings[2]}</p>
			</div>
		</div>
	);
};
export default FooterImg;
