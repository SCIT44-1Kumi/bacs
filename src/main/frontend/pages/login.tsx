"use client";
import SignForm from "@/components/signForm";
import { useState } from "react";
import { useForm } from "react-hook-form";
import axios from "axios";

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
	const handleIsSignUp = () => {
		setIsSignUp(prev => !prev);
	};
	const onSubmit = async (data: ISignForm) => {
		console.log(data);
		const { userId, userPw, confirmPw, phone, email } = data;
		if (confirmPw) {
			await axios.post("/member/join", data);
		} else {
			await axios.post(`/member/temp-login`, data);
		}
		return;
	};
	return (
		<div className={`grid grid-cols-2`}>
			<div>
				<div className={`text-2xl`}>매장관리, 키오스크 한번에 BAC!</div>
				<div className={`text-2xl`}>B A C S</div>
			</div>
			<form
				onSubmit={handleSubmit(onSubmit)}
				className={`grid grid-cols-1 place-items-center gap-4`}>
				<SignForm isSignUp={isSignUp} register={register} />

				<div className={`grid grid-cols-1 place-items-center w-full`}>
					<div className={`flex justify-between w-1/2`}>
						<input
							type="button"
							onClick={handleIsSignUp}
							value={isSignUp ? "로그인하기" : "회원가입"}
						/>
						<input type="submit" value="확인" />
					</div>
				</div>
			</form>
		</div>
	);
};

export default Login;
