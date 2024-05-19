package bangshop.music.controller;

import bangshop.music.model.dto.EmployeeDTO;
import bangshop.music.model.dto.Role;
import bangshop.music.model.service.EmployeeService;
import bangshop.music.view.menu.StorageAdminView;
import bangshop.music.view.menu.StoreManagerView;

import java.util.Map;

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController() {
        employeeService = new EmployeeService();
    }

    public void signUp(Map<String, String> parameter) {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setName(parameter.get("name"));
        employee.setId(parameter.get("id"));
        employee.setPassword(parameter.get("password"));
        employee.setRoleNo(Role.STORE_MANAGER.getRoleNo());

        if (!isUnique(parameter.get("id"))) {
            System.out.println("이미 존재하는 아이디입니다.");
            return;
        }

        if (employeeService.registerEmployee(employee)) {
            System.out.println("회원가입을 완료하였습니다.");
        } else {
            System.out.println("회원가입에 실패하였습니다.");
        }
    }

    private boolean isUnique(String id) {
        return employeeService.findEmployeeById(id) == null;
    }


    public void signIn(Map<String, String> parameter) {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(parameter.get("id"));
        employee.setPassword(parameter.get("password"));

        EmployeeDTO foundEmployee = employeeService.findEmployeeById(employee.getId());
        if (foundEmployee == null) {
            System.out.println("존재하지 않는 아이디입니다.");
        } else if (!foundEmployee.getPassword().equals(employee.getPassword())) {
            System.out.println("잘못된 비밀번호입니다.");
        } else if (foundEmployee.getRoleNo() == Role.STORAGE_ADMIN.getRoleNo()) {
            new StorageAdminView().storageAdminMenu();
        } else {
            new StoreManagerView().storeManagerMenu();
        }
    }
}
