import Image from "next/image";

export default function MenuItem({img, menuName}) {
  return (
    <>
      <div className={`relative overflow-hidden`}>
        <Image src={img} alt={`menuImg`} width={200} height={200} objectFit={"cover"} objectPosition={"center"} />
      </div>
      <span>{menuName}</span>
    </>
  )
}