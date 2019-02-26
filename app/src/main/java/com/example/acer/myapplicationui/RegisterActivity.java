package com.example.acer.myapplicationui;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
EditText edtName,edtPwd;
Button btnReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtName=findViewById(R.id.edt_register_name);
        edtPwd=findViewById(R.id.edt_register_pwd);
        btnReg=findViewById(R.id.btn_register_reg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp =getSharedPreferences("data",
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                String password=edtPwd.getText().toString();
                String number=edtName.getText().toString();
                if(password.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
                if(number.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "账号不能为空", Toast.LENGTH_SHORT).show();
                }
                edit.putString("userName", number);
                edit.putString("pwd", password);
                edit.commit();
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();


            }
        });


    }
}

