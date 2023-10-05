"use client";
import SignForm from "@/components/login/signForm";
import { useState } from "react";
import { useForm } from "react-hook-form";
import axios from "axios";
import localFont from "next/font/local";
import { useRouter } from "next/router";
import API from "@/utils/axiosApi";

const myFont = localFont({ src: "../public/fonts/BMHANNA.otf" });

export type ISignForm = {
	userId: string;
	userPw: string;
	confirmPw: string;
	phone: string;
	email: string;
};
const Login = () => {
	const [isSignUp, setIsSignUp] = useState(false);
	const { control, register, handleSubmit } = useForm<ISignForm>();
	const router = useRouter();
	const handleIsSignUp = () => {
		setIsSignUp(prev => !prev);
	};
	const onSubmit = async (data: ISignForm) => {
		console.log(data);
		const { userId, userPw, confirmPw, phone, email } = data;
		if (confirmPw) {
			const { data: user } = await API.post("/member/join", data);
			console.log(user);
		}
		// else {
		// 	await axios.post(`/api/member/temp-login`, data);
		// }
		return router.push(`/${userId}/admin/store`);
	};
	return (
		<div className={`loginBackground p-12`}>
			<div className={`login grid grid-cols-2`}>
				<div className={`grid place-items-center`}>
					<div>
						<div className={`text-3xl ${myFont.className}`}>매장관리, 키오스크 한번에 BAC!</div>
						<div className={`text-3xl text-center ${myFont.className}`}>B A C S</div>
					</div>
				</div>
				<form
					onSubmit={handleSubmit(onSubmit)}
					className={`grid grid-cols-1 place-items-center gap-4`}>
					<SignForm isSignUp={isSignUp} register={register} />
					<div className={`grid grid-cols-1 place-items-center w-full`}>
						<div className={`${myFont.className} text-2xl flex justify-between w-4/6`}>
							<input
								className={`signButton`}
								type="button"
								onClick={handleIsSignUp}
								value={isSignUp ? "로그인하기" : "회원가입"}
							/>
							<input className={`signButton`} type="submit" value="확인" />
						</div>
					</div>
				</form>
			</div>
		</div>
	);
};

export default Login;
