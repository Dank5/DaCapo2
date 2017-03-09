package uk.ac.ncl.dacapo.dacapo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

/*
*   LessonMenuActivity
*
*   Once a user has selected a grade from the main menu they a brought to a list of all the lessons
*   in that grade.
*
*   xml files used:
*
*   activity_lesson_menu.xml
*   lesson_grade.xml
*   lesson_activity_list.xml
*
 */

public class LessonMenuActivity extends AppCompatActivity {

    List<Lesson> lessons;
    ListView lessonList;
    LessonAdapter adapter;

    public static final String GRADE_ONE = "Grade 1";
    public static final String GRADE_TWO = "Grade 2";
    public static final String LESSON_NAME = "uk.ac.ncl.dacapo2.dacapo2.LESSONNAME";
    // public static final String QUIZ_TEXT = "uk.ac.ncl.dacapo2.dacapo2.QUIZID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_menu);

        //get intent from MainActivity
        Intent intent = getIntent();
        //get info from intent
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //instaniate TextView object for the grade name
        TextView gradeName = (TextView) findViewById(R.id.lesson_grade);
        gradeName.setText(message);

        //instaniate List of lesson objects for the grade name
        lessonList = (ListView) findViewById(R.id.lesson_menu_list);
        //get the lesson information and pass to the list of lessons
        lessons = DataProvider.getLessonInfo();
        //new lesson(extends listadapter) adapter
        adapter = new LessonAdapter(this,lessonList.getId() , lessons);
        //set the list of lessons to use this adapter
        lessonList.setAdapter(adapter);

        lessonList.setOnItemClickListener(
                new ListView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                        //create a new intent to start a LessonActivity
                        Intent lessonIntent = new Intent(getApplicationContext(), LessonActivity.class);
                        //create the lesson object for the item pressed by the user
                        Lesson Lesson = lessons.get(position);
                        String name = (String) Lesson.getText();
                        lessonIntent.putExtra(LESSON_NAME, name);
                        startActivity(lessonIntent);
                    }
                });


    }
}
