package uk.ac.ncl.dacapo.dacapo2;

import android.content.ClipData;

/**
 * Created by Lewis on 05/03/2017.
 */

public class Lesson extends ClipData.Item {

    String name;
    String grade;
    String[] lessonParagraphs;
    Integer[] res;


    public Lesson(CharSequence text) {
        super(text);
    }
}
