//package za.ac.nwu.ga.web.sb.config;
//
//import com.azure.storage.blob.BlobClientBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import za.ac.nwu.ga.logic.config.LogicConfig;
//
//@Configuration
//public class AzureBlobStorageConfig
//{
//    @Value("${blob.connection-string}")
//    String connectionString;
//
//    @Value("${blob.container-name}")
//    String containerName;
//
//    @Bean
//    public BlobClientBuilder getClient(){
//        BlobClientBuilder client = new BlobClientBuilder();
//        client.connectionString(connectionString);
//        client.containerName(containerName);
//        return client;
//    }
//}
