package org.szx.graduation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.szx.graduation.dataobject.CommentDO;
import org.szx.graduation.dataobject.HeadPortraitDO;

import java.util.List;

@Mapper
public interface CommentDAO {

    int insert(CommentDO commentDO);

    List<CommentDO> findBySid(@Param("sid") int sid);

}
