import { makeLocaleProps } from "@/utils/i18n";
import { GetServerSidePropsContext } from "next";
import { useTranslation } from "next-i18next";
import MainNavBar from "@/components/main/mainNavBar";
import MainImg from "@/components/main/MainImg";
import MainFooter from "@/components/main/MainFooter";
import { useEffect, useState } from "react";
import axios from "axios";
import { useRouter } from "next/router";

export interface IUser {
	userId: string;
	userPw: string;
	email: string;
	phone: string;
	rolename: string;
	enabled: string;
	createdAt: string;
}

const Home = () => {
	const { t } = useTranslation();

	return (
		<div>
			<MainNavBar />
			<MainImg />
			<MainFooter />
		</div>
	);
};

export async function getServerSideProps(context: GetServerSidePropsContext) {
	const props = {
		...(await makeLocaleProps(context)),
	};
	return {
		props,
	};
}

export default Home;
