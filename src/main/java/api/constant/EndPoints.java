package api.constant;

import hoard.ConfigManager;

public final class EndPoints {
    public static final String BASE_URL = ConfigManager.getUrlAPI();
    public static final String CREATE_POST = "wall.post/";
    public static final String EDIT_POST = "wall.edit/";
    public static final String GET_UPLOAD_WALL_SERVER = "photos.getWallUploadServer";
    public static final String SAVE_WALL_PHOTO = "photos.saveWallPhoto";
    public static final String CREATE_COMMENT = "wall.createComment";
    public static final String IS_LIKED = "likes.isLiked";
    public static final String DELETE_POST = "wall.delete";
}