package com.huang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.bean.RelationJq;
import com.huang.mapper.RelationJqMapper;
import com.huang.service.RelationJqService;
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
public class RelationJqServiceImpl extends ServiceImpl<RelationJqMapper, RelationJq> implements RelationJqService {
    @Autowired
    RelationJqMapper mapper;

    @Override
    public List<RelationJq> getDataList(RelationJq params) {
        return mapper.queryDataList(params);
    }

    @Override
    public boolean saveData(RelationJq params){
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
    public boolean delData(RelationJq params){
        params.getDeleteInfo();
        return this.updateById(params);
    }
}
