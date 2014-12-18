package com.jerry.materialcolors.utils;

/**
 * Created by Jerry on 19/12/2014.
 */
public class Food {
    private String name;
    private String desc;

    public Food(String name, String desc){
        this.setName(name);
        this.setDesc(desc);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
