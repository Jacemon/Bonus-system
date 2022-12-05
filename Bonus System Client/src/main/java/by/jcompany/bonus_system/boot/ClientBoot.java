package by.jcompany.bonus_system.boot;

import by.jcompany.bonus_system.function.EmployeeFunctions;
import by.jcompany.bonus_system.function.GeneralFunctions;
import by.jcompany.bonus_system.function.RoleFunctions;
import by.jcompany.bonus_system.function.TaskFunctions;

public class ClientBoot {
    public static void main(String[] args) {
/*        System.out.println(GeneralFunctions.login("login", "password"));
        System.out.println(GeneralFunctions.login("admin", "admin"));
        System.out.println(UserFunctions.createUser("login", "password"));
        System.out.println(UserFunctions.createUser("login", "password"));
        System.out.println(UserFunctions.readAllUsers());
        System.out.println(UserFunctions.readAllUsers());
        System.out.println(GeneralFunctions.logout());
        System.out.println(UserFunctions.readAllUsers());*/
        System.out.println(GeneralFunctions.login("admin", "admin"));
        //System.out.println(UserFunctions.createUser("login3", "password", "ADMIN"));
        //System.out.println(TaskFunctions.createTask("Just task", 12.0f, BonusDto.BonusType.MONEY));
        //System.out.println(EmployeeFunctions.createEmployee("EmplF", "EmplL"));
        System.out.println(EmployeeFunctions.readAllEmployees());
        System.out.println(TaskFunctions.readAllTasks());
        System.out.println(RoleFunctions.readAllRoles());
        //System.out.println(TaskFunctions.setTaskToEmployee(245, 140));
        //System.out.println(TaskFunctions.setTaskCompleted(167));
        //System.out.println(TaskFunctions.setTaskCompleted(245));
        System.out.println(TaskFunctions.setPointCost(25.0f));
        System.out.println(TaskFunctions.setPointCost(null));
        System.out.println(TaskFunctions.setPointCost(250.0f));
        System.out.println(EmployeeFunctions.calculateBonuses(140));
        //System.out.println(UserFunctions.setUserEmployee(238, 140));
        GeneralFunctions.quit();
    }
}
