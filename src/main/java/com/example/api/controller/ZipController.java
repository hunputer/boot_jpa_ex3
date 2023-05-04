package com.example.api.controller;

import com.example.api.service.ZipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ZipController {

    final ZipService zipService;

    @GetMapping("/zip/makezip")
    public void makeZip() throws Exception{
        String filepath = "/Users/choejihun/desktop/무제 폴더";
        List<String> filenames = new ArrayList<>();
        filenames.add("image1.png");
        filenames.add("image2.png");
        filenames.add("image3.png");
        zipService.makeZip(filepath, filenames);
    }

    @GetMapping("/zip/zip2")
    public void unCompressZip() throws Exception{
        String filepath = "/Users/choejihun/desktop/무제 폴더/";
        String zipName = "압축파일.zip";
        zipService.unCompressZip(filepath, zipName);
    }

}
