package com.example.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@Service
public class FileIOService {

    public void fileUpload(MultipartFile file){
        String filePath = "/Users/choejihun/desktop/무제 폴더/";

        try (
            FileOutputStream fos = new FileOutputStream(filePath + file.getOriginalFilename());
            // 파일 저장할 경로 + 파일명을 파라미터로 넣고 fileOutputStream 객체 생성하고
            InputStream is = file.getInputStream();) {
            // file로 부터 inputStream을 가져온다.

            int readCount = 0;
            byte[] buffer = new byte[1024];
            // 파일을 읽을 크기 만큼의 buffer를 생성하고
            // ( 보통 1024, 2048, 4096, 8192 와 같이 배수 형식으로 버퍼의 크기를 잡는 것이 일반적이다.)

            while ((readCount = is.read(buffer)) != -1) {
                //  파일에서 가져온 fileInputStream을 설정한 크기 (1024byte) 만큼 읽고

                fos.write(buffer, 0, readCount);
                // 위에서 생성한 fileOutputStream 객체에 출력하기를 반복한다
            }
        } catch (Exception ex) {
            throw new RuntimeException("file Save Error");
        }


    }
}
