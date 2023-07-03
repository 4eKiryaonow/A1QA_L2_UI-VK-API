package hoard;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

import static constant.PathConstants.PATH_CONFIG;
import static constant.PathConstants.PATH_TEST_DATA;

public abstract class FileManager {
	public static ISettingsFile getConfig() {
		return new JsonSettingsFile(PATH_CONFIG);
	}

	public static ISettingsFile getTestData() {
		return new JsonSettingsFile(PATH_TEST_DATA);
	}
}