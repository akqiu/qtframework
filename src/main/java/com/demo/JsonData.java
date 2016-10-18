package com.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiutian on 16-9-25.
 */
public class JsonData {

    public boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public int getQuota_max() {
        return quota_max;
    }

    public void setQuota_max(int quota_max) {
        this.quota_max = quota_max;
    }

    public int getQuota_remaining() {
        return quota_remaining;
    }

    public void setQuota_remaining(int quota_remaining) {
        this.quota_remaining = quota_remaining;
    }

    public List<JsonDataItem> getItems() {
        return items;
    }

    public void setItems(List<JsonDataItem> items) {
        this.items = items;
    }

    private boolean has_more;

    private int quota_max;

    private int quota_remaining;

    private List<JsonDataItem> items = new ArrayList<JsonDataItem>();


}
