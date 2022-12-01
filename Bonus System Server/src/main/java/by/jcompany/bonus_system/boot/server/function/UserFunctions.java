package by.jcompany.bonus_system.boot.server.function;

import by.jcompany.bonus_system.entity.User;

import java.util.List;

public class UserFunctions extends Functions {
    public static boolean createUser(User user) {
        user.setRole(roleService.read(user.getRole().getName()));
        return userService.create(user);
    }
    
    public static List<User> readAllUsers() {
        return userService.readAll();
    }
    
    public static boolean deleteUser(Integer userId) {
        return false;// todo
    }
    
    public static boolean changeUserPassword(Integer userId, byte[] newPasswordHash) {
        return false; // todo
    }
    
    public static boolean changeUserLogin(Integer userId, String newLogin) {
        return false; //todo
    }
}
