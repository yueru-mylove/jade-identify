package com.jade.fdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class FastDFSClient {

    private static StorageClient1 storageClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(FastDFSClient.class);
    static {

        try {

            Properties properties = new Properties();
            properties.put(ClientGlobal.PROP_KEY_TRACKER_SERVERS, "47.93.219.222:22122");
            properties.put(ClientGlobal.PROP_KEY_HTTP_SECRET_KEY, "FastDFS1234567890");
            properties.put(ClientGlobal.PROP_KEY_HTTP_TRACKER_HTTP_PORT, "80");
            properties.put(ClientGlobal.PROP_KEY_CHARSET, "UTF-8");
            properties.put(ClientGlobal.PROP_KEY_HTTP_ANTI_STEAL_TOKEN, false);

            /*String path = ClassUtils.class.getClassLoader().getResource("fastdfs-client.properties").getPath();
            System.out.println(path);
            File file = new File(path);*/
            ClientGlobal.initByProperties(properties);
            TrackerClient trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);

            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            storageClient = new StorageClient1(trackerServer, storageServer);
            System.out.println("client init success ... ... ");
            LOGGER.info("client init success ... ...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("client init failed ... ... ");
            LOGGER.error("client init failed ... ...");
        }

    }


    public static String[] upload(FastDSFile fastDSFile) throws IOException, MyException {

        String[] filePath = null;
        if (fastDSFile != null) {
            filePath = storageClient.upload_file(fastDSFile.getContent(), fastDSFile.getExt(), null);
        }

        return filePath;
    }


    /**
     * 文件下载
     *
     * @param groupName
     * @param remoteFileName
     * @return
     * @throws IOException
     * @throws MyException
     */
    public static byte[] download(String groupName, String remoteFileName) throws IOException, MyException {
        return storageClient.download_file(groupName, remoteFileName);
    }


    /**
     * 文件删除
     *
     * @param groupName
     * @param remoteFileName
     * @return 返回0成功;非0失败.
     * @throws Exception
     */
    public static int delete(String groupName, String remoteFileName) throws Exception {
        return storageClient.delete_file(groupName, remoteFileName);
    }
}
