package org.example.component;

import com.example.component.FileUploadComponent;
import java.io.IOException;
import java.util.Objects;
import org.example.config.S3Config;
import org.example.error.S3Error;
import org.example.exception.BusinessException;
import org.example.util.FileName;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Component
public class S3Component implements FileUploadComponent {

    private final S3Client s3Client;
    private final String bucket;

    public S3Component(S3Config s3Config, S3Client s3Client) {
        this.bucket = s3Config.getBucketName();
        this.s3Client = s3Client;
    }


    @Override
    public String uploadFile(String directory, MultipartFile multipartFile) {
        String fileName = FileName.build(directory,
            Objects.requireNonNull(multipartFile.getOriginalFilename()));

        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucket)
                .contentType(multipartFile.getContentType())
                .contentLength(multipartFile.getSize())
                .key(fileName)
                .build();
            RequestBody requestBody = RequestBody.fromBytes(multipartFile.getBytes());
            s3Client.putObject(putObjectRequest, requestBody);
        } catch (IOException e) {
            throw new BusinessException(S3Error.FILE_UPLOAD_ERROR);
        }

        return s3Client.utilities().getUrl(getUrlRequest(fileName)).toString();
    }

    private GetUrlRequest getUrlRequest(String fileName) {
        return GetUrlRequest.builder()
            .bucket(bucket)
            .key(fileName)
            .build();
    }

}
