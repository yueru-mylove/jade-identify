package com.jade.controller;

import com.jade.bean.Jade;
import com.jade.fdfs.FastDFSClient;
import com.jade.fdfs.FastDSFile;
import com.jade.result.Result;
import com.jade.service.JadeService;
import org.csource.common.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/jade")
public class JadeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JadeController.class);

    private static final String FDFS_SERVER = "140.143.159.112";

    private static final Integer PORT = 8888;

    @GetMapping(value = "/check")
    public String check() {
        return "hello world...";
    }

    @Autowired
    private JadeService jadeService;

/*  /**
     * @return
     */
    @ResponseBody
    @GetMapping("/info/all")
    public List<Jade> getJadesInfoList() {

        List<Jade> allJadeInfo = jadeService.getAllJadeInfo();
        return allJadeInfo;
    }

    @ResponseBody
    @GetMapping("/info/{number}")
    public Jade getJadeInfoByID(@PathVariable("number") Integer id) {

        Jade jadeInfoByPrimaryKey = jadeService.getJadeInfoByPrimaryKey(id);
        return jadeInfoByPrimaryKey;
    }

    @ResponseBody
    @PostMapping("/info/add")
    public Result addJade(@RequestParam(value = "id", required = false) Integer id,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "source") String source,
                          @RequestParam("value") String value,
                          @RequestParam("material") String material, @RequestParam("number") String number,
                          @RequestParam("born") String born,
                          @RequestParam("inch") String inch, Jade jade, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object token = session.getAttribute("token");

        boolean b = jadeService.addJade(jade);
        if (b) {
            return Result.success(jade);
        }
        return Result.failed(null);
    }


    @ResponseBody
    @RequestMapping(value = "/info/update", method = RequestMethod.POST)
    public boolean update(Jade jade) {
        boolean result = false;
        try {
            result = jadeService.updateJade(jade);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    @RequestMapping(value = "/search")
    public String toSearch() {
        return "identify";
    }


    @ResponseBody
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        try {
            if (file != null && !file.isEmpty()) {

                String fileName = file.getOriginalFilename();
                String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
                FastDSFile fastDSFile = new FastDSFile();
                fastDSFile.setName(file.getName());
                fastDSFile.setContent(file.getBytes());
                fastDSFile.setExt(ext);

                String[] uploadAddress = FastDFSClient.upload(fastDSFile);
                if (uploadAddress != null && uploadAddress.toString().trim().length() >= 2) {
                    final String result = FDFS_SERVER + ":" + PORT + "/" + uploadAddress[0] + "/" + uploadAddress[1];
                    return Result.success(result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }
}
