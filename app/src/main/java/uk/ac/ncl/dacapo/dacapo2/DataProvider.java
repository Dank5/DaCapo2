package uk.ac.ncl.dacapo.dacapo2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lewis on 04/03/2017.
 *
 * Just a very quick Class which creates some data to be populated, this would be very easy to change
 * to take from JSONObjects, string.xml resource or just as Strings in java class
 */

public class DataProvider {


    //method that will provide data to the menu Hashmap
    public static LinkedHashMap<String, List<String>> getInfo() {

        LinkedHashMap<String, List<String>> mainMenu = new LinkedHashMap<String, List<String>>();

        List<String> lessonOption = new ArrayList<>();
        lessonOption.add("Grade 1");
        lessonOption.add("Grade 2");

        List<String> quizOption = new ArrayList<>();
        quizOption.add("Grade 1");
        quizOption.add("Grade 2");


        List<String> progressOption = new ArrayList<>();
        progressOption.add("View Progress");
        progressOption.add("Leaderboard");

        List<String> settingsOption = new ArrayList<>();
        settingsOption.add("Colour-blind mode");
        settingsOption.add("sound");


        mainMenu.put("Lessons", lessonOption);
        mainMenu.put("Test yourself", quizOption);
        mainMenu.put("Progress", progressOption);
        mainMenu.put("Settings", settingsOption);


        return mainMenu;
    }

    //method that will provide data to the lesson list
    public static LinkedList<Lesson> getLessonInfo() {

        LinkedList<Lesson> lessons = new LinkedList<>();
        Lesson lesson1 = new Lesson("Lesson 1");
        Lesson lesson2 = new Lesson("Lesson 2");
        Lesson lesson3 = new Lesson("Lesson 3");
        Lesson lesson4 = new Lesson("Lesson 4");

        lessons.add(lesson1);
        lessons.add(lesson2);
        lessons.add(lesson3);
        lessons.add(lesson4);

        return lessons;
    }

    //method that will provide data to the quiz list
    public static LinkedList<Quiz> getQuizInfo() {
        LinkedList<Quiz> quizs = new LinkedList<>();
        Quiz quiz1 = new Quiz("Quiz 1");
        Quiz quiz2 = new Quiz("Quiz 2");
    Quiz quiz3 = new Quiz("Quiz 3");
    Quiz quiz4 = new Quiz("Quiz 4");

        quizs.add(quiz1);
        quizs.add(quiz2);
        quizs.add(quiz3);
        quizs.add(quiz4);

        return quizs;
}



    }
