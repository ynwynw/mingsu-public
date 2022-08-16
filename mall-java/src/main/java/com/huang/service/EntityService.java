package com.huang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.bean.Entity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-09-15
 */
public interface EntityService extends IService<Entity> {
    List<Entity> getDataList(Entity params);

    boolean saveData(Entity params);

    boolean delData(Entity params);
}
