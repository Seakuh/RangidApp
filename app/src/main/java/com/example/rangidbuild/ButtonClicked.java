package com.example.rangidbuild;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class ButtonClicked extends Activity {

    int i = 0;
    Button backenButton;
    View backenDruck;
    LinearLayout mLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.buttonclickedlayout);
        System.out.println("In ButtonClicked Klasse");
        mLayout = (LinearLayout) findViewById(R.id.rangierenlayout);
        final MediaPlayer awwyeah = MediaPlayer.create(this, R.raw.awwjeah);
        final MediaPlayer slapsound = MediaPlayer.create(this, R.raw.slap);
        final MediaPlayer jasound = MediaPlayer.create(this, R.raw.ja);
        final MediaPlayer ewwsound = MediaPlayer.create(this, R.raw.ewwwww);
        final MediaPlayer stimmbandsound = MediaPlayer.create(this, R.raw.stimmbandkontitionen);

        final MediaPlayer imstrahl = MediaPlayer.create(this, R.raw.imstrahlk);

        backenButton = (Button) findViewById(R.id.backenButton);
        backenDruck = (View) findViewById(R.id.backendruck);

        backenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                System.out.println("Button gedrückt");
                System.out.println("Button gedrückt");
                System.out.println("Button gedrückt");
                System.out.println("---------------");
                System.out.println(i);
                if (i == 10) {
                    imstrahl.start();
                    Vibrator vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    // Vibrate for 500 milliseconds
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vi.vibrate(VibrationEffect.createOneShot(3000, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        //deprecated in API 26
                        vi.vibrate(3000);
                    }
                    new CountDownTimer(1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            mLayout.setBackgroundResource(R.drawable.rangidaufwachen);
                        }

                        public void onFinish() {
                            mLayout.setBackgroundResource(R.drawable.rangidaufwachen);
                        }
                    }.start();

                } else if (i == 11) {
                    Intent intent = new Intent(ButtonClicked.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    new CountDownTimer(200, 1000) {
                        public void onTick(long millisUntilFinished) {
                            mLayout.setBackgroundResource(R.drawable.intouch);
                        }

                        public void onFinish() {
                            mLayout.setBackgroundResource(R.drawable.notouch);
                        }
                    }.start();

                }


                if (i == 2) {
                    ewwsound.start();
                } else if (i == 5) {
                    stimmbandsound.start();
                } else if (i == 7) {
                    jasound.start();

                } else {
                    slapsound.start();
                }
            }
        });
    }
}