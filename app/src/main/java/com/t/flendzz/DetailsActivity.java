package com.t.flendzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView name;
    TextView email;
    TextView id;
    TextView phone;
    TextView website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        id = findViewById(R.id.id);
        phone = findViewById(R.id.phone);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        website = findViewById(R.id.website);
        id.setText(getIntent().getExtras().getString("id"));
        name.setText(getIntent().getExtras().getString("name"));
        email.setText(getIntent().getExtras().getString("email"));
        phone.setText(getIntent().getExtras().getString("phone"));
        website.setText(getIntent().getExtras().getString("website"));

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+ getIntent().getExtras().getString("phone")));
                startActivity(intent);
            }
        });

    }
}