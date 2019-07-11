package com.example.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactInfo extends AppCompatActivity {

    EditText etName, etNumber, etWebsite, etAddress;
    ImageView ivSad, ivNeutral, ivSmiley;
    TextView tvChoose;
    Button btnSubmit;
    static String phoneNumber;
    static String website;
    static String address;
    static String icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etWebsite = findViewById(R.id.etWebsite);
        etAddress = findViewById(R.id.etAddress);
        ivSad = findViewById(R.id.ivSad);
        ivNeutral = findViewById(R.id.ivNeutral);
        ivSmiley = findViewById(R.id.ivSmiley);
        tvChoose = findViewById(R.id.tvChoose);
        btnSubmit = findViewById(R.id.btnSubmit);



        ivSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon = "sad";
            }
        });


        ivNeutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon = "neutral";
            }
        });


        ivSmiley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icon = "smiley";
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name = etName.getText().toString().trim();
                phoneNumber = etNumber.getText().toString().trim();
                website = etWebsite.getText().toString().trim();
                address = etAddress.getText().toString().trim();

                Intent intent = new Intent();
                intent.putExtra("nameData", name);
                setResult(RESULT_OK, intent);


                if (icon.contentEquals("sad"))
                {
                    MainActivity.ivIcon.setImageResource(R.drawable.sad);
                }
                else if (icon.contentEquals("smiley"))
                {
                    MainActivity.ivIcon.setImageResource(R.drawable.smiley);
                }
                else
                {
                    MainActivity.ivIcon.setImageResource(R.drawable.neutral);
                }

                if (phoneNumber.contentEquals("") || website.contentEquals("") || address.contentEquals(""))
                {
                    Toast.makeText(ContactInfo.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }


                ContactInfo.this.finish();

            }
        });

//change1


    }

}
