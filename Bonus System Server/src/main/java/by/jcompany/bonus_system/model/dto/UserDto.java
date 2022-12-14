package by.jcompany.bonus_system.model.dto;

import by.jcompany.bonus_system.entity.User;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private Integer id;
    private String login;
    private byte[] passwordHash;
    
    private EmployeeDto employee;
    
    private RoleDto role;
    
    public UserDto(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.passwordHash = null;
        this.role = new RoleDto(user.getRole(), true);
        this.employee = null;
        if (user.getEmployee() != null) {
            this.employee = new EmployeeDto(user.getEmployee()/*, true*/);
        }
    }
    
    public UserDto(User user, boolean clean) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.passwordHash = null;
        this.role = null;
        this.employee = null;
    }
    
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class UserPair {
        User user;
        byte[] passwordHash;
    }
}
