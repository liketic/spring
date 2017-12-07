package io.github.liketic.spring.user.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {


    /**
     * Create a new user with generated id returned
     *
     * @param user
     */
    @Insert("INSERT INTO users(login,password,email)" +
            " VALUES(#{login},#{password},#{email})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void create(User user);


    @Select("SELECT id,login,email,password FROM users WHERE login=#{login}")
    User findByLogin(@Param("login") String login);
}
