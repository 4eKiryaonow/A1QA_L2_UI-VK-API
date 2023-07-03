package ui.pageobject.component;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;
import ui.utils.ConditionalWait;

public class Post extends BaseEntity {
    private String postPhotoLocator = "//a[@href='/%s']";
    private String likeButtonLocator = "//div[@data-reaction-target-object='wall%s_%s']";
    private By textPostLocator;
    private By likeBtnLocator;
    private By showNextComment = By.xpath("//span[@class='js-replies_next_label']");
    private Comment comment;

    public Post(String userId, String postId) {
        super(userId, postId);
        this.textPostLocator = By.xpath(String.format(entityTextLocator, userId, postId));
        this.likeBtnLocator = By.xpath(String.format(likeButtonLocator, userId, postId));
    }

    private ITextBox TextPost() {
        return getElementFactory().getTextBox(this.textPostLocator, "Text box");
    }

    private IButton LikeButton() {
        return getElementFactory().getButton(this.likeBtnLocator, "Like Button");
    }

    private ILabel postPhoto(String photoId) {
        By photoLocator = By.xpath(String.format(postPhotoLocator, photoId));
        ConditionalWait.waitUntilPresented(photoLocator);
        return getElementFactory().getLabel(photoLocator, "Photo");
    }

    public String getPhotoLink(String photoId) {
        return postPhoto(photoId).getAttribute(hrefAttribute);
    }

    public String getTextPost() {
        ConditionalWait.waitUntilPresented(this.textPostLocator);
        return this.TextPost().getText();
    }

    public void clickLikeBtn() {
        ConditionalWait.waitUntilClickable(this.likeBtnLocator);
        this.LikeButton().clickAndWait();
    }

    private ITextBox showNextCommentLink() {
        ConditionalWait.waitUntilPresented(showNextComment);
        return getElementFactory().getTextBox(showNextComment, "Link to show comment");
    }

    public void clickToShowComment() {
        showNextCommentLink().clickAndWait();
    }

    public Comment comment(String userId, String postId) {
        this.comment = new Comment(userId, postId);
        return this.comment;
    }
}