package bangshop.music.model.service;

import bangshop.music.model.dao.EmployeeMapper;
import bangshop.music.model.dto.EmployeeDTO;
import bangshop.music.model.dto.StoreDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;

public class EmployeeService {
    private EmployeeMapper employeeMapper;

    public EmployeeDTO findEmployeeById(String id) {
        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            EmployeeDTO employee = employeeMapper.findEmployeeById(id);
            sqlSession.commit();
            return employee;
        }
    }

    public boolean registerEmployee(EmployeeDTO employee) {
        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            int result = employeeMapper.insertEmployee(employee);
            sqlSession.commit();
            return result > 0;
        }
    }

    public List<StoreDTO> findStoreByKeyword(String keyword) {
        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            List<StoreDTO> storeList = employeeMapper.selectStoreByKeyword(keyword);
            sqlSession.commit();
            return storeList;
        }
    }

    public List<EmployeeDTO> findEmployeeByName(String name) {
        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            List<EmployeeDTO> employeeList = employeeMapper.selectEmployeeByName(name);
            sqlSession.commit();
            return employeeList;
        }
    }

    public void removeEmployeeById(String id) {
        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            employeeMapper.removeEmployeeById(id);
            sqlSession.commit();
        }
    }
}
