package com.example.component;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public interface FileUploadComponent {

    String uploadFile(String directory, MultipartFile multipartFile);

}
