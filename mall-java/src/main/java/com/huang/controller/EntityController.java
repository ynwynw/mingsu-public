package com.huang.controller;

import com.huang.bean.Entity;
import com.huang.common.lang.Result;
import com.huang.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/entity")
public class EntityController extends BaseController {
    @Autowired
    EntityService service;

    @PostMapping("/getDataList")
    public Result getDataList(@RequestBody Entity params){
        List<Entity> result = service.getDataList(params);
        return Result.succ(result);
    }

    @PostMapping("/saveData")
    public Result saveData(@RequestBody Entity params){
        service.saveData(params);
        return Result.succ("保存成功");
    }

    @PostMapping("/delData")
    public Result delData(@RequestBody Entity params){
        service.delData(params);
        return Result.succ("删除成功");
    }

}
