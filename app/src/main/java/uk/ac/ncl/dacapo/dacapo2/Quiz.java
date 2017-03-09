package uk.ac.ncl.dacapo.dacapo2;

import android.content.ClipData;

/**
 * Created by Lewis on 05/03/2017.
 */

public class Quiz extends ClipData.Item {

    private String quizNo;
    private String quizQuestion;

    public Quiz(CharSequence text) {
        super(text);
        this.quizNo = quizNo;
    }
}
