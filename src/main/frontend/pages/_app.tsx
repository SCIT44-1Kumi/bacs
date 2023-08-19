import '@/styles/globals.css'
import { AppProps } from 'next/app'
import { Inter } from "next/font/google";
import { appWithTranslation } from 'next-i18next'

const inter = Inter({subsets:['latin'], weight: "400"});

const MyApp = ({ Component, pageProps }: AppProps)  => {
  return <main className={`p-24 ${inter.className}`}>
  <Component {...pageProps} />
  </main>
};

export default appWithTranslation(MyApp);
