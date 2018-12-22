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
    private String address;

    GetDetailData(String address) {
        this.address = address;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Document doc = Jsoup.connect(address).get();
            Elements mElementDataSize = doc.select( "" );

            String title = mElementDataSize.select( "" ).text();
            String address = mElementDataSize.select( "" ).text();
            String date = mElementDataSize.select( "" ).text();
            list.add( new ItemObject( title,address,date ) );

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

}
