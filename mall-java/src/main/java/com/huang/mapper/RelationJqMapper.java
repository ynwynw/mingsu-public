package com.huang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.bean.Entity;
import com.huang.bean.RelationJq;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huang
 * @since 2021-09-26
 */
@Mapper
@Repository
public interface RelationJqMapper extends BaseMapper<RelationJq> {
    List<RelationJq> queryDataList(RelationJq params);

}
