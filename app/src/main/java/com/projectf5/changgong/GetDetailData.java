package com.projectf5.changgong;

import android.os.AsyncTask;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class GetDetailData extends AsyncTask<Void, Void, Void> {
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
            Elements mElementDataSize = doc.select( "div[class=page_lis]" ).select( "tbody" ).select( "tr" );

            title = mElementDataSize.select( "tr td[class=left]" ).select( "span a" ).attr("tittle");
            address = mElementDataSize.select( "tr td[class=left]" ).select( "span a" ).attr( "href" );
            date = mElementDataSize.select( "tr td[class=mview]" ).next().
                    text();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Void result) {

    }

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
