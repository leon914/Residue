package com.example.lhi06.residue;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.add_review)
    FloatingActionButton addReviewButton;
    @BindView(R.id.request)
    EditText searchField;

    @Override
    protected void onCreate(@NonNull final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        addReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull final View view) {
                startActivity(new Intent(MainActivity.this, FindAlbumActivity.class));
            }
        });

    }

    @OnClick(R.id.search_button)
    public void onSearchClicked(@NonNull final View view) {
        //TODO: Code for searching for reviews done
        //String artistName = editText1.getText().toString();
        //handler.urlBuilder(artistName);
    }

}
