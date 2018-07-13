package com.jade.dao;

import com.jade.bean.Jade;
import com.jade.bean.JadeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JadeMapper {
    long countByExample(JadeExample example);

    int deleteByExample(JadeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Jade record);

    int insertSelective(Jade record);

    List<Jade> selectByExample(JadeExample example);

    Jade selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Jade record, @Param("example") JadeExample example);

    int updateByExample(@Param("record") Jade record, @Param("example") JadeExample example);

    int updateByPrimaryKeySelective(Jade record);

    int updateByPrimaryKey(Jade record);

    int insertJadeInfo(Jade jade);
}