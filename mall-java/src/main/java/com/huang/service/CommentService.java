package com.huang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.bean.Comment;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-09-26
 */
public interface CommentService extends IService<Comment> {
    List<Comment> getDataList(Comment params);

    boolean saveData(Comment params);

    boolean delData(Comment params);
}
