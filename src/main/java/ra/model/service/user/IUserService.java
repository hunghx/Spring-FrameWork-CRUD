package ra.model.service.user;
import ra.model.entity.User;
import ra.model.service.*;

public interface IUserService extends IService<User,Integer>{
    User login(User user);
    boolean checkExistsUsername(String username);
}
