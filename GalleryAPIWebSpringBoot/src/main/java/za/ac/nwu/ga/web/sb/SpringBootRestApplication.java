package za.ac.nwu.ga.web.sb;

import com.azure.storage.blob.*;
import com.azure.storage.blob.models.*;
import java.io.*;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SpringBootRestApplication
{
    public static void main(String[] args)
    {


        SpringApplication.run(SpringBootRestApplication.class, args);

//        String blobConnectionString = "DefaultEndpointsProtocol=https;AccountName=photogalleryrynobotes;AccountKey=rnfX8iDa9ZmHnRNR/1V+Aoq7o3ReWjXCmeQS/FqCynKWdDSReJbSJTL9je/gu+AlO46ZKStC+WQPzGugra2Biw==;EndpointSuffix=core.windows.net";
//
//        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(blobConnectionString).buildClient();
//
//        String containerName = "quickstartblobs" + java.util.UUID.randomUUID();
//
//        BlobContainerClient containerClient = blobServiceClient.createBlobContainer(containerName);


    }
}
