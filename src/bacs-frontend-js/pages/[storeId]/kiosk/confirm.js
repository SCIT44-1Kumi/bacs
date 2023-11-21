import Kiosk from "../../../layouts/Kiosk";
import ConfirmMenuItem from "../../../components/Kiosk/ConfirmMenuItem";
import {useRouter} from "next/router";

export default function Confirm() {
  const router = useRouter();
  return (
  <div className={`flex flex-col items-center h-full w-full py-8 px-8`}>
    <span className={`text-4xl justify-self-start mb-4`}>주문 확인</span>
    {/*<div className={`flex flex-col w-full h-full px-4 py-4`}>*/}
    <div className={`overflow-scroll grid grid-cols-1 gap-2 place-items-center w-full h-full p-4`}>

      <ConfirmMenuItem menuName={'아메리카노'} option={`아이스, 샷추가`} price={5000} img={`http://www.breadnco.kr/wp-content/uploads/2023/09/%EC%95%84%EC%9D%B4%EC%8A%A4%EC%95%84%EB%A9%94%EB%A6%AC%EC%B9%B4%EB%85%B8_%EB%A6%AC%EC%82%AC%EC%9D%B4%EC%A7%95.png`} />

      <ConfirmMenuItem menuName={'카페라떼'} option={`핫`} price={5000} img={`https://image.aladin.co.kr/product/8883/76/cover500/s572635127_2.jpg`} />

      <ConfirmMenuItem menuName={'콜드브루'} option={`샷추가`} price={5500} img={`http://www.dunkindonuts.co.kr/upload/product/1607136351.png`} />

      <div className={`flex items-center justify-end w-full bg-gray-100 rounded-lg shadow-lg px-4 py-4`}>
        <span>총 금액 15500원</span>
      </div>
    </div>
    <div className={`self-end justify-self-end flex justify-between items-center w-full px-4`}>
      <button onClick={() => router.push('/storeid/kiosk/menu')} className="text-white bg-blueGray-600 font-bold uppercase text-base px-8 py-3 rounded shadow-md hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">
        취소
      </button>
      <button onClick={() => router.push('/storeid/kiosk/receipt')} className="text-white bg-blueGray-600 font-bold uppercase text-base px-8 py-3 rounded shadow-md hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">
        다음
      </button>
    </div>
  </div>
  )
}

Confirm.layout = Kiosk;