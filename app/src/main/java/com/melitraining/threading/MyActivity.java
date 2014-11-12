package com.melitraining.threading;

import android.app.Activity;
import android.net.http.AndroidHttpClient;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    /**
     * Blocks UI Thread for 10 seconds
     */
    public void blockUIThread(View v) throws InterruptedException {
        Thread.sleep(10000);
    }

    /**
     * Downloads an item and updates the views.
     */
    public void downloadItem(View v) throws Exception {
        String url = "https://api.mercadolibre.com/items/MLA527980245";
        AndroidHttpClient client = AndroidHttpClient.newInstance("Android");
        String jsonString;
        HttpResponse response = client.execute(new HttpGet(url));
        jsonString = EntityUtils.toString(response.getEntity());
        client.close();

        // parse response and update views of last item searched
    }


}
