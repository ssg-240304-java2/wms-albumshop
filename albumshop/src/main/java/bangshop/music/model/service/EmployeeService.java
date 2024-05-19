package bangshop.music.model.service;

import bangshop.music.model.dao.EmployeeMapper;
import bangshop.music.model.dto.EmployeeDTO;
import org.apache.ibatis.session.SqlSession;

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
}
