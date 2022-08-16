package com.huang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.bean.News;
import com.huang.mapper.NewsMapper;
import com.huang.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huang
 * @since 2021-09-15
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {
    @Autowired
    NewsMapper mapper;

    @Override
    public List<News> getDataList(News params) {
        return mapper.queryDataList(params);
    }

    @Override
    public boolean saveData(News params){
        boolean resultFlag = false;
        if(params.getId()!=null||"".equals(params.getId())){
            params.getUpdateInfo();
            resultFlag = this.updateById(params);
        }else{
            params.getInsertInfo();
            resultFlag = this.save(params);
        }
        return resultFlag;
    }

    @Override
    public boolean delData(News params){
        params.getDeleteInfo();
        return this.updateById(params);
    }
}
