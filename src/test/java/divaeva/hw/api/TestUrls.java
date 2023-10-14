package divaeva.hw.api;

public enum TestUrls {

    BASE_SERVER_URL_PET("https://petstore.swagger.io/v2/pet/"),
    BASE_SERVER_URL_STORE("https://petstore.swagger.io/v2/store/order/"),
    BASE_SERVER_URL_STORE_INVENTORY("https://petstore.swagger.io/v2/store/inventory");
    private final String url;

    public String getUrl() {
        return url;
    }

    TestUrls(String s) {
        url = s;
    }
}
