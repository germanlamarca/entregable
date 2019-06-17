package com.example.german_entregable;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView showName;
    TextView showLastName;
    TextView showWeb;
    TextView showTel;
    TextView showCounter;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        showName = findViewById(R.id.showName);
        showLastName = findViewById(R.id.showLastName);
        showWeb = findViewById(R.id.showWeb);
        showTel = findViewById(R.id.showTel);
        showCounter = findViewById(R.id.showCounter);

        String name = getIntent().getStringExtra("name");
        String lastName = getIntent().getStringExtra("lastName");
        String web = getIntent().getStringExtra("web");
        int tel = getIntent().getIntExtra("tel",0);

        showName.setText(name);
        showLastName.setText(lastName);
        showWeb.setText(web);
        showTel.setText(String.valueOf(tel));

        updateCounter();
    }
    public void clickOnWeb(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("web"));
        startActivity(intent);
    }

    public void clickOnTel(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        String tel = showTel.getText().toString();
        intent.setData(Uri.parse("tel:" + tel));
        startActivity(intent);
    }

    @Override

    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void updateCounter() {
        prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        int counter = prefs.getInt("counter", 0);
        counter++;
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("counter", counter);
        editor.commit();
        showCounter.setText(String.valueOf(prefs.getInt("counter", 0)));
    }
}
