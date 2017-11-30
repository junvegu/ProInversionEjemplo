package com.cjava.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {





    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_login_fb)
    Button btnLoginFb;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_recovery)
    TextView tvRecovery;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_view);
        ButterKnife.bind(this);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();


        Glide.with(this).load("http://www.spiritanimal.info/pictures/hawk/Hawk-Spirit-Animal-5.jpg").apply(RequestOptions.circleCropTransform())
                .into(ivLogo);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.btn_login, R.id.btn_login_fb, R.id.tv_register, R.id.tv_recovery})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_login_fb:
                Toast.makeText(this, "Login con facebook", Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_register:

                Toast.makeText(this, "Registrarse", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_recovery:
                Toast.makeText(this, "Recuperar Contraseña", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
