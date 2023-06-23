package com.una.carassiststorebackend.repositories;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Configuration;


@Configuration
public class S3BucketConfig {
    AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .build();


    public String getFileUrl(String fileKey, String bucketName) {
        return s3Client.getUrl(bucketName, fileKey).toString();
    }
}
