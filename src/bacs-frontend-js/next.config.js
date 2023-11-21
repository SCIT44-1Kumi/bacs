
const nextConfig = {
  reactStrictMode: false,
  images: {
    remotePatterns: [
      {
        protocol: "http",
        hostname: "api.qrserver.com",
        port: "",
        pathname: "/**",
      },
      {
        protocol: "https",
        hostname: "t1.daumcdn.net",
        port: "",
        pathname: "/**",
      },
      {
        protocol: "https",
        hostname: "image.aladin.co.kr",
        port: "",
        pathname: "/**",
      },
      {
        protocol: "http",
        hostname: "www.dunkindonuts.co.kr",
        port: "",
        pathname: "/**",
      },
      {
        protocol: "http",
        hostname: "www.breadnco.kr",
        port: "",
        pathname: "/**",
      },
      {
        protocol: "https",
        hostname: "cdn.imweb.me",
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
