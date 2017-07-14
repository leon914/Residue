package com.example.lhi06.residue;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.add_review) FloatingActionButton addReviewButton;
    @BindView(R.id.request) EditText searchField;
    @BindView(R.id.search_button) Button searchButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //TODO: Code for searching for reviews done
                //String artistName = editText1.getText().toString();
                //handler.urlBuilder(artistName);
            }
        });

        addReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                startActivity(new Intent(MainActivity.this, FindAlbumActivity.class));
            }
        });

    }

}
