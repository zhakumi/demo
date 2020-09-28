package com.example.order.mapper;

import com.example.order.model.OrderFrom;
import com.example.order.model.OrderFromExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderFromMapper {
    long countByExample(OrderFromExample example);

    int deleteByExample(OrderFromExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderFrom record);

    int insertSelective(OrderFrom record);

    List<OrderFrom> selectByExample(OrderFromExample example);

    OrderFrom selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderFrom record,
        @Param("example") OrderFromExample example);

    int updateByExample(@Param("record") OrderFrom record, @Param("example") OrderFromExample example);

    int updateByPrimaryKeySelective(OrderFrom record);

    int updateByPrimaryKey(OrderFrom record);
}