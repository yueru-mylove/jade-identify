package com.jade.bean;

import java.util.Date;

public class Jade {
    private Integer id;

    private String name;

    private Date createtime;

    private Date updatetime;

    private String source;

    private String clickcount;

    private String born;

    private String inch;

    private String value;

    private String material;

    private String number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getClickcount() {
        return clickcount;
    }

    public void setClickcount(String clickcount) {
        this.clickcount = clickcount == null ? null : clickcount.trim();
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born == null ? null : born.trim();
    }

    public String getInch() {
        return inch;
    }

    public void setInch(String inch) {
        this.inch = inch == null ? null : inch.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }
}