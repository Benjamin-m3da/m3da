package ie.prowork.m3da;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Context context;

    private Button holiday_button;
    private Button incident_report_button;
    private Button update_timestamp_btn;
    private DatabaseReference mDatabase;
    private EditText employee_name_et;
    private Button mFirebaseBtn;
    private TextView mTimestampField;
    private TextView mViewTimestampField;
    private String WriteTimeStampString;
    private String ViewTimeStampString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView tdate = (TextView) findViewById(R.id.Current_TimeStamp);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy hh-mm-ss a");
                                String dateString = sdf.format(date);
                                tdate.setText(dateString);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();



        holiday_button = (Button) findViewById(R.id.holiday_button);
        holiday_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, holiday_request.class));
                //will open Login activity

            }
        });

        incident_report_button = (Button) findViewById(R.id.incident_report_button);
        incident_report_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, incident_report.class));
                //will open Login activity

            }
        });



        update_timestamp_btn = (Button) findViewById(R.id.update_timestamp_btn);
        update_timestamp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
            private void showdialog() {
                // TODO Auto-generated method stub
                ExampleDialog dialog = new ExampleDialog();
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.layout_dialog);
            }
            public void showtoast(View v) {
                Button b = (Button) v;
                String text = b.getText().toString();
                Toast.makeText(getApplicationContext(), "button clicked is" + text, Toast.LENGTH_SHORT).show();
            }
            ;
        });

        mFirebaseBtn = (Button) findViewById(R.id.update_timestamp_btn);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("User_01");
        mTimestampField = (TextView) findViewById(R.id.Current_TimeStamp);
        mViewTimestampField = (TextView) findViewById(R.id.Previous_Timestamp);




        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1 Create the child in the root object
                // Assign the value of the chosen input field to the child object
                String TimeStampString = mTimestampField.getText().toString();
                mDatabase.child("TimeStamp").setValue(TimeStampString);

                HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("TimeStamp", TimeStampString);

                mDatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(MainActivity.this, "Sucessfully stored Timestamp to Firebase", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(MainActivity.this, " Error could not write to Firebase", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                mViewTimestampField = (TextView) findViewById(R.id.Previous_Timestamp);
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String ViewTimeStampString = dataSnapshot.child("TimeStamp").getValue().toString();
                        mViewTimestampField.setText(ViewTimeStampString);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });





            }
        });



    };

}