package api.utils;

import api.constant.EndPoints;
import hoard.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static api.constant.parameter.KeyParameter.ACCESS_TOKEN_KEY;
import static api.constant.parameter.KeyParameter.VERSION_KEY;
import static io.restassured.RestAssured.given;

public class RestUtil {

    private static RequestSpecification getRequestSpecification() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(EndPoints.BASE_URL)
                .addQueryParam(ACCESS_TOKEN_KEY, ConfigManager.getToken())
                .addQueryParam(VERSION_KEY, ConfigManager.getVersion())
                .log(LogDetail.ALL)
                .build();
        return requestSpecification;
    }

    public static Response postWithParams(String uri, Map<String, String> params) {
        RequestSpecification requestSpecification = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
        for (Map.Entry<String, String> param : params.entrySet()) {
            requestSpecification.queryParam(param.getKey(), param.getValue());
        }
        return requestSpecification.post(uri);
    }

    public static Response getNoParams(String uri) {
        return given(getRequestSpecification())
                .get(uri);
    }
}