package uk.ac.ncl.dacapo.dacapo2;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lewis on 05/03/2017.
 *
 * LessonAdapter
 *
 *  LessonAdapter class extends the ArrayAdapter<Lesson> and uses override methods to provide
 * interface between the App UI (XML DOCUMENTATION) and the custom data for a Lesson
 * for example:
 *
 * getView will return the view of the xml files for the LessonMenu
 * and sets the text of the initial text area in the LessonActivity
 *
 *       (main_parent_options.xml), (main_child_options.xml)
 *
 * this means that the adapters can be used to find objects and use the objects methods to take data
 * and add UI content
 *
 */



public class LessonAdapter extends ArrayAdapter<Lesson> {

    private final List<Lesson> items;

    public LessonAdapter(Context context, int textViewResourceId, List<Lesson>  items) {
        super(context, textViewResourceId, items);
        this.items = items;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String lessonTitle = getItem(position).toString();


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lesson_list, parent, false);
        }

        TextView lessonTextView = (TextView) convertView.findViewById(R.id.lesson_text);
        lessonTextView.setTypeface(null, Typeface.BOLD);
        lessonTextView.setText(lessonTitle);

        return convertView;

    }

    @Nullable
    @Override
    public Lesson getItem(int position) {
        return items.get(position);
    }


}
