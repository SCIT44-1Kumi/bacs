import { useState } from "react";
import ApexChart from "react-apexcharts";

const Chart = () => {
	const [isLoading, setIsLoading] = useState(false);
	const [data, setData] = useState<number[]>([0]);
	return (
		<div>
			{isLoading ? (
				"로딩 중..."
			) : (
				<ApexChart
					options={{
						chart: {
							type: "line",
							height: 300,
							width: 500,
							background: "transparent",
							toolbar: {
								show: false,
							},
						},
					}}
					series={data}
					height={350}
					type={`line`}
				/>
			)}
		</div>
	);
};
export default Chart;
