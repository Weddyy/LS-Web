package com.Stone.model.GamesModel;

/**
 * Created by Wed on 22.02.16.
 */
public class Rune {
    int id;
    String img,name,desc,tier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = "http://ddragon.leagueoflegends.com/cdn/6.3.1/img/rune/"+img;
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
