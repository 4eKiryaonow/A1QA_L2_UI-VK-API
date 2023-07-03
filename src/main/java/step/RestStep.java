package step;

import api.dto.SavedPhotoBody;
import api.dto.UploadPhotoBody;
import api.service.RestLikeService;
import api.service.RestPhotoService;
import api.service.RestWallService;
import api.utils.ResponseParser;
import hoard.TestDataManager;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import util.StringBuilderUtil;

import static api.constant.response.ValueResponse.IS_LIKED_TRUE;
import static org.apache.http.HttpStatus.SC_OK;

public class RestStep {
    private RestPhotoService restPhotoService;
    private RestWallService restWallService;
    private RestLikeService restLikeService;

    public RestStep() {
        this.restPhotoService = new RestPhotoService();
        this.restWallService = new RestWallService();
        this.restLikeService = new RestLikeService();
    }
    public String uploadTestPhotoAndGetPhotoId() {
        Response response = restPhotoService.uploadPhotoResponse(TestDataManager.getPathPostPhoto());
        Assert.assertEquals(response.statusCode(), SC_OK, String.format("Status code is not %s", SC_OK));
        String responseUploadPhoto = restPhotoService.getBodyUploadPhoto(response);
        UploadPhotoBody uploadPhotoBody = ResponseParser.parseResponseUploadPhoto(responseUploadPhoto);
        response = restPhotoService.saveUploadedPhotoResponse(uploadPhotoBody);
        Assert.assertEquals(response.statusCode(), SC_OK, String.format("Status code is not %s", SC_OK));
        String responseSavePhoto = restPhotoService.saveUploadedPhoto(response);
        SavedPhotoBody savedPhotoBody = ResponseParser.parseResponseSavedPhoto(responseSavePhoto);
        String photoId = StringBuilderUtil.buildPhotoId(savedPhotoBody);
        return photoId;
    }
    public String editPostAndAttachPhoto(String message, String postId, User user) {
        String photoId = uploadTestPhotoAndGetPhotoId();
        Response response = restWallService.editPost(message, postId, photoId, user.getId());
        Assert.assertEquals(response.statusCode(), SC_OK, String.format("Status code is not %s", SC_OK));
        return photoId;
    }
    public String createNewPost(String message, User user) {
        Response response = restWallService.createPost(message, user.getId());
        Assert.assertEquals(response.statusCode(), SC_OK, String.format("Status code is not %s", SC_OK));
        return String.valueOf(restWallService.getPostId(response));
    }
    public String addComment(String message, String postId, User user) {
        Response response = restWallService.createComment(message,postId,user.getId());
        Assert.assertEquals(response.statusCode(), SC_OK, String.format("Status code is not %s", SC_OK));
        return String.valueOf(restWallService.getCommentId(response));
    }
    public void postIsLiked(String postId) {
        Response response = restLikeService.postIsLikedResponse(postId);
        Assert.assertEquals(response.statusCode(), SC_OK, String.format("Status code is not %s", SC_OK));
        Assert.assertEquals(restLikeService.postIsLiked(response), IS_LIKED_TRUE, "Post is not liked");
    }
    public void deletePost(String postId) {
        Response response = restWallService.deletePost(postId);
        Assert.assertEquals(response.statusCode(), SC_OK, String.format("Status code is not %s", SC_OK));
    }
}