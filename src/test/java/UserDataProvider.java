import hoard.TestDataManager;
import model.User;
import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.List;
public class UserDataProvider {
    @DataProvider(name = "User Provider")
    public static Object[][] UserDataProvider() {
        List<User> userList = new ArrayList<>();
        userList.add(TestDataManager.getUser());
        Object[][] objects = new Object[userList.size()][];
        for (int i = 0; i < userList.size(); i++) {
            objects[i] = new Object[1];
            objects[i][0] = userList.get(i);
        }
        return objects;
    }
}
