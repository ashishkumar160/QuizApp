package com.apprensics.quizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ashish on 28/3/18.
 */

public class MainActivity extends AppCompatActivity {

    EditText userNameEditText, emailEditText, aboutEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        userNameEditText = findViewById(R.id.user_name_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        aboutEditText = findViewById(R.id.about_edit_text);

        if (savedInstanceState != null) {
            userNameEditText.setText(savedInstanceState.getString(getString(R.string.username)));
            emailEditText.setText(savedInstanceState.getString(getString(R.string.email)));
            aboutEditText.setText(savedInstanceState.getString(getString(R.string.about)));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(getString(R.string.username), userNameEditText.getText().toString());
        outState.putString(getString(R.string.email), emailEditText.getText().toString());
        outState.putString(getString(R.string.about), aboutEditText.getText().toString());
    }

    public void nextButton(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(
                getString(R.string.PREFERENCE_FILE_KEY), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.username), userNameEditText.getText().toString());
        editor.putString(getString(R.string.email), emailEditText.getText().toString());
        editor.putString(getString(R.string.about), aboutEditText.getText().toString());
        if (editor.commit()) {
            startActivity(new Intent(this, DetailsActivity.class));
            userNameEditText.setText("");
            emailEditText.setText("");
            aboutEditText.setText("");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_account:
                startActivity(new Intent(this, DetailsActivity.class));
                return true;
            default:
                Toast.makeText(this, "Unknown Menu item clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
