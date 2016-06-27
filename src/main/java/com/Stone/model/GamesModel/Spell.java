package com.Stone.model.GamesModel;

/**
 * Created by Wed on 22.02.16.
 */
public class Spell {
    long id;
    String name,desc,img;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = "http://ddragon.leagueoflegends.com/cdn/6.3.1/img/spell/"+img;
    }
}
