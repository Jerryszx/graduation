package org.szx.graduation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.szx.graduation.dataobject.PictureDO;

import java.util.List;
@Mapper
public interface PictureDAO {

    List<PictureDO> findByPid(@Param("pid") int pid);
}
