package com.example.applicationserie;

import android.content.Context;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JSONHelper {
    public ArrayList<Serie> getLesSeries() {
        return lesSeries;
    }

    ArrayList<Serie> lesSeries=new ArrayList<Serie>();
    public JSONHelper(Context context)
    {


     try {
        JSONObject obj = new JSONObject(loadJSONFromAsset(context));
        JSONArray userArray = obj.getJSONArray("data");
        for (int i = 0; i < userArray.length(); i++) {
            JSONObject userDetail = userArray.getJSONObject(i);
            Serie serie=new Serie(userDetail.getLong("id"),userDetail.getString("titre"),userDetail.getString("resume"),userDetail.getString("duree"),userDetail.getString("premiereDiffusion"),userDetail.getString("image"));
            SerieSqlHelper dbhelper =new SerieSqlHelper(context);
            dbhelper.addSerie(serie);
            lesSeries.add(serie);
        }


    } catch (
    JSONException e) {
        e.printStackTrace();
    }

    }
    public String loadJSONFromAsset(Context context){
        String json = null;
        try {
            context.getAssets();
            InputStream is = context.getAssets().open("serie.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
        }
        public Serie getSerie(int position)
        {
            return lesSeries.get(position);
        }
    }
