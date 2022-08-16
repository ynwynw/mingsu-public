package com.huang.service.impl;

import com.huang.bean.Comment;
import com.huang.mapper.CommentMapper;
import com.huang.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huang
 * @since 2021-09-26
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    CommentMapper mapper;

    @Override
    public List<Comment> getDataList(Comment params) {
        return mapper.queryDataList(params);
    }

    @Override
    public boolean saveData(Comment params){
        params.getInsertInfo();
        return this.save(params);
    }

    @Override
    public boolean delData(Comment params){
        params.getDeleteInfo();
        return this.updateById(params);
    }
}
