package com.huang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.bean.Detail;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-09-15
 */
public interface DetailService extends IService<Detail> {
    List<Detail> getDataList(Detail params);

    boolean saveData(Detail params);

    boolean delData(Detail params);
}
