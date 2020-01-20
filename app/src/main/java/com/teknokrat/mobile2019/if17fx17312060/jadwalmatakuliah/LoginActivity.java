package com.teknokrat.mobile2019.if17fx17312060.jadwalmatakuliah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email,password;
    private ProgressBar progressBar;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //get firebase auth instance
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        if(mAuth.getCurrentUser() !=null){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();

        }
        setContentView(R.layout.activity_login);
//        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar)
        email =(EditText) findViewById(R.id.email_login);
        password=(EditText) findViewById(R.id.password_login);
        btnLogin=(Button) findViewById(R.id.btn_login);
//        mAuth = FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_login = email.getText().toString();
                final String password_login = password.getText().toString();
                if (TextUtils.isEmpty(email_login)){
                    Toast.makeText(getApplicationContext(),"Masukan Email Anda !",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password_login)){
                    Toast.makeText(getApplicationContext(),"Masukan Password Anda !",
                            Toast.LENGTH_SHORT).show();
                    return;

                }
                mAuth.signInWithEmailAndPassword(email_login,password_login)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(!task.isSuccessful()){
                                    if (password.length()<6){
                                        password.setError(getString(R.string.minimum_password));

                                    }else {

                                        Toast.makeText(LoginActivity.this,
                                                getString(R.string.auth_failed),Toast.LENGTH_LONG).show();
                                    }


                                } else {
                                    Intent intent = new Intent(LoginActivity.this,
                                            MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    finish();

                                }
                            }
                        });
            }
        });
    }


}