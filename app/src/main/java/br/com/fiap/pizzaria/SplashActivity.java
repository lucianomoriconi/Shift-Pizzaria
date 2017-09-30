package br.com.fiap.pizzaria;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        carregar();
    }
    private void carregar() {
        Animation anim = AnimationUtils.loadAnimation(
                this, R.anim.splash);
        ImageView ivLogo = (ImageView) findViewById(R.id.ivLogo);
        ivLogo.clearAnimation();
        ivLogo.startAnimation(anim);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent telaLogin = new  Intent(SplashActivity.this, LoginActivity.class);
                startActivity(telaLogin);
                finish();
            }
        }, 3500);
    }

}
