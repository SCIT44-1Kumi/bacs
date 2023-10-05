import "@/styles/globals.css";
import { AppProps } from "next/app";
import { Inter } from "next/font/google";
import { appWithTranslation } from "next-i18next";
import { ReactNode } from "react";

const inter = Inter({ subsets: ["latin"], weight: "400" });

export type ComponentTypes = {
	children: ReactNode;
};

const MyApp = ({ Component, pageProps }: AppProps) => {
	return (
		<main className={`${inter.className}`}>
			<Component {...pageProps} />
		</main>
	);
};

export default appWithTranslation(MyApp);
