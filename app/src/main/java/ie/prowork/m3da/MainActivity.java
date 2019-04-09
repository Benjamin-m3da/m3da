package ie.prowork.m3da;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.Window;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Context context;

    private Button holiday_button;
    private DatabaseReference mDatabase;
    private EditText employee_name_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        holiday_button = (Button) findViewById(R.id.holiday_button);

        holiday_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, holiday_request.class));
                //will open Login activity

            }
        });
    }

    private void showdialog() {
        // TODO Auto-generated method stub
        ExampleDialog dialog = new ExampleDialog();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog);
    }
    public void showtoast(View v)
    {
        Button b = (Button)v;
        String text = b.getText().toString();
        Toast.makeText(getApplicationContext(), "button clicked is" + text, Toast.LENGTH_SHORT).show();
    }
}

