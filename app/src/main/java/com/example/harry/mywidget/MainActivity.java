package com.example.harry.mywidget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText input_edt;
    Button change_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        input_edt = (EditText)this.findViewById(R.id.input_edt);
        change_btn = (Button)this.findViewById(R.id.change_btn);
        change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(input_edt.getText().toString());
            }
        });
    }

    private void sendBroadcast(String message){
        Intent intent = new Intent(CustomWidget.BROADCAST_TAG);  //BROADCAST_TAG = "android.appwidget.action.APPWIDGET_UPDATE";
        intent.putExtra(CustomWidget.BROADCAST_RECEIVE_TAG,message);  //BROADCAST_RECEIVE_TAG = "ReceiveMessage";
        sendBroadcast(intent);
    }
}
