package uk.ac.ncl.dacapo.dacapo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class QuizEndActivity extends AppCompatActivity {

    TextView t;
    Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_end);


        t = (TextView) findViewById(R.id.textResult);
        b = getIntent().getExtras();
        int score = b.getInt("score");
        if (score == 1) {
            t.setText("You scored " + score + " point!");
        }
        else {
            t.setText("You scored " + score + " points!");
        }
    }

    public void goToMainMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
