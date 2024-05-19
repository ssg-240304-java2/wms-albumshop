package bangshop.music.model.dao;

import bangshop.music.model.dto.EmployeeDTO;
import bangshop.music.model.dto.StoreDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int insertEmployee(EmployeeDTO employee);

    EmployeeDTO findEmployeeByIdAndPassword(@Param("id") String id, @Param("password") String password);

    EmployeeDTO findEmployeeById(String id);

    List<StoreDTO> selectStoreByKeyword(String keyword);

    List<EmployeeDTO> selectEmployeeByName(String name);
}
