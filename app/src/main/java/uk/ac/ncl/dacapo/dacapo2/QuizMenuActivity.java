package uk.ac.ncl.dacapo.dacapo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class QuizMenuActivity extends AppCompatActivity {

    public static final String GRADE_ONE = "Grade 1";
    public static final String GRADE_TWO = "Grade 2";

    List<Quiz> quizList;
    ListView quizListView;
    QuizAdapter adapter;


    public static final String QUIZ_NAME = "uk.ac.ncl.dacapo2.dacapo2.QUIZMESSAGE";
    public static final String QUIZ_TEXT = "uk.ac.ncl.dacapo2.dacapo2.QUIZID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.quiz_grade);

        textView.setText(message);

        quizListView = (ListView) findViewById(R.id.quiz_activity_list);
        quizList = DataProvider.getQuizInfo();
        adapter = new QuizAdapter(this, quizListView.getId(), quizList);

        quizListView.setAdapter(adapter);

        quizListView.setOnItemClickListener(
                new ListView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                        Intent quizIntent = new Intent(getApplicationContext(), QuizActivity.class);
                        Bundle b = new Bundle();
                        b.putInt("level", position);
                        b.putInt("grade", 0);
                        quizIntent.putExtras(b);
                        //Quiz quiz = quizList.get(position);
                        //String name = (String) quiz.getText();
                        //String question = "This is a question!";
                        //quizIntent.putExtra(QUIZ_NAME, name);
                        //quizIntent.putExtra(QUIZ_TEXT, question);
                        startActivity(quizIntent);
                    }
                });
    }
}