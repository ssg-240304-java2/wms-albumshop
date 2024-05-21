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
    @DisplayName("사용자는 로그인 할 수 있다.")
    void login() {
        // given
        EmployeeDTO employee = createEmployee();
        employeeService.registerEmployee(employee);

        // when
        EmployeeDTO foundEmployee = employeeService.findEmployeeById(employee.getId());

        // then
        assertThat(employee.getId()).isEqualTo(foundEmployee.getId());
        assertThat(employee.getPassword()).isEqualTo(foundEmployee.getPassword());

        // clean up
        employeeService.removeEmployeeById(employee.getId());
    }

    @Test
    @DisplayName("관리자는 이름으로 직원을 조회할 수 있다.")
    void searchEmployeeByName() {
        // given
        EmployeeDTO employee = createEmployee();

        // when
        employeeService.registerEmployee(employee);

        // then
        List<EmployeeDTO> employees = employeeService.findEmployeeByName(employee.getName());
        employees.forEach(e -> assertThat(e.getName()).contains(employee.getName()));
    }

    @Test
    @DisplayName("관리자는 지점명이나 주소로 지점을 조회할 수 있다.")
    void searchStoreByKeyword() {
        // given
        String keyword = "하늘";

        // when
        List<StoreDTO> stores = employeeService.findStoreByKeyword(keyword);

        // then
        stores.forEach(s -> {
            boolean doesNameContainsKeyword = s.getStoreName().contains(keyword);
            boolean doesAddressContainsKeyword = s.getStoreAddress().contains(keyword);
            assertThat(doesNameContainsKeyword || doesAddressContainsKeyword).isTrue();
        });
    }

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
