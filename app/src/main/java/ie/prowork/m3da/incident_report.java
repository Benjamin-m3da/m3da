package ie.prowork.m3da;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ParseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class incident_report extends AppCompatActivity {
    private static final String TAG = "incident report";

    private TextView mDisplayDateto;
    private TextView mDisplayDatefrom;
    private TextView _incident_report_select_date_tv;
    private TextView date_of_accident_tv;
    private TextView textView122;
    private DateFormat format;
    String currentDateandTime;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;

    private long date;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_report);

        SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateandTime = datef.format(new Date(date));

        TextView set_date = (TextView) findViewById(R.id._incident_report_select_date_tv);
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            set_date.setText(format.format(ca.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mDisplayDatefrom = (TextView) findViewById(R.id._incident_report_select_date_tv);
        mDisplayDateto = (TextView) findViewById(R.id.date_of_accident_tv);

        mDisplayDatefrom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        incident_report.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: date: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                _incident_report_select_date_tv.setText(date);
            }
        };


        mDisplayDateto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        incident_report.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener2,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                dialog.show();
            }
        });

        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: date: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                date_of_accident_tv.setText(date);
            }
        };





    }


    public void showToast(View view){


        Toast.makeText(incident_report.this,((CheckBox) findViewById(view.getId())).getText().toString() , Toast.LENGTH_LONG).show();

    }


}
