/** @type {import('next').NextConfig} */
const { i18n } = require('./next-i18next.config')
const nextConfig = {
  reactStrictMode: true,
  i18n,
  async rewrites() {
    return [
      {
        source: "/:path*",
        destination: "http://localhost:8888/bacs/:path*",
      },
    ];
  },

}

module.exports = nextConfig;
