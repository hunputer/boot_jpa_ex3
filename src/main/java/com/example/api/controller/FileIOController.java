package com.example.api.controller;

import com.example.api.service.FileIOService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@RequiredArgsConstructor
public class FileIOController {

    final FileIOService fileIOService;

    @GetMapping("/fileio/page")
    public String getFileIo(){
        return "fileIO";
    }

    @PostMapping("/fileio/upload")
    @ResponseBody
    public void getFileUpload(@RequestParam("uploadFile") MultipartFile file,
                              Model model) throws Exception{
        System.out.println(file.getOriginalFilename());
        fileIOService.fileUpload(file);
    }

}
