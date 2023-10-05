/** @type {import('next').NextConfig} */
const { i18n } = require("./next-i18next.config");
const nextConfig = {
	reactStrictMode: true,
	i18n,
	images: {
		remotePatterns: [
			{
				protocol: "http",
				hostname: "api.qrserver.com",
				port: "",
				pathname: "/**",
			},
		],
	},
	async rewrites() {
		return [
			{
				source: "/api/:path*",
				destination: "http://localhost:8888/bacs/:path*",
			},
		];
	},
	experimental: {
		appDir: false,
	},
};

module.exports = nextConfig;
