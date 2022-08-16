package com.huang.controller;

import com.huang.bean.News;
import com.huang.common.lang.Result;
import com.huang.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huang
 * @since 2021-09-15
 */
@RestController
@RequestMapping("/news")
public class NewsController extends BaseController {
    @Autowired
    NewsService service;

    @PostMapping("/getDataList")
    public Result getDataList(@RequestBody News params){
        List<News> result = service.getDataList(params);
        return Result.succ(result);
    }

    @PostMapping("/saveData")
    public Result saveData(@RequestBody News params){
        service.saveData(params);
        return Result.succ("保存成功");
    }

    @PostMapping("/delData")
    public Result delData(@RequestBody News params){
        service.delData(params);
        return Result.succ("删除成功");
    }
}
