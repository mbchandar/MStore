package org.zapota.mstore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
     
        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(4000);  //Delay of 10 seconds
                } catch (Exception e) {

                } finally {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);    	                                    	            
    	            SplashActivity.this.startActivity(intent);
    	            SplashActivity.this.finish();
                }
            }
        };
        welcomeThread.start();
    }
}
