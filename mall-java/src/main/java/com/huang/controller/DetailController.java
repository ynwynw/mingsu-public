package com.huang.controller;

import com.huang.bean.Detail;
import com.huang.bean.Entity;
import com.huang.common.lang.Result;
import com.huang.service.DetailService;
import com.huang.service.EntityService;
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
@RequestMapping("/detail")
public class DetailController extends BaseController {
    @Autowired
    DetailService service;

    @PostMapping("/getDataList")
    public Result getDataList(@RequestBody Detail params){
        List<Detail> result = service.getDataList(params);
        return Result.succ(result);
    }

    @PostMapping("/saveData")
    public Result saveData(@RequestBody Detail params){
        service.saveData(params);
        return Result.succ("success");
    }

    @PostMapping("/delData")
    public Result delData(@RequestBody Detail params){
        service.delData(params);
        return Result.succ("success");
    }
}
