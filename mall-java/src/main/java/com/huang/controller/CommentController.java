package com.huang.controller;

import com.huang.bean.Comment;
import com.huang.common.lang.Result;
import com.huang.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huang
 * @since 2021-09-26
 */
@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController {

    @Autowired
    CommentService service;

    @PostMapping("/getDataList")
    public Result getDataList(@RequestBody Comment params){
        List<Comment> result = service.getDataList(params);
        return Result.succ(result);
    }

    @PostMapping("/saveData")
    public Result saveData(@RequestBody Comment params){
        service.saveData(params);
        return Result.succ("success");
    }

    @PostMapping("/delData")
    public Result delData(@RequestBody Comment params){
        service.delData(params);
        return Result.succ("success");
    }
}
