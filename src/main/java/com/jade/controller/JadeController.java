package com.jade.controller;

import com.jade.bean.Jade;
import com.jade.service.JadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class JadeController {

    @GetMapping(value = "/check")
    public String check() {
        return "hello world...";
    }

    @Autowired
    private JadeService jadeService;



    /**
     * @return
     */
    public List<Jade> getJadesInfoList() {

        List<Jade> allJadeInfo = jadeService.getAllJadeInfo();
        return allJadeInfo;
    }


    public Jade getJadeInfoByID(Integer id) {

        Jade jadeInfoByPrimaryKey = jadeService.getJadeInfoByPrimaryKey(id);
        return jadeInfoByPrimaryKey;
    }


    public boolean addJade(Jade jade) {

        return false;
    }


    @ResponseBody
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String fileUpload(MultipartFile file) {
        return null;
    }
}
