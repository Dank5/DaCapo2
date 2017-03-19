package uk.ac.ncl.dacapo.dacapo2;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.List;

import uk.ac.ncl.dacapo.dacapo2.R;

/**
 * Created by Lewis on 04/03/2017.
 *
 * MenuAdapter class extends the BaseExpandableListAdapter and uses override methods to provide
 * interface between the App UI (XML DOCUMENTATION) and the custom data
 * for example:
 * getGroupView will return the view of the xml files for the Menu
 *              (main_parent_options.xml), (main_child_options.xml)
 *
 * this means that the adapters can be used to find objects and use the objects methods to take data
 * and add UI content
 */

public class MenuAdapter extends BaseExpandableListAdapter {

    private Context ctx;
    private LinkedHashMap<String, List<String>> mainMenu;
    private List<String> subMenu;

    @Override
    public boolean areAllItemsEnabled() {
        return super.areAllItemsEnabled();
    }

    public MenuAdapter(Context ctx, LinkedHashMap<String, List<String>> mainMenu, List<String> subMenu) {

        this.ctx = ctx;
        this.mainMenu = mainMenu;
        this.subMenu = subMenu;

    }


    @Override
    public int getGroupCount() {
        //get the amount of categories
        return subMenu.size();
    }

    @Override
    public int getChildrenCount(int parentPosition) {
        //get the amount of exercises in a specific category
        return mainMenu.get(subMenu.get(parentPosition)).size();
    }

    @Override
    public Object getGroup(int parentPosition) {
        //return current title
        return subMenu.get(parentPosition);
    }

    @Override
    public Object getChild(int parentPosition, int childPosition) {
        return mainMenu.get(subMenu.get(parentPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int parentPosition) {
        return 0;
    }


    @Override
    public long getChildId(int parentPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parentPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String groupTitle = (String) getGroup(parentPosition);

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.main_parent_options, parent, false);
        }

        TextView parentTextView = (TextView) convertView.findViewById(R.id.main_parent_text);
        parentTextView.setTypeface(null, Typeface.BOLD);
        parentTextView.setText(groupTitle);

        return convertView;
    }

    @Override
    public View getChildView(int parentPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String childTitle = (String) getChild(parentPosition, childPosition);

        //if there is no convertView, create a new one
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.main_child_options, parent, false);
        }

        //set the text of the childText (individual exercises)
        TextView childEditText= (TextView) convertView.findViewById(R.id.main_child_text);
        childEditText.setText(childTitle);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int parentPosition, int childPosition) {
        return true;
    }
}

