package com.dataversity.happywedz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dataversity.happywedz.utils.Tools;

public class OTPActivity extends AppCompatActivity {
    Context context;
    Button verify_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        verify_otp = findViewById(R.id.verify_otp);

        verify_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SendMessageActivity.class);
                startActivity(intent);
            }
        });
    }
}