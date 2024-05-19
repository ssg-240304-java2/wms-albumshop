package bangshop.music.controller;

import bangshop.music.model.dto.EmployeeDTO;
import bangshop.music.model.service.EmployeeService;

import java.util.Map;

// WIP

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController() {
        employeeService = new EmployeeService();
    }

    public void saveEmployee(Map<String, String> parameter) {
        String id = parameter.get("id");
        String password = parameter.get("password");

        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(id);
        employee.setPassword(password);
    }
}
