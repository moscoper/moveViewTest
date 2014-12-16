package com.example.moveviewtest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	private MoveView moveView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moveView = (MoveView) findViewById(R.id.moveview);
        moveView.setCanMove();
    }


    
}
