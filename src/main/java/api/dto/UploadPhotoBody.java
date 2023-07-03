package api.dto;

import lombok.Data;
@Data
public class UploadPhotoBody {
    private String server;
    private String photo;
    private String hash;
}