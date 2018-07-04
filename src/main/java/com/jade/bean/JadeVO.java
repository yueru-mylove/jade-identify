package com.jade.bean;

public class JadeVO {

    private Long id;
    private String name;
    private String createTime;
    private String updateTime;
    private String source;
    private String clickCount;
    private String born;
    private String inch;
    private String value;
    private String material;

    public JadeVO() {
    }

    public JadeVO(String name, String createTime, String updateTime, String source, String clickCount, String born, String inch, String value, String material) {
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.source = source;
        this.clickCount = clickCount;
        this.born = born;
        this.inch = inch;
        this.value = value;
        this.material = material;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getClickCount() {
        return clickCount;
    }

    public void setClickCount(String clickCount) {
        this.clickCount = clickCount;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getInch() {
        return inch;
    }

    public void setInch(String inch) {
        this.inch = inch;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "JadeVO{" +
                "name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", source='" + source + '\'' +
                ", clickCount='" + clickCount + '\'' +
                ", born='" + born + '\'' +
                ", inch='" + inch + '\'' +
                ", value='" + value + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
