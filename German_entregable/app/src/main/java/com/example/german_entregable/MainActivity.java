package com.example.german_entregable;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etLastName;
    EditText etWeb;
    EditText etTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.name);
        etLastName = findViewById(R.id.lastName);
        etWeb = findViewById(R.id.web);
        etTel = findViewById(R.id.tel);
    }

    //Override
    public boolean onSupportNavigateUp() {
        //finish();
        Toast.makeText(this, "Botó enrere apretat", Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.create_item:
                Toast.makeText(getApplicationContext(), "Opció seleccionada", Toast.LENGTH_LONG).show();
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }

    public void buttonDeletePressed(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle(getString(R.string.app_name));
        alertDialogBuilder.setMessage(getString(R.string.deleteAll)).setCancelable(false).setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                etName.setText("");
                etLastName.setText("");
                etWeb.setText("");
                etTel.setText("");
            }
        })
                .setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }

    public void buttonShowPressed(View view) {

        if (etName.getText().toString().trim().equalsIgnoreCase("")) {
            etName.setError(getString(R.string.empty));
        } else if (etLastName.getText().toString().trim().equalsIgnoreCase("")) {
            etLastName.setError(getString(R.string.empty));
        } else if (etWeb.getText().toString().trim().equalsIgnoreCase("")) {
            etWeb.setError(getString(R.string.empty));
        } else if (etTel.getText().toString().trim().equalsIgnoreCase("")) {
            etTel.setError(getString(R.string.empty));
        } else {
            toSecondActivity();
        }
    }


    public void toSecondActivity() {

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        String name = etName.getText().toString();
        String lastName = etLastName.getText().toString();
        String web = etWeb.getText().toString();
        int tel = Integer.parseInt(etTel.getText().toString());

        intent.putExtra("name", name);
        intent.putExtra("lastName", lastName);
        intent.putExtra("web", web);
        intent.putExtra("tel", tel);

        startActivity(intent);

    }
}