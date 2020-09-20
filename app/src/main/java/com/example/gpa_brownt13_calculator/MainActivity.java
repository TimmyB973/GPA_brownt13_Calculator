package com.example.gpa_brownt13_calculator;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import org.w3c.dom.Text;

import static android.widget.Toast.*;


public class MainActivity extends AppCompatActivity {

    //initialize background variable
    private ConstraintLayout background;

    //initialize variables for courses & GPA
    EditText courseno1;
    EditText courseno2;
    EditText courseno3;
    EditText courseno4;
    EditText courseno5;
    TextView GPA;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign variables from text and for button
        background = findViewById(R.id.background);
        courseno1 = (EditText) findViewById(R.id.editText_course1);
        courseno2 = (EditText) findViewById(R.id.editText_course2);
        courseno3 = (EditText) findViewById(R.id.editText_course3);
        courseno4 = (EditText) findViewById(R.id.editText_course4);
        courseno5 = (EditText) findViewById(R.id.editText_course5);
        GPA = (TextView) findViewById(R.id.textView_GPA);
        // gpa button would only work if final was invokes so that it could not be changed
        final Button gpacompute = (Button) findViewById(R.id.gpacompute_button);



        //declare on click listener for gpa button
        gpacompute.setOnClickListener(new View.OnClickListener() {
            @Override
            //
            public void onClick(View view) {

                // create string values for text input
                String CourseOne = courseno1.getText().toString();
                String CourseTwo = courseno2.getText().toString();
                String CourseThree = courseno3.getText().toString();
                String CourseFour = courseno4.getText().toString();
                String CourseFive = courseno5.getText().toString();

                //initialize variables as double from edit text inputs for GPA total
                double c1 = Double.parseDouble(courseno1.getText().toString());
                double c2 = Double.parseDouble(courseno2.getText().toString());
                double c3 = Double.parseDouble(courseno1.getText().toString());
                double c4 = Double.parseDouble(courseno1.getText().toString());
                double c5 = Double.parseDouble(courseno1.getText().toString());
                //create variable for sum of all grades
                double sum = c1 + c2 + c3 + c4 + c5;
                //create variable for GPA average
                final double GPAtotal = sum / 5;

                //create toasts messages for if any courses are left empty
                if (CourseOne.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Grade for Course 1", Toast.LENGTH_LONG).show();
                } else if (CourseTwo.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Grade for Course 2", Toast.LENGTH_LONG).show();
                } else if (CourseThree.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Grade for Course 3", Toast.LENGTH_LONG).show();
                } else if (CourseFour.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Grade for Course 4", Toast.LENGTH_LONG).show();
                } else if (CourseFive.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Grade for Course 5", Toast.LENGTH_LONG).show();
                }

                //if all courses are filled out then display GPA total and changes background color based off GPA
                //Change background to red if less than 60
                else if (GPAtotal < 60) {
                    background.setBackgroundColor(Color.RED);
                    GPA.setText(Double.toString(GPAtotal));
                }
                // Change background to yellow 79
                else if (GPAtotal > 61 & GPAtotal < 79) {
                    background.setBackgroundColor(Color.YELLOW);
                    GPA.setText(Double.toString(GPAtotal));
                }
                // Change background to green if >80
                else if (GPAtotal > 80) {
                    background.setBackgroundColor(Color.GREEN);
                    GPA.setText(Double.toString(GPAtotal));

                }
                //if all courses are filled out, on GPA compute reset text fields to empty
                if (courseno1.length() != 0 && courseno2.length() != 0 && courseno3.length() != 0 &&
                        courseno4.length() != 0 && courseno5.length() != 0) {

                    //if successful also set text color of button to be invisible to user
                    gpacompute.setTextColor(getResources().getColor(R.color.Grey));
                    courseno1.setText("");
                    courseno2.setText("");
                    courseno3.setText("");
                    courseno4.setText("");
                    courseno5.setText("");
                }

            }

        });





      }
    }
