package helpers;


public enum Browsers {
        chrome("chrome"),
        firefox("firefox"),
        opera("opera"),
        safari("safari"),
        ie("internet explorer");
        String browserName;
        Browsers(String browserName) {
            this.browserName = browserName;
        }


    public String getBrowserName() {
            return browserName;
        }

    public static Browsers getEnumByLabel(String label) {
        for(Browsers browser : values()) {
            if (browser.getBrowserName().equals(label)) {
                return browser;
            }
        }
        return null;
    }
}

