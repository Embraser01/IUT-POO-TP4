package models;

import java.util.ArrayList;

/**
 * Created by Marc-Antoine on 15/12/2015.
 */
public class Data {

    private String link = null;
    private String title = null;
    private String desc = null;
    private String pubDate = null;
    private String tiny_link = null;
    private String img_link = null;

    public Data(String link, String title, String desc, String pubDate, String tiny_link, String img_link) {
        this.link = link;
        this.title = title;
        this.desc = desc;
        this.pubDate = pubDate;
        this.tiny_link = tiny_link;
        this.img_link = img_link;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getTiny_link() {
        return tiny_link;
    }

    public String getImg_link() {
        return img_link;
    }

    @Override
    public String toString() {
        return "Data{" +
                "link='" + link + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", tiny_link='" + tiny_link + '\'' +
                ", img_link='" + img_link + '\'' +
                "}\n";
    }
}
