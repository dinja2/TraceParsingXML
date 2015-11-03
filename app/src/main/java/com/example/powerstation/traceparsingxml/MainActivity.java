package com.example.powerstation.traceparsingxml;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import org.xmlpull.v1.XmlPullParser;
import java.util.ArrayList;



public class MainActivity extends ListActivity  {

    ArrayList<Food> foodsList = new ArrayList<Food>();

    String name;
    String price;
    String description;
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        try {
            XmlPullParser foodsParser = getResources().getXml(R.xml.foods);
            int eventType = foodsParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType==XmlPullParser.START_TAG) {
                    if (foodsParser.getName().equals("name")) {
                        foodsParser.next();
                        name=foodsParser.getText();
                    }
                    else if (foodsParser.getName().equals("price")) {
                        foodsParser.next();
                        price=foodsParser.getText();
                    }
                    else if (foodsParser.getName().equals("description")) {
                        foodsParser.next();
                        description=foodsParser.getText();
                    }
                }
                if (eventType==XmlPullParser.END_TAG && foodsParser.getName().equals("food")) {
                    foodsList.add(new Food(name,price, description));
                }

                eventType = foodsParser.next();
            }
        }
        catch (Throwable t) {
            Toast.makeText(this, "Error XML-file loading: " + t.toString(), Toast.LENGTH_LONG)
                    .show();
        }


        String[] from=new String[] { Food.NAME, Food.PRICE, Food.DESCRIPTION };
        int[] to=new int[] {R.id.nameView, R.id.priceView };

        ListAdapter adapter = new SimpleAdapter(this, foodsList, R.layout.food_list_item,from,to);
        setListAdapter(adapter);



    }
    @Override
    protected void onListItemClick (ListView l, View v, int position, long id) {
        //Food a = foodsList.get(position);
        //Toast.makeText(this, "Description : " + foodsList.get(position).get("description"),
         //       Toast.LENGTH_SHORT).show();
        String message = "Description : " + foodsList.get(position).get("description");
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

}