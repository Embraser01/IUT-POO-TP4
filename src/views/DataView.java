package views;

import models.Data;
import models.RSSFeed;
import views.listener.RSSUpdateListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Created by Marc-Antoine on 15/12/2015.
 */
public class DataView extends JPanel implements ListSelectionListener, RSSUpdateListener {

    private RSSFeed rssFeed;

    private JScrollPane listDataScroll;
    private JList listData;
    private DefaultListModel listModel;

    private JTextArea desc;

    private GridBagConstraints cont;

    public DataView() {
        this.rssFeed = null;

        this.listModel = new DefaultListModel();
        this.getNewDataModel();

        this.setLayout(new GridBagLayout());
        this.cont = new GridBagConstraints();
        this.cont.anchor = GridBagConstraints.NORTHWEST;
        this.cont.fill = GridBagConstraints.BOTH;


        this.listData = new JList(this.listModel);
        this.listData.addListSelectionListener(this);
        this.listData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listDataScroll = new JScrollPane(this.listData);
        this.listDataScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.listDataScroll.setBorder(BorderFactory.createTitledBorder("Liste des articles"));
        this.listDataScroll.setPreferredSize(new Dimension(1000,300));


        this.desc = new JTextArea();
        this.desc.setBorder(BorderFactory.createTitledBorder("Description"));
        this.desc.setLineWrap(true);
        this.desc.setWrapStyleWord(true);
        this.desc.setPreferredSize( new Dimension(1000,80));

        this.cont.gridx = 0;
        this.cont.gridy = 0;
        this.add(this.listDataScroll, cont);

        this.cont.gridx = 0;
        this.cont.gridy = 1;
        this.add(this.desc, cont);
    }


    private void getNewDataModel() {
        if (listModel.size() != 0) listModel.removeAllElements();

        if (rssFeed != null) {
            for (Data row = rssFeed.resetCursor(); row != null; row = rssFeed.next())
                listModel.addElement(row.getTitle());
        }
    }

    @Override
    public void onRSSUpdate(RSSFeed rssFeed) {
        this.rssFeed = rssFeed;
        getNewDataModel();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == listData && listData.getSelectedValue() != null) {
            Data tmp = rssFeed.searchByTitle((String) listData.getSelectedValue());
            if (tmp != null) this.desc.setText(tmp.getDesc());

        }
    }
}
