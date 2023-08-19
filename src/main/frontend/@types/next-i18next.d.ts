import "react-i18next";
import common from "@public/locales/ko/common.json";

declare module "react-i18next" {
	interface CustomTypeOptions {
		defaultNS: "common";
		resources: {
			common: typeof common;
			nav: typeof nav;
		};
	}
}