package models;

import views.listener.FeedsUpdateListener;

import java.util.ArrayList;

/**
 * Created by Marc-Antoine on 15/12/2015.
 */
public class Feeds {
    private ArrayList<RSSFeed> rssFeeds;

    private int next;

    private FeedsUpdateListener listener;

    public Feeds() {
        rssFeeds = new ArrayList<>();
        listener = null;
        next = 0;
    }

    public void addRSSFeed(String link) {
        RSSFeed tmp = new RSSFeed(link);
        rssFeeds.add(tmp);
        if(listener != null) listener.onFeedsUpdate(tmp);
    }

    public RSSFeed searchId(int id){
        for (RSSFeed rssFeed : rssFeeds) if (rssFeed.get_id() == id) return rssFeed;
        return null;
    }

    public RSSFeed searchTitle(String title){
        for (RSSFeed rssFeed : rssFeeds) if (rssFeed.getTitle().equals(title)) return rssFeed;
        return null;
    }


    public RSSFeed resetCursor() {
        next = 0;
        if(rssFeeds.size() == 0)return null;

        next++;
        return rssFeeds.get(next - 1);
    }

    public RSSFeed next() {
        if(next >= rssFeeds.size()) {
            next = 0;
            return null;
        }
        next++;
        return rssFeeds.get(next - 1);
    }

    public void addFeedsUpdateListener(FeedsUpdateListener listener){
        this.listener = listener;
    }
}
