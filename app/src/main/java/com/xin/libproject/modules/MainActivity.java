package com.xin.libproject.modules;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xin.libproject.R;
import com.xin.libproject.modules.self.ListViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.helloworld)
    Button helloworld;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putChar("hello", 's');
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != savedInstanceState) {
            char h = savedInstanceState.getChar("hello");
            System.out.println("h----" + h);
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        helloworld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
                finish();

            }
        });
    }
}
