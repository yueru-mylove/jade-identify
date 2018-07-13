package com.jade.service;

import com.jade.bean.Jade;
import com.jade.bean.JadeExample;
import com.jade.controller.JadeController;
import com.jade.dao.JadeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JadeServiceImpl implements JadeService {


    private static final Logger LOGGER = LoggerFactory.getLogger(JadeController.class);

    @Autowired
    private JadeMapper jadeMapper;


    @Override
    public List<Jade> getAllJadeInfo() {
        JadeExample jadeExample = new JadeExample();
        JadeExample.Criteria criteria = jadeExample.createCriteria();
        List<Jade> jades = jadeMapper.selectByExample(null);
        return jades;
    }

    @Override
    public Jade getJadeInfoByPrimaryKey(Integer id) {
        JadeExample jadeExample = new JadeExample();
        JadeExample.Criteria criteria = jadeExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<Jade> jades = jadeMapper.selectByExample(jadeExample);
        if (null != jades && jades.size() > 0) {
            return jades.get(0);
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addJade(Jade jade) {
        Integer clickcount = (int)(100 * Math.random()) + 1;
        jade.setClickcount(clickcount.toString());
        int insert = jadeMapper.insertJadeInfo(jade);
        if (insert == 1) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param jade
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateJade(Jade jade) {

        int result = jadeMapper.updateByPrimaryKey(jade);
        if (result == 1) {
            return true;
        }
        return false;
    }
}
