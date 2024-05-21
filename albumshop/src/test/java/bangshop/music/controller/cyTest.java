package bangshop.music.controller;

import bangshop.music.model.dao.EmployeeMapper;
import bangshop.music.model.dto.EmployeeDTO;
import bangshop.music.model.dto.StoreDTO;
import bangshop.music.model.service.EmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class cyTest {
    EmployeeService employeeService = new EmployeeService();
    EmployeeMapper employeeMapper;

    @Test
    @DisplayName("사용자는 로그인 할 수 있다.")
    void login() {
        // given
        EmployeeDTO employee = createEmployee();
        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            employeeMapper.insertEmployee(employee);
            sqlSession.commit();
        }

        // when
        EmployeeDTO foundEmployee;
        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            foundEmployee = employeeMapper.findEmployeeById(employee.getId());
            sqlSession.commit();
        }

        // then
        assertThat(employee.getId()).isEqualTo(foundEmployee.getId());
        assertThat(employee.getPassword()).isEqualTo(foundEmployee.getPassword());

        // clean up
        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            employeeMapper.removeEmployeeById(employee.getId());
            sqlSession.commit();
        }
    }

    @Test
    @DisplayName("관리자는 이름으로 직원을 조회할 수 있다.")
    void searchEmployeeByName() {
        // given
        EmployeeDTO employee = createEmployee();

        // when
        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            employeeMapper.insertEmployee(employee);
            sqlSession.commit();
        }

        // then
        List<EmployeeDTO> employees;
        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            employees = employeeMapper.selectEmployeeByName(employee.getName());
            sqlSession.commit();
        }
        employees.forEach(e -> assertThat(e.getName()).contains(employee.getName()));
    }

    @Test
    @DisplayName("관리자는 지점명이나 주소로 지점을 조회할 수 있다.")
    void searchStoreByKeyword() {
        // given
        String keyword = "하늘";

        // when
        List<StoreDTO> stores;

        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            stores = employeeMapper.selectStoreByKeyword(keyword);
            sqlSession.commit();
        }

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
        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            employeeMapper.insertEmployee(employee);
            sqlSession.commit();
        }

        // then
        EmployeeDTO foundEmployee;
        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            foundEmployee = employeeMapper.findEmployeeById(employee.getId());
            sqlSession.commit();
        }
        assertThat(employee).isEqualTo(foundEmployee);

        // clean up
        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            employeeMapper.removeEmployeeById(employee.getId());
            sqlSession.commit();
        }
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
