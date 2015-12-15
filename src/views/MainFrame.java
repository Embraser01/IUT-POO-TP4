package views;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private FeedsView feedsView;
    private DataView dataView;
    private NewFeedView newFeedView;

    private GridBagConstraints cont;


    public MainFrame() {

        this.setTitle("TP4 MVC - POO | Fernandes Marc-Antoine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.cont = new GridBagConstraints();
        this.cont.anchor = GridBagConstraints.NORTHWEST;
        this.cont.fill = GridBagConstraints.BOTH;

        this.setLayout(new GridBagLayout());

        this.feedsView = new FeedsView();
        this.dataView = new DataView();
        this.newFeedView = new NewFeedView(feedsView.getFeeds());

        this.feedsView.addRSSListener(this.dataView);
        this.newFeedView.addRSSListener(this.dataView);


        this.cont.gridx = 0;
        this.cont.gridy = 0;
        this.cont.gridheight = 2;
        this.add(this.feedsView, cont);

        this.cont.gridx = 1;
        this.cont.gridy = 1;
        this.cont.gridheight = 1;
        this.add(this.dataView, cont);

        this.cont.gridx = 1;
        this.cont.gridy = 0;
        this.cont.gridheight = 1;
        this.add(this.newFeedView, cont);

        this.setVisible(true);
        this.pack();
    }
}