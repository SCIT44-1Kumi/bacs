import { serverSideTranslations } from "next-i18next/serverSideTranslations";
import { GetServerSidePropsContext, GetStaticPropsContext } from "next";

export const makeLocaleProps = async (
	context: GetServerSidePropsContext | GetStaticPropsContext,
	ns = ["common", "nav"]
) => {
	const { locale } = context;

	if (locale) {
		return {
			...(await serverSideTranslations(locale, ns)),
		};
	}

	return {};
};

export const makeStaticProps =
	(ns = ["common", "nav"]) =>
		async (context: GetServerSidePropsContext | GetStaticPropsContext) => {
			return {
				props: {
					...(await makeLocaleProps(context, ns)),
				},
			};
		};