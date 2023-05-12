package com.t.flendzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView name, email, id, phone;
    TextView website, cname;
    TextView suite, street, city, zipcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        id = findViewById(R.id.id);
        phone = findViewById(R.id.phone);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        website = findViewById(R.id.website);
        suite = findViewById(R.id.suite);
        street = findViewById(R.id.street);
        city = findViewById(R.id.city);
        zipcode = findViewById(R.id.zipcode);
        cname = findViewById(R.id.cname);

        id.setText(getIntent().getExtras().getString("id"));
        name.setText(getIntent().getExtras().getString("name"));
        email.setText(getIntent().getExtras().getString("email"));
        phone.setText(getIntent().getExtras().getString("phone"));
        website.setText(getIntent().getExtras().getString("website"));
        suite.setText(getIntent().getExtras().getString("suite"));
        street.setText(getIntent().getExtras().getString("street"));
        city.setText(getIntent().getExtras().getString("city"));
        zipcode.setText(getIntent().getExtras().getString("zipcode"));
        cname.setText(getIntent().getExtras().getString("cname"));


        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openLinks = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com/"));
                v.getContext().startActivity(openLinks);
            }
        });

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