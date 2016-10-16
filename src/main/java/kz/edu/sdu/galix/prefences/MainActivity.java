package kz.edu.sdu.galix.prefences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    TextView tv;
    RelativeLayout rl;
    Button btn;
    TableLayout tbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        rl = (RelativeLayout) findViewById(R.id.rel);
        sp = getSharedPreferences("newSpref",MODE_PRIVATE);
        btn = (Button) findViewById(R.id.btn1);
        Animation a = AnimationUtils.
                loadAnimation(MainActivity.this, R.anim.animation);
        if(isFirst()) {rl.removeView(tv); Log.d("bool",""+isFirst());}
        else {tv.startAnimation(a); first(); Log.d("bool",""+isFirst());}

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ShowActivity.class);
                startActivity(i);
            }
        });
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
        
    }

    @Override
    protected void onResume() {
        super.onResume();
        Put("ActivityTwo: onResume()");
        
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
    
    public void first(){
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean("first",true);
        ed.commit();
    }
    public boolean isFirst(){
        return sp.getBoolean("first",false);
    }


}
