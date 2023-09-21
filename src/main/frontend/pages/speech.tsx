import { SetStateAction, useState } from "react";
// @ts-ignore
import * as speech from "react-speech-kit";
import axios from "axios";

function Speech() {
	const [value, setValue] = useState("결과");

	const { listen, listening, stop } = speech.useSpeechRecognition({
		onResult: async (result: SetStateAction<string>) => {
			setValue(result);
			await axios.post("/api/nlp/test1", {
				text: result,
			});
		},
	});
	const onClickRecord = async () => {
		listen();
		setTimeout(async () => {
			await stop();
		}, 8000);
	};
	const reqValue = async (text: string) => {
		console.log(value);
		return await axios.post("/api/nlp/test1", {
			text,
		});
	};

	return (
		<div>
			<h2>음성인식</h2>

			<div>{value}</div>

			<button onClick={onClickRecord}>🎤speech</button>

			{listening && <div>음성인식 중</div>}
		</div>
	);
}

export default Speech;
