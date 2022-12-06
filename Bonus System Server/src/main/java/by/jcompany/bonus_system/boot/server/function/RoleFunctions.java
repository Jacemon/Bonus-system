package by.jcompany.bonus_system.boot.server.function;

import by.jcompany.bonus_system.entity.Role;
import by.jcompany.bonus_system.entity.User;

import java.util.List;

public class RoleFunctions extends Functions {
    public static boolean createRole(Role role) {
        return roleService.create(role);
    }
    
    public static List<Role> readAllRoles() {
        return roleService.readAll();
    }
    
    public static boolean deleteRole(String roleName) {
        return false; //todo
    }
    
    public static boolean changeRoleAccessLevel(String roleName, Integer newAccessLevel) {
        return false; //todo
    }
    
    public static Integer readRoleAccessLevel(Role role) {
        if (role == null) {
            return null;
        }
        Role dbRole = roleService.read(role.getName());
        if (dbRole != null) {
            return dbRole.getAccessLevel();
        }
        return null;
    }
}