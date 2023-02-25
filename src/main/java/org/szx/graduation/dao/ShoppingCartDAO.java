package org.szx.graduation.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.szx.graduation.dataobject.ShoppingCartDO;

import java.util.List;
@Mapper
public interface ShoppingCartDAO {
    int insert(ShoppingCartDO shoppingCartDO);

    List<ShoppingCartDO> findByUid(@Param("uid") long uid);

    int delete(@Param("id") long id);
}
