package com.huang.controller;
import com.huang.common.lang.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 *      /26.
 */
@RestController
@RequestMapping("/files")
@Slf4j
@Api(tags = "文件上传接口")
public class FileUploadController {
    @PostMapping("/uploadImg")
    @ResponseBody
    public Result uploadImg(MultipartFile file, String relativePath, HttpServletRequest request) throws IOException {
        String fileExt[] = {"jpg", "png"};
        checkFileExt(file, fileExt, "请上传jpg,png格式图片");
        if(StringUtils.isEmpty(relativePath)){
            relativePath = "/images/";
        }
        String fileName = file.getOriginalFilename();
        String absolutePath = getFileSavePath(relativePath)+"/"+ fileName;
        String imgRelativePath = relativePath +"/"+ fileName;
        System.out.println(imgRelativePath);
        File dest = new File(absolutePath);
        try {
            file.transferTo(dest);
//            fileService.insert(new com.feng.entity.File(fileName, relativePath, FileEnum.COMMON_IMG.getFileId()));
            log.info("上传成功");
            return Result.succ(imgRelativePath);
        } catch (IOException e) {
            log.error(e.toString(), e);
        }
        return Result.fail("上传文件失败");
    }

    private void checkFileExt(MultipartFile file, String fileExt[], String msg) {
        boolean checkResultError = true;
        String fileName = file.getOriginalFilename();
        String uploadFileExt = fileName.substring(fileName.indexOf('.') + 1);
        if (fileExt == null || fileExt.length == 0) {
            checkResultError = false;
        } else {
            for (String s : fileExt) {
                if (uploadFileExt.equals(s)) {
                    checkResultError = false;
                    break;
                }
            }
        }
    }


    private String getFileSavePath(String relativePath) {
        //此处改为项目的绝对路径
        String filePath = "E:\\educationProject\\酒店管理系统\\mingsu" + relativePath;
        System.out.println(filePath);
        File fileSave = new File(filePath);
        if (!fileSave.exists()) {
            fileSave.mkdirs();
        }
        return filePath;
    }
}
