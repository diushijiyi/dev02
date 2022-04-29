package com.fc.controller;

import com.fc.util.FileUploadUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("fileUpload")
public class FileController {
//    RequestPart专用于文件类型的参数绑定
    @PostMapping("form")
    public String formFileUpload(@RequestPart MultipartFile headerImg,
                                 @RequestPart MultipartFile[] photo){
        if (!headerImg.isEmpty()){
            FileUploadUtil.fileUpload(headerImg);
        }
        if (photo!=null&&photo.length!=0){
            for (MultipartFile file : photo) {
                FileUploadUtil.fileUpload(file);
            }
        }
        return "redirect:/success.html";
    }
    @PostMapping("json")
    @ResponseBody
    public Map<String,Object> jsonFileUpload(@RequestPart MultipartFile headerImg,
                              @RequestPart MultipartFile[] photo){
        Map<String, Object> result = new HashMap<>();
        List<String> imgPaths = new ArrayList<>();

        if (!headerImg.isEmpty()){
            String path=FileUploadUtil.fileUpload(headerImg);
            imgPaths.add(path);
        }
        if (photo!=null&&photo.length!=0){
            for (MultipartFile file : photo) {
                String path=FileUploadUtil.fileUpload(file);
                imgPaths.add(path);
            }
        }
        result.put("message","上传成功");
        result.put("code",200);
        result.put("success",true);
        result.put("data",imgPaths);
        return result;
    }
}
