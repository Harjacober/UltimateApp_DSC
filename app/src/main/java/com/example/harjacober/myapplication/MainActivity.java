package com.example.harjacober.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mText;
    private Button mSaveButton;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getPreferences(Context.MODE_PRIVATE);
        mText = findViewById(R.id.edt_text);
        mSaveButton = findViewById(R.id.btn_save);
        String getText = preferences.getString("oldItem", "Nothing saved yet");
        mText.setText(getText);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("oldItem", mText.getText().toString());
                editor.apply();
                Animation animation = new AlphaAnimation(1.0f, 0.0f);
                animation.setDuration(1000);
                mSaveButton.startAnimation(animation);
            }
        });
    }
}
