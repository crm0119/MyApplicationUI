package com.example.acer.myapplicationui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText edtName, edtPwd;
    Button btnLog, btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtName = findViewById(R.id.edt_login_name);
        edtPwd = findViewById(R.id.edt_login_pwd);
        btnLog = findViewById(R.id.btn_login_log);
        btnReg = findViewById(R.id.btn_login_reg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });

        initView();
// 取出号码
        Map<String, String> userInfo = Utils.getUserInfo(LoginActivity.this);
        if (userInfo != null) {
// 显示在界面上
            edtName.setText(userInfo.get("userName"));
            edtPwd.setText(userInfo.get("pwd"));
        }

    }

    private void initView() {
        findViewById(R.id.btn_login_log).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = edtName.getText().toString().trim();
                String password = edtPwd.getText().toString();
                if (TextUtils.isEmpty(number)) {
                    Toast.makeText(LoginActivity.this, "请输入 QQ 号码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "请输入 账号", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                Log.i("MainActivity", "记住密码: " + number + ", " + password);
                boolean isSaveSuccess = Utils.saveUserInfo(LoginActivity.this, number,
                        password);
                if (isSaveSuccess) {
                    Toast.makeText(LoginActivity.this, "保存成功",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "保存失败",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}