package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.example.pojo.User;

import java.util.List;

/**
 * ClassName:UserMapper
 * Package:org.example.mapper
 * Description:
 *
 * @Author AlbertZhao
 * @Create 3/2/2024 6:19 PM
 * @Version 1.0
 */
public interface UserMapper {
    List<User> selectAllUser();

    @Delete("delete from tb_user where id = #{id}")
    void deleteUserById(int id);
}
