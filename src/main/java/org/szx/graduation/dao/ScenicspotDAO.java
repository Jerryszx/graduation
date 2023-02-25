package org.szx.graduation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.szx.graduation.dataobject.ScenicspotDO;
import org.szx.graduation.dataobject.UserDO;

import java.util.List;
@Mapper
public interface ScenicspotDAO {

    List<ScenicspotDO> findByName(@Param("sname") String sname);

    List<ScenicspotDO> findByCity(@Param("city") String city);

    List<ScenicspotDO> findBySort(@Param("sort") String sort);

    List<ScenicspotDO> findByTwo(@Param("city") String city,@Param("sort") String sort);
    List<ScenicspotDO> findAll();

}
