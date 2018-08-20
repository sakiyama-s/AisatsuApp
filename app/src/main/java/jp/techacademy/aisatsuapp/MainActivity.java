package jp.techacademy.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView1);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.button1){
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog(){
        TimePickerDialog timerPickDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI_PARTS",String.valueOf(hourOfDay) + ":"+ String.valueOf(minute));
                        if(2 <= hourOfDay && hourOfDay <= 9){
                            mTextView.setText("おはよう");
                        }else if(10 <= hourOfDay && hourOfDay <= 17){
                            mTextView.setText("こんにちは");
                        }else{
                            mTextView.setText("こんばんは");
                        }
                    }
                },
                13,
                0,
                true);
        timerPickDialog.show();

    }
}
