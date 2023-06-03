package com.test.UploadFile.utils;

import com.test.UploadFile.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.waiters.WaiterResponse;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.waiters.S3Waiter;

import java.io.IOException;
import java.io.InputStream;

@Component
public class S3Util {
    private static final String BUCKET = "bird-trading-platform";
    private static AppProperties appProperties;

    public S3Util (AppProperties appProperties) {
        this.appProperties = appProperties;
    }
    public static void uploadFile(String fileName, InputStream inputStream)
            throws S3Exception, AwsServiceException, SdkClientException, IOException {
        System.out.println(appProperties.getAws().getAccessKey() + "-------------- " + appProperties.getAws().getSecretKey());
        S3Client client = S3Client.builder()
                .region(Region.AP_SOUTHEAST_1)
                .credentialsProvider(new AwsCredentialsProvider() {
                    @Override
                    public AwsCredentials resolveCredentials() {
                        return new AwsCredentials() {
                            @Override
                            public String accessKeyId() {
                                return appProperties.getAws().getAccessKey();
                            }
                            @Override
                            public String secretAccessKey() {
                                return appProperties.getAws().getSecretKey();
                            }
                        };
                    }
                }).
                build();

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(BUCKET)
                .key("image/" + fileName)
                .acl("public-read")
                .build();

        client.putObject(request,
                RequestBody.fromInputStream(inputStream, inputStream.available()));

        S3Waiter waiter = client.waiter();
        HeadObjectRequest waitRequest = HeadObjectRequest.builder()
                .bucket(BUCKET)
                .key("image/" + fileName)
                .build();

        WaiterResponse<HeadObjectResponse> waitResponse = waiter.waitUntilObjectExists(waitRequest);

        waitResponse.matched().response().ifPresent(x -> {
            // run custom code that should be executed after the upload file exists
        });
    }
}
