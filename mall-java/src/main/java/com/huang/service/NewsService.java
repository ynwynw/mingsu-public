package com.huang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.bean.News;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-09-15
 */
public interface NewsService extends IService<News> {
    List<News> getDataList(News params);

    boolean saveData(News params);

    boolean delData(News params);
}
