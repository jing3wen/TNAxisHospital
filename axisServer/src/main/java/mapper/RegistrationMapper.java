package main.java.mapper;

import main.java.entity.Registration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface RegistrationMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Registration record);

    int insertSelective(Registration record);

    Registration selectByPrimaryKey(Integer id);

    List<Registration> queryALLRegistration();

    Registration queryRegistrationByDateAndDepartment(@Param("date") Date date,@Param("department") String department);

    int updateRemainingWhenInsertOrder(Integer registrationId);

    int updateRemainingWhenDeleteOrder(Integer registrationId);
}
