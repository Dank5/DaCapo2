package uk.ac.ncl.dacapo.dacapo2.menuPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import uk.ac.ncl.dacapo.dacapo2.DataProvider;
import uk.ac.ncl.dacapo.dacapo2.R;
import uk.ac.ncl.dacapo.dacapo2.lessonPackage.LessonMenuActivity;
import uk.ac.ncl.dacapo.dacapo2.quizPackage.QuizMenuActivity;

// MAIN ACTIVITY
// xml: activity_main
// Contains: ExpandableListView (id: main_menu))

public class MainActivity extends AppCompatActivity {

    //string used with intent to pass to new intent
    public static final String EXTRA_MESSAGE = "uk.ac.ncl.dacapo2.dacapo2.MESSAGE";

    //These are all used by MenuAdapter which is a custom BaseExpandableListAdapter that takes data from DataProvider class
    //HashMap of Menu options(parent) each with a lit of sub options(child)
    LinkedHashMap<String, List<String>> mainMenu;
    //List of menus
    List<String> subMenu;
    ExpandableListView expandList;
    MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate variables for adapter
        expandList = (ExpandableListView) findViewById(R.id.main_menu);
        mainMenu = DataProvider.getInfo();
        subMenu = new ArrayList<>(mainMenu.keySet());
        adapter = new MenuAdapter(this, mainMenu, subMenu);
        expandList.setAdapter(adapter);

        //taken from stackoverflow
        //Listener for when the menu expands, collapses previous parent if a new one is expanded
        expandList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            // Keep track of previous expanded parent
            int previousGroup = -1;
            //required override methods, use alt-insert to import quickly
            @Override
            public void onGroupExpand(int groupPosition) {
                // Collapse previous parent if expanded.
                if ((previousGroup != -1) && (groupPosition != previousGroup)) {
                    expandList.collapseGroup(previousGroup);
                }
                previousGroup = groupPosition;
            }
        });

        //child click listener
        expandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                    TextView textView;
                String message;
                Intent intent;
                //if user presses lesson
                if(groupPosition == 0) {
                    //As there is no extra info passed to either grade 1 or two yet there is no need
                    //to use child position yet, this may need more implementation
                    //
                    // if(childPosition == 0){
                    // code here
                    // }
                    //
                            intent = new Intent(getBaseContext(), LessonMenuActivity.class);
                            textView = (TextView) v.findViewById(R.id.main_child_text);
                            message = (String) textView.getText();
                            intent.putExtra(EXTRA_MESSAGE, message);
                            startActivity(intent);
                }
                //if user presses quiz
                if(groupPosition == 1) {

                            intent = new Intent(getBaseContext(), QuizMenuActivity.class);
                            textView = (TextView) v.findViewById(R.id.main_child_text);
                            message = (String) textView.getText();
                            intent.putExtra(EXTRA_MESSAGE, message);
                            startActivity(intent);
                }

                //if user presses progress (NOT IMPLEMENTED)
                if(groupPosition == 2) {

                    intent = new Intent(getBaseContext(), QuizMenuActivity.class);
                    textView = (TextView) v.findViewById(R.id.main_child_text);
                    message = (String) textView.getText();
                    intent.putExtra(EXTRA_MESSAGE, message);
                    startActivity(intent);
                }

                //if user presses settings (NOT IMPLEMENTED)
                if(groupPosition == 3) {

                    intent = new Intent(getBaseContext(), QuizMenuActivity.class);
                    textView = (TextView) v.findViewById(R.id.main_child_text);
                    message = (String) textView.getText();
                    intent.putExtra(EXTRA_MESSAGE, message);
                    startActivity(intent);
                }



                return true;
            }
        });
    }
}
