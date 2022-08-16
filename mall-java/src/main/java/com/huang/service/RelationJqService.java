package com.huang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.bean.RelationJq;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-09-15
 */
public interface RelationJqService extends IService<RelationJq> {
    List<RelationJq> getDataList(RelationJq params);

    boolean saveData(RelationJq params);

    boolean delData(RelationJq params);
}
