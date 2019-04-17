package ie.prowork.m3da;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ParseException;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.DatePicker;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.pm.ActivityInfo;
import com.github.gcacace.signaturepad.views.SignaturePad;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


    public class holiday_request extends AppCompatActivity {

    private static final String TAG = "holiday_request";

    private TextView mDisplayDateto;
    private TextView mDisplayDatefrom;
    private TextView absense_reason_tv;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;

    private long date;
    private DateFormat format;
    String currentDateandTime;
    String ReasonifOtherTv;

    RadioButton action;
    private RadioGroup holiday_request_radiogroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;
    private RadioButton rb6;
    private RadioButton rb7;
    private Button Submit_reason_btn;

    Button save_bt;
    SignaturePad signaturePad;
    Button savesig, clearsig;
    Context context;

    String my_name;

    String holiday_request_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday_request);

        SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateandTime = datef.format(new Date(date));

        TextView set_date = (TextView) findViewById(R.id.set_date_tv);
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            set_date.setText(format.format(ca.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        signaturePad = (SignaturePad) findViewById(R.id.signaturePad);

        savesig = (Button) findViewById(R.id.savesig);
        clearsig = (Button) findViewById(R.id.clearsig);
        savesig.setEnabled(false);
        RadioButton rb6 = (RadioButton) findViewById(R.id.rb6);

        rb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set up dialog

                //Type //Name you called thae memory space you just created
                Dialog dialog = new Dialog(holiday_request.this);
                dialog.setContentView(R.layout.reason_if_other_holidayrequest_dialog);
                Button Submit_reason_btn = (Button) dialog.findViewById(R.id.Submit_reason_btn);
                dialog.setTitle("Other");
                dialog.setCancelable(false);
                dialog.show();

                Submit_reason_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String current_timestamp = getTimestampForFirebase();
                        //Write this to Firebase after you have a timestamp
                        //current_timestamp


                    }
                });
            }
        });

        mDisplayDatefrom = (TextView) findViewById(R.id.datefrom_tv);
        mDisplayDateto = (TextView) findViewById(R.id.dateto_tv);
        mDisplayDatefrom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        holiday_request.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                dialog.show();
            }
        });

        mDisplayDateto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        holiday_request.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener2,
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
                mDisplayDatefrom.setText(date);
            }
        };

        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: date: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDateto.setText(date);
            }
        };


//        private void setupStuff(){
//            save_bt = (Button) findViewById(R.id.save_bt);
//
//            save_bt.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(holiday_request.this, "Clicked Me", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//        }

    }


    public String getTimestampForFirebase() {
        //Get timestamp as String and return it

        return "";
    }

    private void signaturepad(){

    signaturePad = (SignaturePad) findViewById(R.id.signaturePad);
    signaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {

        @Override
        public void onStartSigning() {
            //Event triggered when the pad is touched
        }

        @Override
        public void onSigned() {
            //Event triggered when the pad is signed
        }

        @Override
        public void onClear() {
            //Event triggered when the pad is cleared
        }
    });
    }
}