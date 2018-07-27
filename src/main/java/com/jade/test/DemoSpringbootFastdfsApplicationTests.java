package com.jade.test;

import io.netty.util.internal.shaded.org.jctools.queues.MpscChunkedArrayQueue;

import java.util.concurrent.*;

/*import com.alibaba.fastjson.JSONArray;
import com.jade.fdfs.FastDFSClient;
import com.jade.fdfs.FastDSFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest*/
public class DemoSpringbootFastdfsApplicationTests {


  /*  @Test
    public void contextLoads() {
        try {
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

            // -------上传----
            String[] rs = FastDFSClient.upload(fastDSFile);
            System.out.println("上传结束:" + rs);

            // -------下载----
           *//* byte[] dfile = FastDFSClient.download(rs.getString(0), rs.getString(1));

            FileOutputStream fos = new FileOutputStream(new File("C:/Users/xq/Pictures/tx-fdfs.jpg"));
            fos.write(dfile);
            fos.flush();
            fos.close();
*//*
          *//*  // -------删除-----
            int ds=FastDFSClient.delete(rs.getString(0), rs.getString(1));
            //
            System.out.println("Delete:"+ds);
            System.out.println("---End----");
*//*
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/


    static  class ThreadDivTest implements Callable {

        private int a;
        private int b;

        public ThreadDivTest() {

        }

        public ThreadDivTest(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "ThreadDivTest{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }

        @Override
        public Object call() throws Exception {
            return a / b;
        }
    }

    public static void main(String[] args) {

        Executor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), 100, 300, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

        for (int i = 0; i < 5; i++) {
            Future<?> submit = ((ThreadPoolExecutor) executor).submit(new ThreadDivTest(100, i));
            try {
                Object o = submit.get();
                System.out.println(o.getClass());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
