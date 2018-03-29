package com.apprensics.quizapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by ashish on 28/3/18.
 */

public class DetailsActivity extends AppCompatActivity {

    TextView userNameTextView, emailTextView, aboutTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userNameTextView = findViewById(R.id.user_name_text_view);
        emailTextView = findViewById(R.id.email_text_view);
        aboutTextView = findViewById(R.id.about_text_view);

        SharedPreferences sharedPreferences = getSharedPreferences(
                getString(R.string.PREFERENCE_FILE_KEY), Context.MODE_PRIVATE);;
        userNameTextView.setText(sharedPreferences.getString(getString(R.string.username),
                "DemoUserName"));
        emailTextView.setText(sharedPreferences.getString(getString(R.string.email),
                "DemoEmail"));
        aboutTextView.setText(sharedPreferences.getString(getString(R.string.about),
                "This is the Demo description and will replace with the original ones."));
    }
}
