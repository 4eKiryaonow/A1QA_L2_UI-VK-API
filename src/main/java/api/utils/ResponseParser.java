package api.utils;

import api.dto.SavedPhotoBody;
import api.dto.UploadPhotoBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import util.LoggerManager;

import java.io.IOException;

import static api.constant.IndexConstants.INDEX_PHOTO_RESPONSE;
import static api.constant.response.KeyResponse.*;

public class ResponseParser {

    public static UploadPhotoBody parseResponseUploadPhoto(String body) {
        ObjectMapper mapper = new ObjectMapper();
        UploadPhotoBody uploadPhotoBody = null;
        try {
            uploadPhotoBody = mapper.readValue(body, UploadPhotoBody.class);
        } catch (IOException e) {
            LoggerManager.error(e.getMessage());
            e.printStackTrace();
        }
        return uploadPhotoBody;
    }

    public static SavedPhotoBody parseResponseSavedPhoto(String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode;
        try {
            rootNode = objectMapper.readTree(body);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        JsonNode responseNode = rootNode.path(RESPONSE_KEY).get(INDEX_PHOTO_RESPONSE);
        SavedPhotoBody savedPhotoBody = new SavedPhotoBody();
        savedPhotoBody.setId(responseNode.path(PHOTO_ID_KEY).toString());
        savedPhotoBody.setOwner_id(responseNode.path(PHOTO_OWNER_ID_KEY).toString());
        return savedPhotoBody;
    }
}