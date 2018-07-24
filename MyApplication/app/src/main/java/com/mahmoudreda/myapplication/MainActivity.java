package com.mahmoudreda.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView big_text, sum_of_word;
    TextView test;
    Button check;
    String rev, out = "l", word[];
    int i, len, l, count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        big_text = findViewById(R.id.text);
        sum_of_word = findViewById(R.id.count);
        test = findViewById(R.id.textView);
        check = findViewById(R.id.check);

        check.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {


                //split to check word
                word = test.getText().toString().split(" ");
                count = 0;
                out = "";
                //inverse input & comber
                if (test.getText().toString().length() == 0) {
                    test.setError("text cannot be null");
                } else {
                    for (l = 0; l <= word.length - 1; l++) {
                        rev = "";
                        len = word[l].length();

                        for (i = len - 1; i >= 0; i--) {
                            rev = rev + word[l].charAt(i);
                        }
                        if (word[l].equals(rev) && rev.length() > 1) {
                            count = count + 1;
                            if (out.length() <= word[0].length()) {
                                out = word[l];
                            }
                        } else if (word[1] == null) {
                            out = "no word found";
                        }
                    }
                }
                big_text.setText(out);
                sum_of_word.setText(Integer.toString(count));
            }
        });
    }
}