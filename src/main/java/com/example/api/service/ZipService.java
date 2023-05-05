package com.example.api.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@Service
public class ZipService {

    public void makeZip(String filePath, List<String> fileNames) throws Exception{

            File zipFile = new File(filePath, "압축파일.zip");
            byte[] buf = new byte[4096];

            try(ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile))){
                for(String fileName : fileNames){
                    File file = new File(filePath, fileName);

                    try(FileInputStream in = new FileInputStream(file)){
                        ZipEntry zf = new ZipEntry(file.getName());

                        out.putNextEntry(zf);

                        int len = 0;
                        while((len = in.read(buf)) > 0) {
                            out.write(buf, 0, len);
                        }

                        out.closeEntry();
                    }
                }
            }
    }

    public void unCompressZip(String filepath, String zipName) throws Exception{
        File zipFile = new File(filepath, zipName);

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(zipFile));
        ZipInputStream zipInputStream = new ZipInputStream(in);
        ZipEntry zipEntry = null;

        while((zipEntry = zipInputStream.getNextEntry()) != null){
            int length = 0;
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(filepath+zipEntry.getName()));
            while((length = zipInputStream.read()) != -1){
                out.write(length);
            }

            zipInputStream.closeEntry();
        }
    }

}
