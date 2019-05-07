package sg.edu.rp.c346.problemstatement;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GradeAdapter extends ArrayAdapter<Grade> {
    private ArrayList<Grade> grade;
    private Context context;
    private TextView tvWeek;
    private TextView tvdaily;
    private TextView tvGrade;




    public GradeAdapter(Context context , int resource , ArrayList<Grade> objects){
        super(context,resource,objects);

        grade = objects;

        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvWeek =         rowView.findViewById(R.id.textViewWeek );
        // Get the ImageView object

        tvGrade = rowView.findViewById(R.id.textViewGrade);



        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Grade   current = grade.get(position);
        // Set the TextView to show the food



        tvWeek.setText(current.getWeek());
        tvGrade.setText(current.getGrade());
        if (current.getGrade().equalsIgnoreCase("f")){
            tvGrade.setTextColor(Color.RED);
        }else if(current.getGrade().equalsIgnoreCase("x")){
            tvGrade.setTextColor(Color.BLUE);
        }else {
            tvGrade.setTextColor(Color.GREEN);
        }








        // Set the image to star or nostar accordingly

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
