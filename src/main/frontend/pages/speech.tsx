import { SetStateAction, useState } from "react";
// @ts-ignore
import * as speech from "react-speech-kit";

function Speech() {
	const [value, setValue] = useState("결과");

	const { listen, listening, stop } = speech.useSpeechRecognition({
		onResult: (result: SetStateAction<string>) => {
			setValue(result);
		}
	});
	const onClickRecord = async () => {
		listen();
		setTimeout(() => {
			stop();
		},  8000);
	}

	return (
		<div>
			<h2>음성인식</h2>

			<div>{value}</div>

			<button onClick={onClickRecord}>
				🎤speech
			</button>

			{listening && <div>음성인식 중</div>}
		</div>
	);
}

export default Speech;