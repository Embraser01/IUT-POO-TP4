package models;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marc-Antoine on 15/12/2015.
 */
public class RSSFeed {

    private ArrayList<Data> rows;


    private SAXBuilder builder = null;
    private String link = null;

    public RSSFeed(String link) {
        this.link = link;

    }

    public void extract() {

        if(builder == null) builder = new SAXBuilder();

        rows = new ArrayList<>();

        try {
            Document document = builder.build(link);
            Element rootNode = document.getRootElement();

            List list = rootNode.getChild("channel").getChildren("item");

            Element node = null;
            for (int i = 0; i < list.size(); i++) {

                node = (Element) list.get(i);

                rows.add(new Data(node.getChildText("link"),
                        node.getChildText("title"),
                        node.getChildText("description"),
                        node.getChildText("pubDate"),
                        node.getChildText("guid"),
                        node.getChild("enclosure").getAttributeValue("url")));
            }

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
    }

    public ArrayList<Data> getRows() {
        return rows;
    }


    @Override
    public String toString() {
        return "RSSFeed{" +
                "rows=" + rows +
                '}';
    }
}
