import Link from "next/link";
import { makeLocaleProps } from "@/utils/i18n";
import { GetServerSidePropsContext } from "next";
import { useTranslation } from "next-i18next";



const Home = () => {
  const {t} = useTranslation();
  return (
    <div className={`grid grid-rows-1 place-content-evenly w-full`}>
      <div className={`col-span-2`}>
        <Link href={"/"}>B A C S</Link>
      </div>
      <div>{t("Japanese")}</div>
      <div>{t("products")}</div>
    </div>
  )
}

export async function getServerSideProps(context: GetServerSidePropsContext) {
  const props = {
    ...(await makeLocaleProps(context)),
  };
  return {
    props,
  };
}

export default Home;