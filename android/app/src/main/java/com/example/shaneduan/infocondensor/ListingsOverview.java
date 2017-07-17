package com.example.shaneduan.infocondensor;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListingsOverview extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    // NOTICE: These constants are part of a placeholder.
    // Please replace with a working version, or delete if necessary.
    private static final String[] titleStrings = {"Apple", "Bear", "Candle", "Dirt"},
            descStrings = {"A fruit.", "An animal.", "A light source.", "You can grow stuff in this."};

    private SwipeRefreshLayout swipeLayout;

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings_overview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        makeListView();
        makeSwipeRefreshLayout();
        // TODO: Add filters.
    }

    // NOTICE: These variables are part of a placeholder.
    // Please refactor them to work with a working version, or delete if necessary.
    SimpleAdapter listingsAdapter;
    ArrayList<Map<String,String>> listings;

    /**
     * Links and populates the ListView with initial data.
     */
    private void makeListView() {
        listings = createList();
        listingsAdapter = createAdapter(listings);

        ListView listView = (ListView) findViewById(R.id.entries);
        listView.setAdapter(listingsAdapter);
    }

    /**
     * Links the SwipeRefreshLayout and sets the callback.
     */
    private void makeSwipeRefreshLayout() {
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        swipeLayout.setOnRefreshListener(this);
    }

    /**
     * Gets a list of data.
     *
     * @return A list of hashmaps of entries.
     */
    private ArrayList<Map<String, String>> createList() {
        ArrayList<Map<String, String>> list = new ArrayList<Map<String,String>>();
        for (int i = 0; i < titleStrings.length; i++) {
            // NOTICE: The entries are placeholders.
            // Please replace with a working process, or delete if unnecessary.
            list.add(createEntry(titleStrings[i], descStrings[i]));
        }

        return list;
    }

    /**
     * Creates a Title and Description SimpleAdapter entry.
     *
     * @param k Title.
     * @param v Description.
     * @return Hashmap.
     */
    private Map<String, String> createEntry(String k, String v) {
        Map<String, String> data = new HashMap<String, String>();
        data.put("title", k);
        data.put("description", v);

        return data;
    }

    /**
     * Creates an adapter from a list of entries.
     *
     * @param entries Entries to put into adapter.
     * @return SimpleAdapter ready for use in ListView.
     */
    private SimpleAdapter createAdapter(ArrayList<Map<String, String>> entries) {
        String[] from = new String[] {"title", "description"};
        int[] to = new int[] {R.id.entry_title, R.id.entry_desc};

        return new SimpleAdapter(this, entries, R.layout.activity_listings_item, from, to);
    }


    @Override
    public void onRefresh() {
        retrieveUpdatedListings();
    }

    // NOTICE: This variable is part of a placeholder (- (? extends Runnable).nextFiller()).
    // Please delete once placeholder is no longer needed.
    private int iteration = 0;

    /**
     * Retrieves new data from a specified server.
     */
    private void retrieveUpdatedListings() {
        // NOTICE: This body is a placeholder.
        // Please replace with a working version, or delete if unnecessary.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeLayout.setRefreshing(false);

                updateData();
            }

            private void updateData() {
                // NOTICE: This body is a placeholder. (sorta)
                // Please replace with a working version, or delete if unnecessary.
                listings.add(createEntry(nextFiller(), nextFiller()));
                listingsAdapter.notifyDataSetChanged();
            }

            /**
             * NOTICE: This function is part of a placeholder. Please replace with working version,
             * or delete if unnecessary.
             *
             * Returns placeholder text.
             *
             * @return Filler String data.
             */
            private String nextFiller() {
                iteration = iteration * 8 + 1;

                return Integer.toString(iteration);
            }
        }, 300);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listings_overview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}