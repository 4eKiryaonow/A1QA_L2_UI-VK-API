package hoard;

import static constant.KeyConfigConstants.*;

public class ConfigManager {
    public static String getUrlUI() {
        return FileManager.getConfig().getValue(URL_KEY).toString();
    }

    public static String getUrlAPI() {
        return FileManager.getConfig().getValue(BASE_URL_KEY).toString();
    }

    public static String getToken() {
        return FileManager.getConfig().getValue(TOKEN_KEY).toString();
    }

    public static String getVersion() {
        return FileManager.getConfig().getValue(VERSION_KEY).toString();
    }
}