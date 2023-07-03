package util;

import api.dto.SavedPhotoBody;

import static api.constant.parameter.KeyParameter.PHOTO_KEY;

public class StringBuilderUtil {
    public static String buildPhotoId(SavedPhotoBody savedPhotoBody) {
        return PHOTO_KEY +
                savedPhotoBody.getOwner_id() +
                "_" +
                savedPhotoBody.getId();
    }
}