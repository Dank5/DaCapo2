package uk.ac.ncl.dacapo.dacapo2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eimear on 24/02/2017.
 */

public class Questions {
    //create lists for the different levels
    private List<Question> grade1level1 = new ArrayList<>();
    private List<Question> grade1level2 = new ArrayList<>();
    private List<Question> grade1level3 = new ArrayList<>();
    public Questions() {
        //level 1 questions
        grade1level1.add(new Question(0, "How many lines are there on a stave?", R.drawable.stave, "3", "5", "5",
                                "Yes, there are 5 lines on the stave.", "There are 5 lines on the stave"));
        grade1level1.add(new Question(1, "What note does a treble clef start on?", "A", "G", "G",
                                "The treble clef starts on a G", "The treble clef starts on a G"));
        grade1level1.add(new Question(2, "What note does a bass clef start on?", "A", "F", "G", "B", "F",
                                "Correct! The bass clef starts on an F", "The bass clef starts on an F"));
        grade1level1.add(new Question(3, "What do dynamics tell you?", "How loud or soft to play", "What to play", "How loud or soft to play",
                                "Yes, dynamics tell you how loud or soft to play", "The dynamics don't tell you what or what not to play, " +
                                "they tell you how loud or soft to play"));
        grade1level1.add(new Question(4, "What musical term means go back to the start?", "Da capo", "Crotchet", "Repeat", "F#", "Da capo",
                                "Da capo is italian for \"from the beginning\"", "Da capo means go back to the start"));
        grade1level1.add(new Question(5, "What is the key signature for the key of F?", "Bb, Eb", "Bb", "Bb, Eb, Ab", "F#, C#", "Bb",
                                "Yes", "Only Bb is present in the key of F"));

        //level 2 questions
        grade1level2.add(new Question(0, "How many beats does a minum last?", "1", "2", "4", "2",
                                "Yes, a minum lasts 2 beats", "A minum lasts 2 beats"));
        grade1level2.add(new Question(1, "How many beats does a crochet last?", "1", "2", "4", "1",
                                "Yes, a crotchet lasts 1 beat", "A crotchet lasts 1 beat"));
        grade1level2.add(new Question(2, "How many beats does a semibreve last?", "1", "2", "4", "4",
                                "Yes, a semibreve lasts 4 beats", "A semibreve lasts 4 beats"));
        grade1level2.add(new Question(3, "The sharps or flats at the beginning of a line of music is called what?", "Key time", "Key signature", "Key measure",
                                "Key signature", "Correct", "The sharps and flats are called the key signature"));

        //level 3 questions
        grade1level3.add(new Question(0, "Question (A)", "A", "B", "A",
                                "Correct feeedback", "Incorrect feedback"));
        grade1level3.add(new Question(1, "Question (B)", "A", "B", "B",
                                "Correct feedback", "Incorrect feedback"));
        grade1level3.add(new Question(2, "Question (C)", "A", "B", "C", "C",
                                "Correct feedback", "Incorrect feedback"));
        grade1level3.add(new Question(3, "Question (D)", "D", "E", "F", "D",
                                "Correct feedback", "Incorrect feedback"));
        grade1level3.add(new Question(4, "Question (E)", "D", "E", "F", "E",
                                "Correct feedback", "Incorrect feedback"));
        grade1level3.add(new Question(5, "Question (F)", "D", "E", "F", "F",
                                "Correct feedback", "Incorrect feedback"));

    }
    public List<Question> getQuestions(int grade, int level) {
        if(grade == 1) {
            if (level == 1) {
                return new ArrayList<>(grade1level1);
            }
            if (level == 2) {
                return new ArrayList<>(grade1level2);
            }
            if (level == 3) {
                return new ArrayList<>(grade1level3);
            }
        }
        return null;
    }
}
