package org.vispo.wheelpicker.demo;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.vispo.wheelpicker.core.AbstractWheelDecor;
import org.vispo.wheelpicker.core.AbstractWheelPicker;
import org.vispo.wheelpicker.view.WheelCrossPicker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AigeStudio 2015-12-06
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private MainDialog dialog;
    private Button btnObtainStraight, btnObtainCurved;

    private String dataStraight, dataCurved;
    private int padding;
    private int textSize;
    private int itemSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        padding = getResources().getDimensionPixelSize(R.dimen.WheelPadding);
        textSize = getResources().getDimensionPixelSize(R.dimen.TextSizeLarge);
        itemSpace = getResources().getDimensionPixelSize(R.dimen.ItemSpaceLarge);

        WheelCrossPicker straightPicker = (WheelCrossPicker) findViewById(R.id.main_wheel_straight);
        straightPicker.setItemIndex(3);
        straightPicker.setBackgroundColor(0xFFF3F0E6);
        straightPicker.setTextColor(0x000000);
        straightPicker.setCurrentTextColor(0xFF536D8A);
        straightPicker.setTextAlign("RIGHT");
        straightPicker.setTextSize(100);
        straightPicker.setOnWheelChangeListener(new AbstractWheelPicker.SimpleWheelChangeListener() {
            @Override
            public void onWheelScrollStateChanged(int state) {
                if (state != AbstractWheelPicker.SCROLL_STATE_IDLE) {
                    btnObtainStraight.setEnabled(false);
                } else {
                    btnObtainStraight.setEnabled(true);
                }
            }

            @Override
            public void onWheelSelected(int index, String data) {
                dataStraight = data;
            }
        });
        WheelCrossPicker curvedPicker = (WheelCrossPicker) findViewById(R.id.main_wheel_curved);
        curvedPicker.setBackgroundColor(0xFFF0DF98);
        curvedPicker.setTextColor(0x000000);
        curvedPicker.setCurrentTextColor(0xFF536D8A);
        curvedPicker.setTextAlign("LEFT");
        curvedPicker.setTextSize(100);
        curvedPicker.setOnWheelChangeListener(new AbstractWheelPicker.SimpleWheelChangeListener() {
            @Override
            public void onWheelScrollStateChanged(int state) {
                if (state != AbstractWheelPicker.SCROLL_STATE_IDLE) {
                    btnObtainCurved.setEnabled(false);
                } else {
                    btnObtainCurved.setEnabled(true);
                }
            }

            @Override
            public void onWheelSelected(int index, String data) {
                dataCurved = data;
            }
        });

        btnObtainStraight = (Button) findViewById(R.id.main_obtain_straight_btn);
        btnObtainStraight.setOnClickListener(this);
        btnObtainCurved = (Button) findViewById(R.id.main_obtain_curved_btn);
        btnObtainCurved.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int padding5x = padding * 5;
        switch (v.getId()) {
            case R.id.main_obtain_straight_btn:
                Toast.makeText(this, dataStraight, Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_obtain_curved_btn:
                Toast.makeText(this, dataCurved, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}