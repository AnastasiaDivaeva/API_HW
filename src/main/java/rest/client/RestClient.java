package rest.client;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestClient<T> {

    private String url;

    public RestClient(String url) {
        this.url = url;
    }

    private static final String CONTENT_TYPE_HEADER_NAME = "Content-Type";
    private static final String APPLICATION_JSON_MEDIA_TYPE = "application/json";

    public Response getEntity(int id) {
        return given().when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .get(url + id);
    }

    public Response getEntity() {
        return given().when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .get(url);
    }

    public Response postEntity(T body) {
        return given()
                .header(CONTENT_TYPE_HEADER_NAME, APPLICATION_JSON_MEDIA_TYPE)
                .body(body)
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .post(url);
    }

    public Response deleteEntity(int id) {
        return given().when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .delete(url + id);
    }

    public Response updateEntity(T petToUpdate) {
        return given()
                .header(CONTENT_TYPE_HEADER_NAME, APPLICATION_JSON_MEDIA_TYPE)
                .body(petToUpdate)
                .when()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .put(url);
    }
}
