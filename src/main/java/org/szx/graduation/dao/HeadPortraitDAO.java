package org.szx.graduation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.szx.graduation.dataobject.HeadPortraitDO;
import org.szx.graduation.dataobject.UserDO;

import java.util.List;

@Mapper
public interface HeadPortraitDAO {

    int insert(HeadPortraitDO headPortraitDO);

    HeadPortraitDO findById(@Param("id") int id);

    List<HeadPortraitDO> findAll();

}
