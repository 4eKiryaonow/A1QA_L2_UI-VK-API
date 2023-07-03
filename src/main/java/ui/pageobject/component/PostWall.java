package ui.pageobject.component;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PostWall extends Form {
    private static By postWallLocator = By.id("page_wall_posts");

    public PostWall() {
        super(postWallLocator, "Post Wall");
    }

    public Post getPost(String userId, String postId) {
        return new Post(userId, postId);
    }
}