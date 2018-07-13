package com.jade.controller;

import com.jade.bean.Jade;
import com.jade.service.JadeService;
import com.sun.org.apache.regexp.internal.RE;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @GetMapping("/jade/info/all")
    public List<Jade> getJadesInfoList() {

        List<Jade> allJadeInfo = jadeService.getAllJadeInfo();
        return allJadeInfo;
    }

    @GetMapping("/jade/info/{number}")
    public Jade getJadeInfoByID(@PathVariable("number") Integer id) {

        Jade jadeInfoByPrimaryKey = jadeService.getJadeInfoByPrimaryKey(id);
        return jadeInfoByPrimaryKey;
    }

    @PostMapping("/jade/add")
    public boolean addJade(Jade jade, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object token = session.getAttribute("token");

        boolean b = jadeService.addJade(jade);
        if (b) {
            return true;
        }
        return false;
    }


    @ResponseBody
    @RequestMapping(value = "/file/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String fileUpload(MultipartFile file) {
        return null;
    }
}
