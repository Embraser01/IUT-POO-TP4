package views;

import models.Feeds;
import models.RSSFeed;
import views.listener.FeedsUpdateListener;
import views.listener.RSSUpdateListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Marc-Antoine on 15/12/2015.
 */
public class FeedsView extends JPanel implements ActionListener, FeedsUpdateListener {

    private Feeds feeds;

    private JScrollPane listFeedScroll;
    private JList listFeed;
    private DefaultListModel listModel;

    private JButton checkBtn;

    private RSSUpdateListener listener;

    private GridBagConstraints cont;

    public FeedsView() {
        this.listener = null;
        this.listModel = new DefaultListModel();

        this.feeds = new Feeds();
        this.feeds.addFeedsUpdateListener(this);
        this.feeds.addRSSFeed("http://lemonde.fr/m-actu/rss_full.xml");


        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder("Flux enregistrés"));
        this.cont = new GridBagConstraints();
        this.cont.anchor = GridBagConstraints.NORTHWEST;

        this.listFeed = new JList(this.listModel);
        this.listFeedScroll = new JScrollPane(this.listFeed);
        this.listFeedScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.checkBtn = new JButton("Check");
        this.checkBtn.addActionListener(this);


        this.cont.gridx = 0;
        this.cont.gridy = 0;
        this.add(this.listFeedScroll, cont);

        this.cont.gridx = 0;
        this.cont.gridy = 1;
        this.add(this.checkBtn, cont);
    }


    public Feeds getFeeds() {
        return feeds;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == checkBtn && listFeed.getSelectedValue() != null) {
            RSSFeed tmp = feeds.searchTitle((String) listFeed.getSelectedValue());
            if (listener != null && tmp != null) listener.onRSSUpdate(tmp);
        }
    }

    public void addRSSListener(RSSUpdateListener listener) {
        this.listener = listener;
    }

    @Override
    public void onFeedsUpdate(RSSFeed rssFeed) {
        this.listModel.addElement(rssFeed.toString());
    }
}
