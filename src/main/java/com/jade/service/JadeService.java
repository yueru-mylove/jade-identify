package com.jade.service;


import com.jade.bean.Jade;

import java.util.List;

public interface JadeService {


    public List<Jade> getAllJadeInfo();

    public Jade getJadeInfoByPrimaryKey(Integer id);


    public boolean addJade(Jade jade);

    public boolean updateJade(Jade jade);
}
