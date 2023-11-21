import React from "react";
import {useRouter} from "next/router";

export default function Kiosk({ children }) {
  const router = useRouter();
  return (
      <>
        <div className={`bg-blueGray-100 grid grid-cols-1 place-items-center py-12 px-auto min-h-screen`}>
          <button onClick={() => router.push(`/auth/login`)} className="text-blueGray-500 font-bold uppercase px-3 py-1 text-xs outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150 fixed bottom-0 left-0" type="button">
            관리자페이지 로그인
          </button>
          <div className={`container h-full bg-white rounded-lg shadow-xl grid grid-cols-1 place-items-center`}>
            {children}
          </div>
        </div>
      </>
  );
}