package bangshop.music.controller;

import bangshop.music.model.dto.EmployeeDTO;
import bangshop.music.model.dto.StoreDTO;
import bangshop.music.model.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@Transactional
public class cyTest {
    EmployeeService employeeService = new EmployeeService();

    @Test
    @DisplayName("관리자는 새로운 계정을 생성할 수 있다.")
    void createAccount() {
        // given
        EmployeeDTO employee = createEmployee();

        // when
        employeeService.registerEmployee(employee);

        // then
        EmployeeDTO foundEmployee = employeeService.findEmployeeById(employee.getId());
        assertThat(employee).isEqualTo(foundEmployee);

        // clean up
        employeeService.removeEmployeeById(employee.getId());
    }

    EmployeeDTO createEmployee() {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setName("이민");
        employee.setId("jamie93");
        employee.setPassword("jamie93");
        employee.setRoleNo(2);
        return employee;
    }
}
