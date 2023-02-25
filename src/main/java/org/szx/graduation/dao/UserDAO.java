package org.szx.graduation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.szx.graduation.dataobject.UserDO;

@Mapper
public interface UserDAO {

    int insert(UserDO userDO);

    int update(UserDO userDO);

    int delete(@Param("account") String account);

    UserDO findByUserAccount(@Param("account") String account);

}
