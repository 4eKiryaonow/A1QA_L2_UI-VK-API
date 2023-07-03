package api.service;

import api.utils.RestUtil;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static api.constant.EndPoints.*;
import static api.constant.parameter.KeyParameter.*;
import static api.constant.response.KeyResponse.ID_RESPONSE_CREATE_COMMENT_KEY;
import static api.constant.response.KeyResponse.ID_RESPONSE_CREATE_POST_KEY;

public class RestWallService {
    public Response createPost(String message, String userId) {
        Map<String, String> params = new HashMap<>();
        params.put(MESSAGE_KEY, message);
        params.put(OWNER_ID_KEY, userId);
        return RestUtil.postWithParams(CREATE_POST, params);
    }

    public int getPostId(Response response) {
        return response.path(ID_RESPONSE_CREATE_POST_KEY);
    }

    public Response editPost(String message, String postId, String imageId, String userId) {
        Map<String, String> params = new HashMap<>();
        params.put(OWNER_ID_KEY, userId);
        params.put(POST_ID_KEY, postId);
        params.put(MESSAGE_KEY, message);
        params.put(ATTACHMENTS_KEY, imageId);
        return RestUtil.postWithParams(EDIT_POST, params);
    }

    public Response createComment(String message, String postId, String userId) {
        Map<String, String> params = new HashMap<>();
        params.put(OWNER_ID_KEY, userId);
        params.put(POST_ID_KEY, postId);
        params.put(MESSAGE_KEY, message);
        return RestUtil.postWithParams(CREATE_COMMENT, params);
    }

    public int getCommentId(Response response) {
        return response.path(ID_RESPONSE_CREATE_COMMENT_KEY);
    }

    public Response deletePost(String postId) {
        Map<String, String> params = new HashMap<>();
        params.put(POST_ID_KEY, postId);
        return RestUtil.postWithParams(DELETE_POST, params);
    }
}