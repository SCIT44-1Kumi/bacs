import fs from "fs";
import request from "request";
import { NextApiRequest, NextApiResponse } from "next";
import axios, { AxiosResponse } from "axios";

const clientId = process.env["X-NCP-APIGW-API-KEY-ID"]
const clientSecret = process.env["X-NCP-APIGW-API-KEY"];


export default async function handler(
	req: NextApiRequest,
	res: NextApiResponse
) {
	const data = await axios.post(`https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=Kor`, fs.createReadStream(`/Users/hwikun/Downloads/voice/test.mp3`), {
		headers: {
			'Content-Type': 'application/octet-stream',
			'X-NCP-APIGW-API-KEY-ID': clientId,
			'X-NCP-APIGW-API-KEY': clientSecret
		}
	});
	console.log(data.data);
	res.status(200).json(data.data);
	// res.status(200).json({ name: 'John Doe' })
}

// language => 언어 코드 ( Kor, Jpn, Eng, Chn )
// function stt(language: string, filePath: string) {
// 	const url = `https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=${language}`;
// 	const requestConfig = {
// 		url: url,
// 		method: 'POST',
// 		headers: {
// 			'Content-Type': 'application/octet-stream',
// 			'X-NCP-APIGW-API-KEY-ID': clientId,
// 			'X-NCP-APIGW-API-KEY': clientSecret
// 		},
// 		body: fs.createReadStream(filePath)
// 	};
//
// 	request(requestConfig, (err, response, body) => {
// 		if (err) {
// 			console.log(err);
// 			return;
// 		}
//
// 		console.log(response.statusCode);
// 		console.log(body);
// 	});
// }
//
// stt('Kor', '/Users/hwikun/Downloads/voice/test.mp3');