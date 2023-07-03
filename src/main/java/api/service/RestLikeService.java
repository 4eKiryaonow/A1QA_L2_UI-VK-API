package api.service;

import api.utils.RestUtil;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static api.constant.EndPoints.IS_LIKED;
import static api.constant.parameter.KeyParameter.ITEM_ID_KEY;
import static api.constant.parameter.KeyParameter.ITEM_TYPE_KEY;
import static api.constant.parameter.ValueParameter.POST_TYPE;
import static api.constant.response.KeyResponse.POST_IS_LIKED;

public class RestLikeService {
    public Response postIsLikedResponse(String postId) {
        Map<String, String> params = new HashMap<>();
        params.put(ITEM_ID_KEY, postId);
        params.put(ITEM_TYPE_KEY, POST_TYPE);
        return RestUtil.postWithParams(IS_LIKED, params);
    }

    public int postIsLiked(Response response) {
        return response.path(POST_IS_LIKED);
    }
}