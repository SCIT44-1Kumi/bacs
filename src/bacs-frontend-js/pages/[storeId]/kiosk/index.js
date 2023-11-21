import React from "react";
import {useRouter} from "next/router";
import Kiosk from "../../../layouts/Kiosk";

export default function Order() {
  const router = useRouter();
  return <>


          <div className={`col-span-2 text-center text-teal-800 flex flex-col`}>
            <span className={`text-6xl font-normal leading-normal text-teal-800`}>CAFE LOTUS</span>
            <span className={`text-4xl font-normal leading-normal text-teal-800`}>매장 설명</span>
          </div>
          <div className={`flex justify-around w-full`}>
            <button onClick={() => router.push(`/storeid/kiosk/menu`)} className="bg-teal-500 text-white active:bg-teal-600 font-bold uppercase text-base px-8 py-3 rounded-full shadow-md hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">
               일반주문
            </button>
            <button onClick={() => router.push(`/storeid/kiosk/voice`)} className="bg-teal-500 text-white active:bg-teal-600 font-bold uppercase text-base px-8 py-3 rounded-full shadow-md hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">
              음성주문
            </button>
          </div>



    </>

}
Order.layout = Kiosk;
