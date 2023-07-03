package util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtil {
    public static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, false);
    }
}