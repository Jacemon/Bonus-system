package by.jcompany.bonus_system.function;

import by.jcompany.bonus_system.model.Request;
import by.jcompany.bonus_system.model.Response;
import by.jcompany.bonus_system.model.dto.RoleDto;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RoleFunctions extends Functions {
    public static String createRole(String roleName, int roleAccessLevel) {
        try {
            connection.makeRequest(new Request("CREATE_ROLE", new RoleDto(roleName, roleAccessLevel)));
            Response response = connection.getResponse();
            if (!response.isError()) {
                return (String) response.getResponseObject(String.class);
            }
            return (String) response.getResponseObject(String.class);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
    
    public static List<RoleDto> readAllRoles() {
        try {
            connection.makeRequest(new Request("READ_ALL_ROLES", null));
            Response response = connection.getResponse();
            if (!response.isError()) {
                Type type = new TypeToken<ArrayList<RoleDto>>() {
                }.getType();
                @SuppressWarnings("unchecked")
                List<RoleDto> roles = (List<RoleDto>) response.getResponseObject(type);
                return roles;
            }
            return null;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
    
    public static String updateRole(String roleName, Integer roleAccessLevel) {
        try {
            connection.makeRequest(new Request("UPDATE_ROLE", new RoleDto(roleName, roleAccessLevel)));
            Response response = connection.getResponse();
            if (!response.isError()) {
                return (String) response.getResponseObject(String.class);
            }
            return (String) response.getResponseObject(String.class);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
    
    public static String deleteRole(String roleName) {
        try {
            connection.makeRequest(new Request("DELETE_ROLE", roleName));
            Response response = connection.getResponse();
            if (!response.isError()) {
                return (String) response.getResponseObject(String.class);
            }
            return (String) response.getResponseObject(String.class);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
