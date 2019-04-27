package com.example.baiktgiuakiso2;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SanPhamActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Sanpham> models;
    Map<String,String> mMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        models = new ArrayList<>();
        recyclerView = findViewById(R.id.dt_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mMap.put("id","9");
        new SanphamAsyncTask(SanPhamActivity.this,new ivew() {
            @Override
            public void onRequestSuccess(Bitmap bitmap) {

            }

            @Override
            public void onGetDataSuccess(JSONArray jsonArray) {
                for (int i=0;i<jsonArray.length();i++){
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Sanpham model = new Sanpham();
                        model.setId(Integer.valueOf(jsonObject.getString("id")));
                        model.setProductName(jsonObject.getString("product_name"));
                        model.setPrice(Integer.valueOf(jsonObject.getString("price")));
                        model.setSdescription(jsonObject.getString("description"));
                        model.setProducer(jsonObject.getString("producer"));
                        models.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                MyStudentAdapter adapter = new MyStudentAdapter(SanPhamActivity.this,R.layout.itemdienthoai,models);
                recyclerView.setAdapter(adapter);
            }
        },mMap).execute( "http://www.vidophp.tk/api/account/getdata");

    }
}
