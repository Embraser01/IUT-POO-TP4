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

    private static int count = 0;

    private int _id;

    private int next;

    private ArrayList<Data> rows;
    private String title;


    private SAXBuilder builder = null;
    private String link = null;

    public RSSFeed(String link) {
        this._id = count;
        count++;
        this.link = link;

        this.rows = new ArrayList<>();
        this.next = 0;
        this.title = "";

        this.extract();
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public Data searchByTitle(String title){
        for (Data row : rows) if (row.getTitle().equals(title)) return row;
        return null;
    }

    public Data resetCursor() {
        next = 0;
        if(rows.size() == 0)return null;

        next++;
        return rows.get(next - 1);
    }

    public Data next() {
        if(next >= rows.size()) {
            next = 0;
            return null;
        }
        next++;
        return rows.get(next - 1);
    }


    public void extract() {

        if (builder == null) builder = new SAXBuilder();

        rows = new ArrayList<>();

        try {
            Document document = builder.build(link);
            Element rootNode = document.getRootElement();

            List list = rootNode.getChild("channel").getChildren("item");
            this.title = rootNode.getChild("channel").getChildText("title");

            Element node = null;
            for (int i = 0; i < list.size(); i++) {

                node = (Element) list.get(i);

                rows.add(new Data(node.getChildText("link"),
                        node.getChildText("title"),
                        node.getChildText("description")));
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
        return this.title;
    }
}
