import hoard.TestDataManager;
import model.User;
import org.testng.annotations.Test;
import step.RestStep;
import step.UserActionStep;
import ui.pageobject.component.Post;
import util.LoggerManager;
import util.RandomStringUtil;

public class VkUiApiTest extends BaseTest {
    @Test(dataProvider = "User Provider", dataProviderClass = UserDataProvider.class)
    public void createAndEditPostTest(User user) {
        UserActionStep userActionStep = new UserActionStep();
        RestStep restStep = new RestStep();
        LoggerManager.info("Step 2.[UI] Authorize");
        userActionStep.performAuthorize(user);
        LoggerManager.info("Step 3.[UI]Go to \"My profile\"");
        userActionStep.goToMyProfile();
        LoggerManager.info("Step 4.[API] Create post on the wall with randomly generated text using API-request and save id of the post from the API-response");
        String randomPostText = RandomStringUtil.getRandomString(TestDataManager.getLengthRandomString());
        String postId = restStep.createNewPost(randomPostText, user);
        LoggerManager.info("Step 5.[UI] Check that post with the sent text from the correct user appeared on the wall without refreshing the page");
        userActionStep.checkCreatedPost(user, postId, randomPostText);
        LoggerManager.info("Step 6.[API] Edit the added post using API-request - change text and add (upload) a picture");
        String newRandomText = RandomStringUtil.getRandomString(TestDataManager.getLengthRandomString());
        String photoId = restStep.editPostAndAttachPhoto(newRandomText, postId, user);
        LoggerManager.info("Step 7.[UI] Check that text was updated and the picture was uploaded (make sure that pictures are the same) without refreshing the page");
        Post post = userActionStep.checkEditedPost(user, postId, photoId, newRandomText);
        LoggerManager.info("Step 8.[API] Add a comment to the post with the randomly generated text using API-request");
        String commentText = RandomStringUtil.getRandomString(TestDataManager.getLengthRandomString());
        String commentId = restStep.addComment(commentText, postId, user);
        LoggerManager.info("Step 9.[UI] Check that comment from the correct user was added to the post without refreshing the page");
        userActionStep.checkCreatedComment(post, user, commentId);
        LoggerManager.info("Step 10.[UI] Like the post using UI");
        userActionStep.likePost(post);
        LoggerManager.info("Step 11.[API] Check that the post received like from the correct user using API-request");
        restStep.postIsLiked(postId);
        LoggerManager.info("Step 12.[API] Delete the post using API-request");
        restStep.deletePost(postId);
        LoggerManager.info("Step 13.[UI] Check that the post was deleted without refreshing the page");
        userActionStep.postIsDeleted(post);
    }
}