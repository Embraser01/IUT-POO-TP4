import models.RSSFeed;

public class Main {

    public static void main(String[] args) {
        RSSFeed tmp = new RSSFeed("http://lemonde.fr/m-actu/rss_full.xml");
        System.out.println(tmp);
    }
}
