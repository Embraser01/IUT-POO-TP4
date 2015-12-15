package models;

import java.util.ArrayList;

/**
 * Created by Marc-Antoine on 15/12/2015.
 */
public class Data {

    private String link = null;
    private String title = null;
    private String desc = null;

    public Data(String link, String title, String desc) {
        this.link = link;
        this.title = title;
        this.desc = desc;
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

    @Override
    public String toString() {
        return "Data{" +
                "link='" + link + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                "}\n";
    }
}
