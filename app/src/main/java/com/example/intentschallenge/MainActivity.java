package com.example.intentschallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tvTitle;
    Button btnCreateNew;
    TextView tvName;
    static ImageView ivIcon;
    ImageView ivPhone;
    ImageView ivDirections;
    ImageView ivWeb;

    final int CONTACTINFO = 69;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateNew = findViewById(R.id.btnCreateNew);
        tvTitle = findViewById(R.id.tvTitle);
        tvName = findViewById(R.id.tvName);
        ivPhone = findViewById(R.id.ivPhone);
        ivDirections = findViewById(R.id.ivDirections);
        ivWeb = findViewById(R.id.ivWeb);
        ivIcon = findViewById(R.id.ivIcon);




        tvName.setVisibility(View.GONE);
        ivIcon.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivDirections.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);

        btnCreateNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.intentschallenge.ContactInfo.class);
                startActivityForResult(intent, CONTACTINFO);

                tvName.setVisibility(View.VISIBLE);
                ivIcon.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivDirections.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);

            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + ContactInfo.phoneNumber));
                startActivity(intent1);
            }
        });


        ivDirections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + ContactInfo.address));
                startActivity(intent2);
            }
        });


        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(ContactInfo.website));
                startActivity(intent3);
            }
        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CONTACTINFO)
        {
            if (resultCode == RESULT_OK)
            {
                tvName.setText(data.getStringExtra("nameData"));

            }
            if (resultCode == RESULT_CANCELED)
            {
                tvName.setText("Unknown");
            }
        }
    }

}
