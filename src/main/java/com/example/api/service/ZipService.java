package com.example.api.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

@Service
public class ZipService {

    public void makeZip(String filePath, List<String> fileNames) throws Exception{

            File zipFile = new File(filePath, "압축파일.zip");

            byte[] buf = new byte[4096];

            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));
            for(String fileName : fileNames){
                File file = new File(filePath, fileName);

                FileInputStream in = new FileInputStream(file);

                ZipEntry zf = new ZipEntry(file.getName());

                out.putNextEntry(zf);
                int len;
                while((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }

                out.closeEntry();
            }
    }

}
