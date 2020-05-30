package com.demo.datepickerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.demo.datepickerdemo.datepicker.CustomDatePicker;
import com.demo.datepickerdemo.datepicker.DateFormatUtils;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private CustomDatePicker customDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = this.findViewById(R.id.txt);
        initTimerPicker();
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDatePicker.setmTvTitleValues("时间点");
                customDatePicker.show(txt.getText().toString());
            }
        });
        txt.setText(String.format("%s 00:00", DateFormatUtils.long2Str(System.currentTimeMillis(), false)));
    }

    /**
     * 初始化日期时间控件
     */
    public void initTimerPicker() {
        String beginTime = "1999-01-01 00:00";
        String endTime = DateFormatUtils.long2Str(System.currentTimeMillis(), true);
        customDatePicker = new CustomDatePicker(this, new CustomDatePicker.Callback() {
            @Override
            public void onTimeSelected(long timestamp) {
                String setTime = DateFormatUtils.long2Str(timestamp, true);
                txt.setText(setTime);
            }
        }, beginTime, endTime);
        customDatePicker.setCancelable(false);
        customDatePicker.setCanShowPreciseTime(true);
        customDatePicker.setScrollLoop(false);
        customDatePicker.setCanShowAnim(false);
    }
}