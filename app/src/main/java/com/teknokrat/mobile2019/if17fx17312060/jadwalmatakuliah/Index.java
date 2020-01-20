package com.teknokrat.mobile2019.if17fx17312060.jadwalmatakuliah;

import android.app.Application;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Index extends Application {

    public void onCreate(){

        super.onCreate();
        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser !=null){

            startActivity(new Intent(Index.this
                    ,MainActivity.class));
        }

    }
}