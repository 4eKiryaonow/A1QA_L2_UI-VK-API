package hoard;

import com.google.gson.Gson;
import model.User;

import static constant.KeyTestDataConstants.*;
import static constant.PathConstants.PATH_POST_PHOTO;

public abstract class TestDataManager {

    public static int getLengthRandomString() {
        return (Integer) FileManager.getTestData().getValue(LENGTH_STRING_KEY);
    }
    public static String getPathPostPhoto() {
        String path = System.getProperty("user.dir") + PATH_POST_PHOTO;
        return path;
    }
    public static User getUser() {
        User user;
        Gson gson = new Gson();
        String userFromJson = FileManager.getTestData().getValue(USER_KEY).toString();
        user = gson.fromJson(userFromJson, User.class);
        return user;
    }
}