package com.moraes.mobile.delivery_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroActivity extends AppCompatActivity {
    Button editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        editPassword = findViewById(R.id.btn_edit_passwd);
        editPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNewPasswd = new Intent(getApplicationContext(),NewPasswordActivity.class);
                startActivity(intentNewPasswd);

            }
        });
    }
}