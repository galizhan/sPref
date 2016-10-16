package kz.edu.sdu.galix.prefences;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@TargetApi(Build.VERSION_CODES.N)
public class ShowActivity extends AppCompatActivity {

    SharedPreferences sp;
    TableLayout tbl;
    final String TAG = "States";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        sp = getSharedPreferences("newSpref1",MODE_PRIVATE);
        tbl = (TableLayout) findViewById(R.id.tbl);
        Get();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Put("ActivityTwo: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Put("ActivityTwo: onStart()");
        Get();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Put("ActivityTwo: onResume()");
        Get();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Put("ActivityTwo: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Put("ActivityTwo: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Put("ActivityTwo: onDestroy()");
    }

    public void Put(String s){
        SharedPreferences.Editor ed = sp.edit();
        ed.putString((new Date(System.currentTimeMillis())).toString(),s);
        ed.commit();
    }
    public void Get(){
        HashMap<String,String> mp = (HashMap<String, String>) sp.getAll();
        TableLayout.LayoutParams tbllp = new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        for(Map.Entry<String, String> entry : mp.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            TextView tv = new TextView(this);
            tv.setTextSize(20);
            tv.setText(key+" "+value);
            tbl.addView(tv,tbllp);
        }
    }
}
