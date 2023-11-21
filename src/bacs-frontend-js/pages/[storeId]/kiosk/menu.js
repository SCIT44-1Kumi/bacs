"use client";
import Kiosk from "../../../layouts/Kiosk";
import KioskCategorybar from "../../../components/Kiosk/KioskCategorybar";
import MenuItem from "../../../components/Kiosk/MenuItem";
import {useState} from "react";
import {useRouter} from "next/router";

const data = [
  {
    menuName: "아메리카노",
    img: "http://www.breadnco.kr/wp-content/uploads/2023/09/%EC%95%84%EC%9D%B4%EC%8A%A4%EC%95%84%EB%A9%94%EB%A6%AC%EC%B9%B4%EB%85%B8_%EB%A6%AC%EC%82%AC%EC%9D%B4%EC%A7%95.png"
  },
  {
    menuName: "카페라떼",
    img: "https://image.aladin.co.kr/product/8883/76/cover500/s572635127_2.jpg"
  },
  {
    menuName: "카페모카",
    img: "http://www.dunkindonuts.co.kr/upload/product/1607136351.png"
  },
  {
    menuName: "콜드브루",
    img: "http://www.breadnco.kr/wp-content/uploads/2022/05/%EC%BD%9C%EB%93%9C%EB%B8%8C%EB%A3%A8-%EC%A0%9C%ED%92%88%EB%93%B1%EB%A1%9D%EC%9A%A9.png"
  },
  {
    menuName: "바닐라 카페라떼",
    img: "https://cdn.imweb.me/upload/S201904245cbfeaeb57b7d/82285d9641086.jpg"
  },
  {
    menuName: "콜드브루 라떼",
    img: "http://www.breadnco.kr/wp-content/uploads/2021/07/%EC%BD%9C%EB%93%9C%EB%B8%8C%EB%A3%A8-%EB%9D%BC%EB%96%BC.png"
  },
  {
    menuName: "카푸치노",
    img: "http://www.breadnco.kr/wp-content/uploads/2019/09/%EC%B9%B4%ED%91%B8%EC%B9%98%EB%85%B8_%EB%A6%AC%EC%82%AC%EC%9D%B4%EC%A7%95.png"
  },
]

export default function Menu() {
  const router = useRouter();
  const [isOptionOpen, setIsOptionOpen] = useState(false);
  const handleClickMenu = (e) => {
    setIsOptionOpen(!isOptionOpen)
    console.log(isOptionOpen)
  }
  const handleClickPrevious = async (e) => await router.push(`/storeId/kiosk`);
  const handleClickNext = async (e) => await router.push(`/storeId/kiosk/confirm`);
  return (
    <div className={`container px-4 mx-auto h-full`}>
      <div className={`flex h-full`}>
        <div className="md:w-8/12 px-4 py-4 flex flex-col">
          <KioskCategorybar />
          <div className={`flex flex-wrap h-full`}>
            {data.map(item => (
                <button key={item.menuName} className={`flex flex-col justify-center items-center w-1/4 py-2 px-4`} onClick={handleClickMenu}>
                  <MenuItem menuName={item.menuName} img={item.img} />
                </button>
            ))}
          </div>
        </div>
        <div className="md:w-4/12 px-2 py-2 flex flex-col">
          <div className={`bg-blueGray-100 flex-col px-4 py-4 h-full rounded-lg shadow-lg`}>
            <div className={`flex flex-col w-full h-full justify-between bg-white rounded-lg shadow-xl my-2 overflow-y-auto px-4 py-4`} style={{height: '60%'}}>
              <div className={`flex flex-col`}>
                <span className={`mb-2 text-xl`}>온도</span>
                <div className={`flex justify-between`}>
                  <button className="flex-1 mr-2 text-xl bg-teal-500 text-white active:bg-teal-600 font-bold uppercase text-sm px-6 py-3 rounded-full shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">
                    핫
                  </button>
                  <button className="flex-1 ml-2 text-xl bg-teal-500 text-white active:bg-teal-600 font-bold uppercase text-sm px-6 py-3 rounded-full shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">
                    아이스
                  </button>
                </div>
              </div>
              <div className={`flex flex-col`}>
                <span className={`mb-2 text-xl`}>샷추가</span>
                <div className={`flex justify-between`}>
                  <button className="flex-1 mr-2 text-xl bg-teal-500 text-white active:bg-teal-600 font-bold uppercase text-sm px-6 py-3 rounded-full shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">
                    1번
                  </button>
                  <button className="flex-1 ml-2 text-xl bg-teal-500 text-white active:bg-teal-600 font-bold uppercase text-sm px-6 py-3 rounded-full shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">
                    2번
                  </button>
                </div>
              </div>
              <div className={`flex flex-col`}>
                <span className={`mb-2 text-xl`}>시럽</span>
                <div className={`flex justify-between`}>
                  <button className="flex-1 mr-2 text-xl bg-teal-500 text-white active:bg-teal-600 font-bold uppercase text-sm px-6 py-3 rounded-full shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">
                    1번
                  </button>
                  <button className="flex-1 ml-2 text-xl bg-teal-500 text-white active:bg-teal-600 font-bold uppercase text-sm px-6 py-3 rounded-full shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">
                    2번
                  </button>
                </div>
              </div>

            </div>
            <div className={`w-full bg-white rounded-lg shadow-xl my-2 overflow-y-auto flex flex-col px-2 py-2`} style={{height: '20%'}}>
              <span>아메리카노</span>
              <span>카페라떼</span>
              <span>콜드브루</span>
            </div>
            <div className={`w-full mx-auto my-2 flex justify-between items-center`} style={{height: '20%'}}>
              <button onClick={handleClickPrevious} className="bg-blueGray-500 text-white bg-blueGray-600 font-bold uppercase text-base px-8 py-3 rounded shadow-md hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">
                이전
              </button>
              <button onClick={handleClickNext} className="bg-blueGray-500 text-white bg-blueGray-600 font-bold uppercase text-base px-8 py-3 rounded shadow-md hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">
                다음
              </button>
            </div>
          </div>
        </div>
      </div>
      <div></div>
    </div>
  )
}

Menu.layout = Kiosk;