package com.example.apple.texttospeechapp;

import android.annotation.TargetApi;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText userInputToSpeech;
    private TextToSpeech convertToSpeech;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInputToSpeech = findViewById(R.id.speech_input);
        Button textToSpeech = findViewById(R.id.text_to_speech);

        textToSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String convertTextToSpeech = userInputToSpeech.getText().toString();
                if (convertTextToSpeech.equals("")) {
                    Toast.makeText(MainActivity.this, "The input field must not be empty", Toast.LENGTH_LONG).show();
                    return;
                }
                convertToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onInit(int status) {
                        if (status != TextToSpeech.ERROR) {
                            convertToSpeech.setLanguage(Locale.US);
                            convertToSpeech.speak(convertTextToSpeech, TextToSpeech.QUEUE_FLUSH, null, null);
                        }
                    }
                });
            }
        });
    }
    
}
