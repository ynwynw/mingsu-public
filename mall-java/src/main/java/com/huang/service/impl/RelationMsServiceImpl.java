package com.huang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.bean.RelationMs;
import com.huang.mapper.RelationMsMapper;
import com.huang.service.RelationMsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationMsServiceImpl extends ServiceImpl<RelationMsMapper, RelationMs> implements RelationMsService {
    @Autowired
    RelationMsMapper mapper;

    @Override
    public List<RelationMs> getDataList(RelationMs params) {
        return mapper.queryDataList(params);
    }

    @Override
    public boolean saveData(RelationMs params){
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
    public boolean delData(RelationMs params){
        params.getDeleteInfo();
        return this.updateById(params);
    }
}
