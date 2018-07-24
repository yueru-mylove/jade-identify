package com.jade.fdfs;

import com.alibaba.fastjson.JSONArray;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Component
public class FastDFSClient {


    private static StorageClient1 storageClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(FastDFSClient.class);

    static {

        try {

            Resource resource = new ClassPathResource("fdfs_client.conf");
            File file = resource.getFile();
            String absolutePath = file.getAbsolutePath();
            System.out.println(absolutePath);
            ClientGlobal.init(absolutePath);
            TrackerClient trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);

            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            storageClient = new StorageClient1(trackerServer, storageServer);
            System.out.println("client init success ... ... ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("client init failed ... ... ");
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
