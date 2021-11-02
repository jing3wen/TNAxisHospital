package main.java.mapper;

import main.java.entity.OrderExample;
import main.java.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    List<Order> selectAllOrder();

    Order selectOrderByUserPhone(String userPhone);

    void delectOrderById(Integer id);

}
