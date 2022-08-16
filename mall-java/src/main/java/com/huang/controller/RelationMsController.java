package com.huang.controller;

import com.huang.bean.RelationMs;
import com.huang.common.lang.Result;
import com.huang.service.RelationMsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relationMs")
public class RelationMsController extends BaseController {
    @Autowired
    RelationMsService service;

    @PostMapping("/getDataList")
    public Result getDataList(@RequestBody RelationMs params){
        List<RelationMs> result = service.getDataList(params);
        return Result.succ(result);
    }

    @PostMapping("/saveData")
    public Result saveData(@RequestBody RelationMs params){
        service.saveData(params);
        return Result.succ("保存成功");
    }

    @PostMapping("/delData")
    public Result delData(@RequestBody RelationMs params){
        service.delData(params);
        return Result.succ("删除成功");
    }
}
