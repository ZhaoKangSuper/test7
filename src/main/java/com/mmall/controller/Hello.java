package com.mmall.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by ZHAOKANG on 2018/5/9.
 */
@Controller
@RequestMapping(value = "/courses")
public class Hello {

    @RequestMapping(value = "/123", method = RequestMethod.GET)
    public String helloworld(Model model) {
        model.addAttribute("message", "Hello SpringMvc");
        return "HelloWorld";
    }

    @RequestMapping(value = "/Upload", method = RequestMethod.GET)
    public String showUploadPage() {
        return "course_admin/file";
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()) {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("C:\\Users\\ZHAOKANG\\Desktop\\file", System.currentTimeMillis() + file.getOriginalFilename()));
        }
        return "success";
    }
}
