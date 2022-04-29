package com.fc.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AccountDao {
//    加钱
    void increase(@Param("id") Integer id, @Param("money")Integer money);
    void decrease(@Param("id") Integer id, @Param("money")Integer money);
}
