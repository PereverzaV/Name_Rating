package com.shpp.p2p.cs.vpereverza.assignment7;

import com.shpp.cs.a.simple.SimpleProgram;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a program that accepts a name entered by the user and plots the popularity of that name over time.
 * When you click on certain interactors,
 * the program compares the entered name with the database (the program is not case sensitive).
 * If the name is found, it displays the data from the database in the form of a graph
 * (where 1 is the most popular name, 999 is the opposite, * was not in the rating)
 * When you press the clear button,
 * all data about the wound entered names are cleared from the memory of the program and schedule.
 */
public class NameSurfer extends SimpleProgram implements NameSurferConstants {

    /**
     * Interactors
     */
    private JTextField name;
    private JButton buttonGraph, buttonClear;

    private NameSurferGraph graph  = new NameSurferGraph();

    /**
     * This method has the responsibility for reading in the data base
     * and initializing the interactors at the top of the window.
     */
    public void init() {
        add(new Label("Name"), NORTH);
        name = new JTextField(NAME_SIZE);
        add(name, NORTH);

        buttonGraph = new JButton("Graph");
        add(buttonGraph, NORTH);

        buttonClear = new JButton("Clear");
        add(buttonClear, NORTH);

        name.setActionCommand("EnterPressed");
        name.addActionListener(this);
        addActionListeners();

        add(graph);

    }

    /**
     *Create a method that tracks user interaction with interactors.
     * Each interactor, when interacting, passes information to another class
     * and calls the canvas change method.
     */
    public void actionPerformed(ActionEvent e) {
        //If, after entering the name, the user presses the button "buttonGraph" or "name"
        //then the entered name is passed to the method of another class to search for the name in the buzz,
        //process the information and display the chart on the screen.
        if(e.getSource()==name || e.getSource()==buttonGraph) {
            NameSurferDataBase data = new NameSurferDataBase(NAMES_DATA_FILE);
            graph.addEntry(data.findEntry(name.getText()));
            graph.drawNameGraph();
        }

        //If the button is pressed "buttonClear"
        //then we delete from memory all the data about the previously entered names
        // and draw an empty graph.
        else{
            graph.clear();
            graph.update();
        }
    }
}
