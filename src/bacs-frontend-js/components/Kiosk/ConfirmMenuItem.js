import Image from "next/image";

export default function ConfirmMenuItem({img, menuName, price, option}) {
  return (
      <div className={`flex justify-between items-center w-full bg-gray-100 rounded-lg shadow-lg px-4 py-4`}>
          <Image className={`rounded-full`} src={img} alt={`img`} width={120} height={120} objectFit={"cover"} objectPosition={"center"} />
        <div className={`flex flex-col justify-evenly`}>
          <span>{menuName}</span>
          <span>{option}</span>
        </div>
        <div>X 1</div>
        <div>{price}원</div>
      </div>
  )
}