package com.example.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("file")
public class FileController {
    @RequestMapping("upload")
    private ModelAndView upload(MultipartFile upload, ModelAndView mv){
        String path="http://localhost:8081/upload";
        String filename=upload.getOriginalFilename();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddmmssSSS");
        String format = formatter.format(new Date());
        filename = filename.substring(filename.lastIndexOf('.'));
        filename=format+filename;
        try {
            Client client = Client.create();
            WebResource resource = client.resource(path+filename);
            resource.put(upload.getBytes());
            mv.addObject("img",path+filename);
            mv.setViewName("/success.jsp");
           } catch (IOException e) {
               e.printStackTrace();
           }
        return mv;
    }
}
