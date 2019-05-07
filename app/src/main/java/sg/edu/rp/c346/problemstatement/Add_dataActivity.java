package sg.edu.rp.c346.problemstatement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import javax.xml.transform.Result;

public class Add_dataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        Intent i = getIntent();
        int week = i.getIntExtra("week", 0);
        Button btnSubmit = findViewById(R.id.buttonsubmit);
        final RadioGroup rgGrade = findViewById(R.id.RadioGroupGrade);
        final TextView tvweek = findViewById(R.id.textViewWeek);
        tvweek.setText("Week " + week);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                int id = rgGrade.getCheckedRadioButtonId();
                RadioButton checkegrade = (RadioButton)findViewById(id);
                String grade = checkegrade.getText().toString();
                i.putExtra("week", tvweek.getText());
                i.putExtra("radiochoosen",grade );
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
            }
