package com.example.kimyongtak.handlersample;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_count;
    Handler han;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_count = findViewById(R.id.tv_count);
        tv_count.setText("20");
        han = new Handler();

        CountThread ct = new CountThread(1);
        CountThread ct2 = new CountThread(2);
        CountThread ct3 = new CountThread(3);
        ct.start();
        ct2.start();
        ct3.start();


    }

    private class CountThread extends Thread {
        int threadNumber;
        public CountThread(int threadNumber) {
            this.threadNumber = threadNumber;
        }
        int count = 0;
        public void run() {
            while(count<100) {
                ++count;
                Log.i("TAG", "Thread" + threadNumber + " : " + count);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


//                han.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        tv_count.setText(String.valueOf(count));
//                    }
//                });

            }
        }
    }
}
