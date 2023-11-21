'use client'
import Kiosk from "../../../layouts/Kiosk";
import {useRouter} from "next/router";
import {useEffect, useState} from "react";

export default function Receipt() {
  const router = useRouter();
  // setTimeout(async () => {
  //   await router.push("/storeid/kiosk")
  // }, 5000);
  const [counter, setCounter] = useState(5);
  useEffect(() => {
      setTimeout(() => router.push('/storeid/kiosk'), 5000)
      setInterval(() => {
        setCounter(counter => counter-1);
      }, 1000)

  }, []);
  return (
      <div>
        <button onClick={() => router.push('/storeid/kiosk')} className="text-white bg-blueGray-600 font-bold uppercase text-base px-8 py-3 rounded shadow-md hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">
          처음으로 {counter}
        </button>
      </div>
  )
}

Receipt.layout = Kiosk;