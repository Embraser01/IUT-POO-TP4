package views.listener;

import models.RSSFeed;

/**
 * Created by Marc-Antoine on 15/12/2015.
 */
public interface RSSUpdateListener {
    void onRSSUpdate(RSSFeed rssFeed);
}
