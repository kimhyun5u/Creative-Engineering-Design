package com.projectf5.changgong;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class GetDetailData extends AsyncTask<Void, Void, Void> {
    private ArrayList<ItemObject> list = new ArrayList();
    private ProgressDialog progressDialog;
    private String url;
    private String title;
    private String address;
    private String date;

    public GetDetailData(String address) {
        this.url = address;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements mElementDataSize = doc.select( "" );

            title = mElementDataSize.select( "" ).text();
            address = mElementDataSize.select( "" ).text();
            date = mElementDataSize.select( "" ).text();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Void result) {

    }

//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//
//        progressDialog = new ProgressDialog(NoticeActivity.this);
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        progressDialog.show();
//    }

    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }
}
