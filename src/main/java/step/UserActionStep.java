package step;

import model.User;
import org.testng.Assert;
import ui.pageobject.IdPageLogin;
import ui.pageobject.MainPage;
import ui.pageobject.component.Comment;
import ui.pageobject.component.Post;

public class UserActionStep {
    private MainPage mainPage;

    public UserActionStep() {
        this.mainPage = new MainPage();
    }

    public void performAuthorize(User user) {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page is not displayed");
        mainPage.loginForm().inputLogin(user.getLogin());
        mainPage.loginForm().clickSubmitBtn();
        IdPageLogin idPageLogin = new IdPageLogin();
        Assert.assertTrue(idPageLogin.state().waitForDisplayed(), "VK ID page is not displayed");
        idPageLogin.inputPassword(user.getPassword());
        idPageLogin.clickContinueBtn();
        Assert.assertTrue(mainPage.feedWall().state().waitForDisplayed(), "Feed wall is not displayed");
    }

    public void goToMyProfile() {
        mainPage.sideBar().clickMyPage();
        Assert.assertTrue(mainPage.profileHeader().state().waitForDisplayed(), "Profile Header is not displayed");
    }

    public Post checkCreatedPost(User user, String postId, String textPost) {
        Post post = mainPage.postWall().getPost(user.getId(), postId);
        Assert.assertEquals(post.getTextPost(), textPost, "Text doesn't match");
        Assert.assertTrue(post.getAuthorLink().contains(user.getId()), "Author id doesn't match");
        return post;
    }

    public Post checkEditedPost(User user, String postId, String photoId, String textPost) {
        Post post = mainPage.postWall().getPost(user.getId(), postId);
        Assert.assertEquals(post.getTextPost(), textPost, "Text doesn't match");
        Assert.assertTrue(post.getPhotoLink(photoId).contains(photoId));
        return post;
    }

    public Comment checkCreatedComment(Post post, User user, String commentId) {
        post.clickToShowComment();
        Comment comment = post.comment(user.getId(), commentId);
        Assert.assertTrue(comment.getAuthorLink().contains(user.getId()), "Author id doesn't match");
        return comment;
    }

    public void likePost(Post post) {
        post.clickLikeBtn();
    }

    public void postIsDeleted(Post post) {
        Assert.assertTrue(post.state().waitForNotDisplayed(), "Post isn't deleted");
    }
}