package uk.ac.ncl.dacapo.dacapo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class LessonActivity extends AppCompatActivity {

    ListView lessonView;
    TextView lessonName;
    List<Lesson> lessonList;
    Lesson adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String name = intent.getStringExtra(LessonMenuActivity.LESSON_NAME);

        lessonName = (TextView) findViewById(R.id.lesson_text);
        lessonName.setText(name);
        //ListView quizQuestions = (ListView) findViewById(R.id.quiz_activity_list);
      //  lessonName = (TextView) findViewById(R.id.quiz_question_text);
       // lessonName.setText(question);



    }
}

