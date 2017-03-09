package uk.ac.ncl.dacapo.dacapo2;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lewis on 05/03/2017.
 */

public class QuizAdapter extends ArrayAdapter<Quiz> {

    private final List<Quiz> items;

    public QuizAdapter(Context context, int textViewResourceId, List<Quiz>  items) {
        super(context, textViewResourceId, items);
        this.items = items;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String quizTitle = getItem(position).toString();


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.quiz_list, parent, false);
        }

        TextView quizTextView = (TextView) convertView.findViewById(R.id.quiz_list_text);
        quizTextView.setTypeface(null, Typeface.BOLD);
        quizTextView.setText(quizTitle);

        return convertView;

    }

    @Nullable
    @Override
    public Quiz getItem(int position) {
        return items.get(position);
    }


}

