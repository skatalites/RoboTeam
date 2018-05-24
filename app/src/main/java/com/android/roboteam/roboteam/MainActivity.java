package com.android.roboteam.roboteam;

import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

import com.android.roboteam.roboteam.bluetooth.BaseActivity;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends BaseActivity {


    //@OnClick(R.id.cta_left)
    @OnClick(R.id.buttonI)
    public void leftClicked() {
        sendMessage("c");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
         /*Button button_I = (Button) findViewById(R.id.buttonI);
        Button button_D = (Button) findViewById(R.id.buttonD);
        Button button_Ad = (Button) findViewById(R.id.buttonAd);
        Button button_At = (Button) findViewById(R.id.buttonAt);


        button_I.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View V){
                onButtonIClicked();
            }
        });

        button_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View V){
                onButtonDClicked();
            }
        });

        button_Ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View V){
                onButtonAdClicked();
            }
        });

        button_At.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View V){
                onButtonAtClicked();
            }
        });

    */
    }


    @OnClick(R.id.buttonI)
    void onButtonIClicked() {
        sendMessage("u");
    }

    @OnClick(R.id.buttonD)
    void onButtonDClicked() {
        sendMessage("c");

    }

    @OnClick(R.id.buttonAd)
    void onButtonAdClicked() {
        sendMessage("f");

    }

    @OnClick(R.id.buttonAt)
    void onButtonAtClicked() {
        sendMessage("b");

    }

    @OnClick(R.id.buttonP)
    void onButtonPClicked() {
        sendMessage("s");

    }
    @Override
    protected void onResume() {
        super.onResume();

    }



}
