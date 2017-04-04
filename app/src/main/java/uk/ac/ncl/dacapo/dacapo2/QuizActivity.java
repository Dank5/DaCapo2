package uk.ac.ncl.dacapo.dacapo2;


import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
public class QuizActivity extends AppCompatActivity {
    //variables for the level, list of questions for that level, total number of questions, and current question
    int grade, level;
    Questions questions;
    List<Question> questionList, incorrectQuestionList;
    int totalQuestions;
    Question currentQuestion;

    //variables for the score and the current question id
    int score=0;
    int qid;
    int numberOfOptions;
    double doubleqid;
    int progress;

    //variables for the actual content on the activity
    TextView questionText;
    Button A, B, C, D;
    ProgressBar prg;
    ImageView imageView;

    //variable for the bundle (for importing the level)
    Bundle b;

    //variables for the alert dialogs
    AlertDialog.Builder correct, incorrect;
    AlertDialog correctAlert, incorrectAlert;


    //on create method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set layout to 4 question view
        setContentView(R.layout.activity_quiz);

        //build the 2 alert dialogs - one for correct and one for incorrect
        correct = new AlertDialog.Builder(this);
        incorrect = new AlertDialog.Builder(this);
        correct.setTitle("Correct!");
        correct.setPositiveButton("Next Question", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                nextQuestion();
            }
        });
        incorrect.setTitle("Incorrect.");
        incorrect.setPositiveButton("Next Question", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                nextQuestion();
            }
        });

        //assign all the Buttons, TextView etc to variables
        questionText = (TextView) findViewById(R.id.textView1);
        A = (Button) findViewById(R.id.button);
        B = (Button) findViewById(R.id.button2);
        C = (Button) findViewById(R.id.button3);
        D = (Button) findViewById(R.id.button4);
        imageView = (ImageView) findViewById(R.id.imageView2);
        prg = (ProgressBar) findViewById(R.id.progressBar);

        //create the questions
        questions = new Questions();

        //get the level from which button was pressed
        b = getIntent().getExtras();
        level = b.getInt("level") + 1;
        grade = b.getInt("grade") + 1;

        //get the question list for the level
        questionList = questions.getQuestions(grade, level);
        incorrectQuestionList = new ArrayList<>();
        doubleqid = questionList.size()*Math.random();
        qid = (int) doubleqid;
        progress = 0;

        //checks that the question list isn't null (it shouldn't ever be)
        if(questionList != null) {
            //set the total number of questions and the current question
            totalQuestions = questionList.size();
            currentQuestion = questionList.get(qid);
            //set question view
            setQuestionView();
        }
        else {
            //if questionList is null (which it shouldn't be), return to main menu
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    //set question view method
    private void setQuestionView() {
        //set each item on the activity to the current question data
        numberOfOptions = currentQuestion.getNumberOfOptions();
        if(numberOfOptions == 4) {
            questionText.setText(currentQuestion.getQuestion());
            if(questionList.get(qid).getImageSource() != 0) {
                imageView.setImageResource(questionList.get(qid).getImageSource());
            }
            A.setText(currentQuestion.getA());
            B.setText(currentQuestion.getB());
            C.setText(currentQuestion.getC());
            D.setText(currentQuestion.getD());
            A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswerA(v);
                }
            });
            B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswerB(v);
                }
            });
            C.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswerC(v);
                }
            });
            D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswerD(v);
                }
            });
            C.setVisibility(View.VISIBLE);
            D.setVisibility(View.VISIBLE);
        }
        else if(numberOfOptions == 2) {
            questionText.setText(currentQuestion.getQuestion());
            if(questionList.get(qid).getImageSource() != 0) {
                imageView.setImageResource(questionList.get(qid).getImageSource());
            }
            A.setText(currentQuestion.getA());
            B.setText(currentQuestion.getB());
            A.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswerA(v);
                }
            });
            B.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswerB(v);
                }
            });
            C.setVisibility(View.INVISIBLE);
            D.setVisibility(View.INVISIBLE);
        }
        else {
            Intent intent = new Intent(this, QuizMenuActivity.class);
            startActivity(intent);
        }
        //set progress bar to the progress
        prg.setProgress(progress);
    }

    //check if answer A is correct
    public void checkAnswerA(View view){
        if(currentQuestion.getAnswer().equals(A.getText())) {
            correctAnswer();
        }
        else {
            incorrectAnswer();
        }
        setQuestionsUnanswerable();
    }
    //check if answer B is correct
    public void checkAnswerB(View view){
        if(currentQuestion.getAnswer().equals(B.getText())) {
            correctAnswer();
        }
        else {
            incorrectAnswer();
        }
        setQuestionsUnanswerable();
    }
    //check if answer C is correct
    public void checkAnswerC(View view){
        if(currentQuestion.getAnswer().equals(C.getText())) {
            correctAnswer();
        }
        else {
            incorrectAnswer();
        }
        setQuestionsUnanswerable();
    }
    //check if answer D is correct
    public void checkAnswerD(View view){
        if(currentQuestion.getAnswer().equals(D.getText())) {
            correctAnswer();
        }
        else {
            incorrectAnswer();
        }
        setQuestionsUnanswerable();
    }

    private void correctAnswer() {
        score++;
        progress += 10;
        if(incorrectQuestionList.contains(currentQuestion)) {
            incorrectQuestionList.remove(currentQuestion);
        }
        correct.setMessage(currentQuestion.getFeedbackPositive());
        correctAlert = correct.create();
        correctAlert.show();
    }

    private void incorrectAnswer() {
        progress -= 5;
        if(progress < 0) {
            progress = 0;
        }
        if(!incorrectQuestionList.contains(currentQuestion)) {
            incorrectQuestionList.add(currentQuestion);
        }
        incorrect.setMessage(currentQuestion.getFeedbackNegative());
        incorrectAlert = incorrect.create();
        incorrectAlert.show();
    }

    private void setQuestionsUnanswerable() {
        View.OnClickListener nextQuestion = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        };
        A.setOnClickListener(nextQuestion);
        B.setOnClickListener(nextQuestion);
        C.setOnClickListener(nextQuestion);
    }

    public void nextQuestion(){
        //check whether progress is less than 100
        if(progress < 100) {
            //remove current question from the question list
            questionList.remove(qid);
            //check to see if the question list is empty
            if(questionList.isEmpty()) {
                //if it is, add all the level's questions again
                if (!incorrectQuestionList.isEmpty()) {
                    questionList.addAll(incorrectQuestionList);
                }
                else {
                    questionList.addAll(questions.getQuestions(grade, level));
                }
            }

            //set qid to random number between 0 and questionList size
            doubleqid = questionList.size()*Math.random();
            qid = (int) doubleqid;
            while(questionList.get(qid).getCorrect()) {
                questionList.remove(qid);
                doubleqid = questionList.size()*Math.random();
                qid = (int) doubleqid;
            }
            //set current question
            currentQuestion = questionList.get(qid);
            while(currentQuestion.getCorrect()) {

            }
            //set question view
            setQuestionView();
        }
        //if progress is greater than 100
        else {
            //create an intent for the QuizEndActivity
            Intent intent = new Intent(this, QuizEndActivity.class);
            //create a bundle to store the score
            Bundle b = new Bundle();
            b.putInt("score", score);
            //add the bundle to the intent
            intent.putExtras(b);
            //start the next activity
            startActivity(intent);
        }
    }
}
