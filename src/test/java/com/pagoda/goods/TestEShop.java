package com.pagoda.goods;


import com.alibaba.fastjson.JSONArray;
import com.jade.fdfs.FastDSFile;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestEShop {


    @Test
    public void test1() {

        List<Integer> list = null;
 /*        List<Integer> list = new ArrayList<>();
       list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(9);*/

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);


        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(4);
        list3.add(5);
        list3.add(6);


        boolean b = list2.retainAll(list3);
        System.out.println(list2);

    }

    public static void main(String[] args) {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mybatis-generator.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        try {
            config = cp.parseConfiguration(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try {
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        try {
            myBatisGenerator.generate(null);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test() {

        try {
            Resource resource = new ClassPathResource("fastdfs-client.properties");
            File file = resource.getFile();
            String absolutePath = file.getAbsolutePath();
            ClientGlobal.init(absolutePath);
            TrackerClient trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);

            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            StorageClient1 storageClient = new StorageClient1(trackerServer, storageServer);
            System.out.println("client init success ... ... ");

            FileInputStream fis = new FileInputStream(new File("C:\\Users\\wangwanjun\\Desktop\\logo1.png"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            byte[] cache = new byte[4096];
            while (fis.read(cache) != -1) {
                bos.write(cache);
            }
            fis.close();
            FastDSFile fastDSFile = new FastDSFile();
            fastDSFile.setContent(bos.toByteArray());
            fastDSFile.setExt("jpg");

            String[] filePath = null;
            JSONArray uploadResult = null;
            if (fastDSFile != null) {
                filePath = storageClient.upload_file(fastDSFile.getContent(), fastDSFile.getExt(), null);
            }
            if (filePath != null) {
                uploadResult = (JSONArray) JSONArray.toJSON(filePath);
            }
            String url = "43.97.219.222:8888/" + uploadResult.get(0) +  "/" + uploadResult.get(1);
            System.out.println(url);

            System.out.println(uploadResult);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("client init failed ... ... ");
        }

    }

}
