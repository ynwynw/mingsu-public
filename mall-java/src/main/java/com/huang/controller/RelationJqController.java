package com.huang.controller;

import com.huang.bean.RelationJq;
import com.huang.common.lang.Result;
import com.huang.service.RelationJqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relationJq")
public class RelationJqController extends BaseController {
    @Autowired
    RelationJqService service;

    @PostMapping("/getDataList")
    public Result getDataList(@RequestBody RelationJq params){
        List<RelationJq> result = service.getDataList(params);
        return Result.succ(result);
    }

    @PostMapping("/saveData")
    public Result saveData(@RequestBody RelationJq params){
        service.saveData(params);
        return Result.succ("保存成功");
    }

    @PostMapping("/delData")
    public Result delData(@RequestBody RelationJq params){
        service.delData(params);
        return Result.succ("删除成功");
    }
}
