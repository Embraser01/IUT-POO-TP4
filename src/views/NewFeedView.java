package views;

import models.Feeds;
import models.RSSFeed;
import views.listener.RSSUpdateListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Marc-Antoine on 15/12/2015.
 */
public class NewFeedView extends JPanel implements ActionListener {

    private Feeds feeds;

    private JButton checkBtn;
    private JButton saveBtn;

    private JTextField urlField;

    private JLabel title;


    private RSSUpdateListener listener;

    private GridBagConstraints cont;


    public NewFeedView(Feeds feeds) {
        this.listener = null;
        this.feeds = feeds;

        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder("Nouveau flux"));
        this.cont = new GridBagConstraints();
        this.cont.anchor = GridBagConstraints.NORTHWEST;

        this.checkBtn = new JButton("Check");
        this.checkBtn.addActionListener(this);

        this.saveBtn = new JButton("Enregistrer");
        this.saveBtn.addActionListener(this);

        this.urlField = new JTextField(50);
        this.title = new JLabel("Donner l'adresse du flux RSS. http://");


        this.cont.gridx = 0;
        this.add(this.title, cont);

        this.cont.gridx++;
        this.add(this.urlField, cont);

        this.cont.gridx++;
        this.add(this.checkBtn, cont);

        this.cont.gridx++;
        this.add(this.saveBtn, cont);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == checkBtn && !urlField.getText().equals("")){
            listener.onRSSUpdate(new RSSFeed(urlField.getText()));
        } else if (e.getSource() == saveBtn && !urlField.getText().equals("")){
            feeds.addRSSFeed(urlField.getText());
        }
    }

    public void addRSSListener(RSSUpdateListener listener) {
        this.listener = listener;
    }
}
