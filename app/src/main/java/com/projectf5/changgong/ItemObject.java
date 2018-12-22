package com.projectf5.changgong;

public class ItemObject {
    String address;
    String title;
    String date;

    public ItemObject(String url, String title, String date) {
        this.title = title;
        this.address = url;
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }
}
