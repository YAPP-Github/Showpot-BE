package org.example.component;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.component.FileUploadComponent;
import java.io.IOException;
import java.util.Objects;
import org.example.config.S3Config;
import org.example.error.S3Error;
import org.example.exception.BusinessException;
import org.example.util.FileName;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class S3Component implements FileUploadComponent {

    private final AmazonS3 amazonS3;
    private final String bucket;

    public S3Component(S3Config s3Config, AmazonS3 amazonS3) {
        this.bucket = s3Config.getBucketName();
        this.amazonS3 = amazonS3;
    }


    @Override
    public String uploadFile(String directory, MultipartFile multipartFile) {
        String fileName = FileName.build(directory,
            Objects.requireNonNull(multipartFile.getOriginalFilename()));

        try {
            amazonS3.putObject(getPutObjectRequest(multipartFile, fileName));
        } catch (IOException e) {
            throw new BusinessException(S3Error.FILE_UPLOAD_ERROR);
        }

        return amazonS3.getUrl(bucket, fileName).toString();
    }

    private PutObjectRequest getPutObjectRequest(MultipartFile multipartFile, String fileName)
        throws IOException {
        return new PutObjectRequest(
            bucket,
            fileName,
            multipartFile.getInputStream(),
            getObjectMetadata(multipartFile)
        );
    }

    private ObjectMetadata getObjectMetadata(MultipartFile multipartFile) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(multipartFile.getContentType());
        objectMetadata.setContentLength(multipartFile.getSize());
        return objectMetadata;
    }
}
