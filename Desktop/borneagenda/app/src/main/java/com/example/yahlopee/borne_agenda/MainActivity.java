package com.example.yahlopee.borne_agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.text.format.Time;
import android.widget.HorizontalScrollView;
import android.widget.Toast;


import com.darwindeveloper.horizontalscrollmenulibrary.custom_views.HorizontalScrollMenuView;
import com.darwindeveloper.horizontalscrollmenulibrary.extras.MenuItem;


import java.text.DateFormat;

import java.util.Calendar;
import java.util.Date;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarListener;


public class MainActivity extends AppCompatActivity {

      HorizontalScrollMenuView menu;
      Date maDate = new Date();
    private HorizontalCalendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = (HorizontalScrollMenuView) findViewById(R.id.menu);
        initMenu();

        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        calendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .startDate(startDate.getTime())
                .endDate(endDate.getTime())
                .datesNumberOnScreen(5)
                .dayNameFormat("EEE")
                .dayNumberFormat("dd")
                .monthFormat("MMM")
                .textSize(14f, 24f, 14f)
                .showDayName(true)
                .showMonthName(true)
                .build();

        calendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Date date, int position) {
                Toast.makeText(MainActivity.this, DateFormat.getDateInstance().format(date) + " is selected!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public int getMois() {
        return maDate.getMonth()+1;
    }

    private void initMenu(){
        menu.addItem("LPSMIN", R.drawable.ic_ac);
        if (getMois()<2 || getMois()>8){
            menu.addItem("S1A", R.drawable.ic_ac);
            menu.addItem("S1B", R.drawable.ic_ac);
            menu.addItem("S1C", R.drawable.ic_ac);
            menu.addItem("S1LV2", R.drawable.ic_ac);
            menu.addItem("S3A", R.drawable.ic_ac);
            menu.addItem("S3B", R.drawable.ic_ac);
            menu.addItem("S3C", R.drawable.ic_ac);
            menu.addItem("S3LV2", R.drawable.ic_ac);
        }
        else{
            menu.addItem("S2A", R.drawable.ic_ac);
            menu.addItem("S2B", R.drawable.ic_ac);
            menu.addItem("S2C", R.drawable.ic_ac);
            menu.addItem("S2LV2", R.drawable.ic_ac);
            menu.addItem("S4A", R.drawable.ic_ac);
            menu.addItem("S4B", R.drawable.ic_ac);
            menu.addItem("S4C", R.drawable.ic_ac);
        }

        menu.setOnHSMenuClickListener(new HorizontalScrollMenuView.OnHSMenuClickListener() {
            @Override
            public void onHSMClick(MenuItem menuItem, int position) {
                Toast.makeText(MainActivity.this,""+getMois(),Toast.LENGTH_LONG).show();

            }
        });

    }
}
