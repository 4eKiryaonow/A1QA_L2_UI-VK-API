package api.service;

import api.dto.UploadPhotoBody;
import api.utils.RestUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static api.constant.EndPoints.GET_UPLOAD_WALL_SERVER;
import static api.constant.EndPoints.SAVE_WALL_PHOTO;
import static api.constant.parameter.KeyParameter.*;
import static api.constant.response.KeyResponse.URL_UPLOAD_PHOTO_WALL_SERVER;
import static io.restassured.RestAssured.given;

public class RestPhotoService {
    public Response getWallUploadServerResponse() {
        return RestUtil.getNoParams(GET_UPLOAD_WALL_SERVER);
    }

    public String getUrlUploadWallPhotoServer() {
        return getWallUploadServerResponse().path(URL_UPLOAD_PHOTO_WALL_SERVER);
    }

    public Response uploadPhotoResponse(String path) {
        File imageFile = new File(path);
        return given()
                .contentType(ContentType.MULTIPART)
                .multiPart(PHOTO_KEY, imageFile)
                .post(getUrlUploadWallPhotoServer());
    }

    public String getBodyUploadPhoto(Response response) {
        return response.body().asString();
    }

    public Response saveUploadedPhotoResponse(UploadPhotoBody uploadPhotoBody) {
        Map<String, String> params = new HashMap<>();
        params.put(SERVER_KEY, uploadPhotoBody.getServer());
        params.put(PHOTO_KEY, uploadPhotoBody.getPhoto());
        params.put(HASH_KEY, uploadPhotoBody.getHash());
        return RestUtil.postWithParams(SAVE_WALL_PHOTO, params);
    }

    public String saveUploadedPhoto(Response response) {
        return response.getBody().asString();
    }
}