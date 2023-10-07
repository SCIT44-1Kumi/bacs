import { UseFormRegister } from "react-hook-form";
import { ISignForm } from "@/pages/login";
import localFont from "next/font/local";

const myFont = localFont({ src: "../../public/fonts/BMHANNA.otf" });

type SignFormProps = {
	isSignUp: boolean;
	register: UseFormRegister<ISignForm>;
};
const SignForm = ({ isSignUp, register }: SignFormProps) => {
	return (
		<>
			<div className={`${myFont.className} text-3xl`}>{isSignUp ? "Sign Up" : "LOGIN"}</div>
			<div className={`grid grid-cols-1 gap-4 place-items-center w-full`}>
				<div className={`grid grid-cols-2 place-content-between items-center`}>
					{/*<div className={`flex justify-between w-1/2`}>*/}
					<div className={`${myFont.className}`}>ID</div>
					<input
						type="text"
						{...register("userId", { required: true })}
						className={`bg-gray-100 rounded-md`}
					/>
				</div>
				<div className={`grid grid-cols-2 place-content-between items-center`}>
					{/*<div className={`flex justify-between w-1/2`}>*/}
					<div className={`${myFont.className}`}>PASSWORD</div>
					<input
						type="password"
						{...register("userPw", { required: true })}
						className={`bg-gray-100 rounded-md`}
					/>
				</div>
				{isSignUp ? (
					<>
						<div className={`grid grid-cols-2 place-content-between items-center`}>
							<div className={`${myFont.className}`}>CONFIRM PASSWORD</div>
							<input
								type="password"
								{...register("confirmPw", { required: false })} // name="confirmPw" id="confirmPw"
								className={`bg-gray-100 rounded-md`}
							/>
						</div>
						<div className={`grid grid-cols-2 place-content-between items-center`}>
							<div className={`${myFont.className}`}>PHONE</div>
							<input
								type="text"
								{...register("phone", { required: false })} // name="phone" id="phone"
								className={`bg-gray-100 rounded-md`}
							/>
						</div>
						<div className={`grid grid-cols-2 place-content-between items-center`}>
							<div className={`${myFont.className}`}>EMAIL</div>
							<input
								type="email"
								{...register("email", { required: false })}
								className={`bg-gray-100 rounded-md`}
							/>
						</div>
					</>
				) : null}
				<div className={`grid grid-cols-1 w-1/2`}>
					<div className={`grid grid-cols-2 place-content-between items-center overflow-visible`}>
						<div></div>
						<div className={`${myFont.className} min-w-max`}>아이디/패스워드 찾기</div>
					</div>
				</div>
			</div>
		</>
	);
};

export default SignForm;
