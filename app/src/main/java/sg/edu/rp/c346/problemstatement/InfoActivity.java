package sg.edu.rp.c346.problemstatement;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Grade> grade;
    int requestcode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        lv = (ListView) this.findViewById(R.id.ListViewGrade);
        grade = new ArrayList<Grade>();
        grade.add(new Grade("Week 1", "A"));
        grade.add(new Grade("Week 2", "A"));
        grade.add(new Grade("Week 3", "A"));
        aa = new GradeAdapter(this,R.layout.row,grade);

        lv.setAdapter(aa);


        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.

        int id = item.getItemId();

        if (id == R.id.InfoSelection) {
            Intent rpIntent = new Intent(Intent.ACTION_VIEW);
            // Set the URL to be used.
            rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
            startActivity(rpIntent);

            return true;
        }else if (id == R.id.AddSelection) {

            Intent i = new Intent(InfoActivity.this,
                    Add_dataActivity.class);
            int week = grade.size() + 1;

            i.putExtra("week", week);
            startActivityForResult(i, requestcode);

            return true;
        }else if (id == R.id.EmailSelection) {
            StringBuilder text = new StringBuilder();
            for (Grade i : grade) {
                text.append(i.getWeek() + ": Daily Grade: " + i.getGrade());
                text.append("\n");
            }

            // The action you want this intent to do;
            // ACTION_SEND is used to indicate sending text
            Intent email = new Intent(Intent.ACTION_SEND);
            // Put essentials like email address, subject & body text
            email.putExtra(Intent.EXTRA_EMAIL,
                    new String[]{"jason_lim@rp.edu.sg"});
            email.putExtra(Intent.EXTRA_SUBJECT,
                    "Test Email from C347");
            email.putExtra(Intent.EXTRA_TEXT,
                    "Hello , \nI am Jiming\n Please see my remarks so far, thankyou!\n\n" + text.toString());

            // This MIME type indicates email
            email.setType("message/rfc822");
            // createChooser shows user a list of app that can handle
            // this MIME type, which is, email
            startActivity(Intent.createChooser(email,
                    "Choose an Email client :"));




            return true;
        }else  {

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int 				resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {
                // Get data passed back from 2nd activity
                String gradeGet = data.getStringExtra("radiochoosen");
                String week = data.getStringExtra("week");
                // If it is activity started by clicking 				//  Superman, create corresponding String


                    grade.add(new Grade(week, gradeGet));
aa.notifyDataSetChanged();

                // If 2nd activity started by clicking
                //  Batman, create a corresponding String

            }
        }
    }
//    public void onSaveInstanceState(Bundle outState) {
//
//        super.onSaveInstanceState(outState);
//
//        // Note: getValues() is a method in your ArrayAdapter subclass
//        outState.putSerializable("mPersonList", grade);
//
//    }
//    @Override
//    protected void onRestoreInstanceState (Bundle savedInstanceState) {
//        this.grade = savedInstanceState.getStringArray("mPersonList"); //on coming back retrieve all values using key
//    }

}
