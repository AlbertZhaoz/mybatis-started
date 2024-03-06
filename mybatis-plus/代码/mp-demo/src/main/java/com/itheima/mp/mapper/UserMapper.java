package com.itheima.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.mp.domain.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper extends BaseMapper<User>{
    User getUserByName(String name);

    @Update("update tb_user set balance = balance - #{money} where id = #{id}")
    void deductMoneyById(@Param("id") Long id, @Param("money") Integer money);
}
