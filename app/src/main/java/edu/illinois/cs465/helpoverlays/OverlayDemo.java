package edu.illinois.cs465.helpoverlays;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class OverlayDemo extends AppCompatActivity {
    View topLevelLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overlay_demo);
        View topLevelLayout = findViewById(R.id.top_layout);



        if (isFirstTime()) {
            topLevelLayout.setVisibility(View.INVISIBLE);
        }
    }

    private boolean isFirstTime()
    {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {

            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();
            topLevelLayout.setVisibility(View.VISIBLE);
            topLevelLayout.setOnTouchListener(new View.OnTouchListener(){

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    topLevelLayout.setVisibility(View.INVISIBLE);
                    return false;
                }

            });


        }
        return ranBefore;

    }
}
