import Link from "next/link";

export default function NavBar(){
	return <div className={`grid grid-rows-1 w-full`}>
		<div className={`col-span-2`}>
			<Link href={'/'}>BACS</Link>
		</div>
		<div>
			<Link href={'/'}>소개</Link>
		</div>
		<div>
			<Link href={'/'}>BACS</Link>
		</div>
		<div>
			<Link href={'/'}>BACS</Link>
		</div>
	</div>
}