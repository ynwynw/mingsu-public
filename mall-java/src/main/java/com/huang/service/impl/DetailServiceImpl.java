package com.huang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.bean.Detail;
import com.huang.bean.Entity;
import com.huang.mapper.DetailMapper;
import com.huang.mapper.EntityMapper;
import com.huang.service.DetailService;
import com.huang.service.EntityService;
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
public class DetailServiceImpl extends ServiceImpl<DetailMapper, Detail> implements DetailService {
    @Autowired
    DetailMapper mapper;

    @Override
    public List<Detail> getDataList(Detail params) {
        return mapper.queryDataList(params);
    }

    @Override
    public boolean saveData(Detail params){
        params.getInsertInfo();
        return this.save(params);
    }

    @Override
    public boolean delData(Detail params){
        params.getDeleteInfo();
        return this.updateById(params);
    }
}
