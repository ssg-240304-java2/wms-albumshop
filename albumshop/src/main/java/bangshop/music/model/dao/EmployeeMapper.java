package bangshop.music.model.dao;

import bangshop.music.model.dto.EmployeeDTO;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    void insertEmployee(EmployeeDTO employee);

    EmployeeDTO findEmployeeByIdAndPassword(@Param("id") String id, @Param("password") String password);

    EmployeeDTO findEmployeeById(String id);
}
