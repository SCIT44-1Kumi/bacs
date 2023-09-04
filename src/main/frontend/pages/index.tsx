"use client";
import Link from "next/link";
import { makeLocaleProps } from "@/utils/i18n";
import { GetServerSidePropsContext } from "next";
import { useTranslation } from "next-i18next";
import { useEffect, useState } from "react";
import axios from "axios";

export interface IUser {
  userId: string
  userPw: string
  email: string
  phone: string
  rolename: string
  enabled: string
  createdAt: string
}

const Home = () => {
  const {t} = useTranslation();
  const [users, setUsers] = useState<IUser[]>();
  useEffect(() => {
    (async () => {
      const result = await axios.get('/member/getUserList');
      // $.ajax({
      // url: '/member/getUserList',
      // })

      console.log(result);
      setUsers(result.data);
  })();
  }, [])
  return (
    <div className={`grid grid-rows-1 place-content-evenly w-full`}>
      <div className={`col-span-2`}>
        <Link href={"/"}>B A C S</Link>
      </div>
      <div>{t("home.Japanese")}</div>
      <div>{t("home.products")}</div>
      {users?.map(user => (
        <div key={user.userId} className={`grid grid-cols-2 min-w-full col-span-2 place-content-evenly`}>
          <span>{user.userId}</span>
          <span>{user.email}</span>
        </div>
        )
      )}
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