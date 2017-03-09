package uk.ac.ncl.dacapo.dacapo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    ListView quizQuestions;
    TextView questionText;
    List<Quiz> quizList;
    QuizAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


            // Get the Intent that started this activity and extract the string
            Intent intent = getIntent();
            String name = intent.getStringExtra(QuizMenuActivity.QUIZ_NAME);
            String question = intent.getStringExtra(QuizMenuActivity.QUIZ_TEXT);

            // Capture the layout's TextView and set the string as its text
            TextView textView = (TextView) findViewById(R.id.quiz_text);
            textView.setText(name);
            //ListView quizQuestions = (ListView) findViewById(R.id.quiz_activity_list);
            questionText = (TextView) findViewById(R.id.quiz_question_text);
            questionText.setText(question);


    }
}
