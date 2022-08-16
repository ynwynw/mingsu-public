package com.huang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.bean.Entity;
import com.huang.mapper.EntityMapper;
import com.huang.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
public class EntityServiceImpl extends ServiceImpl<EntityMapper, Entity> implements EntityService {
    @Autowired
    EntityMapper mapper;

    @Override
    public List<Entity> getDataList(Entity params) {
        return mapper.queryDataList(params);
    }

    @Override
    public boolean saveData(Entity params){
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
    public boolean delData(Entity params){
        params.getDeleteInfo();
        return this.updateById(params);
    }
}
