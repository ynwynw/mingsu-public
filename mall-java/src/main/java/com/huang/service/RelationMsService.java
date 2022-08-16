package com.huang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.bean.RelationMs;

import java.util.List;

public interface RelationMsService extends IService<RelationMs> {
    List<RelationMs> getDataList(RelationMs params);

    boolean saveData(RelationMs params);

    boolean delData(RelationMs params);
}
