package com.shpp.p2p.cs.vpereverza.assignment7;

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
        implements NameSurferConstants, ComponentListener {

    /**
     * An array that stores all the data for the names entered earlier by the user
     */
    public ArrayList <String []> namesOnTheScreen = new ArrayList<>();


    /**
     * Creates a new NameSurferGraph object that displays the data.
     */
    public NameSurferGraph() {
        addComponentListener(this);
    }


    /**
     * Clears the list of name surfer entries stored inside this class.
     */
    public void clear() {
        namesOnTheScreen.clear();
    }

    /**
     * Adds a new NameSurferEntry to the list of entries on the display.
     */
    public void addEntry(NameSurferEntry entry) {
       String [] nameData = new String[13];
        nameData[0]= (entry.getName());
        for (int i=1; i<13; i++){
            nameData[i] = (String.valueOf(entry.getRank(i)));
        }
        namesOnTheScreen.add(nameData);
    }


    /**
     * Updates the display image by deleting all the graphical objects from the canvas
     * and then reassembling the display according to the list of entries.
     * Сall update after calling either clear or addEntry;
     * update is also called wheneverthe size of the canvas changes.
     */
    public void update() {
        removeAll();
        drawAGrid();
        drawNameGraph();
    }

    /**
     *The method draws the initial day of decades
     * at the bottom showing decades
     */
    public void drawAGrid() {
        int x=INDENT;
        int year = START_DECADE;
        for (int i = 0; i< NDECADES; i++) {
            //Draw vertical lines of decades
            GLine dividingLineOfDecades = new GLine(x, 0, x, getHeight());
            add(dividingLineOfDecades);

            //Write the current decade
            GLabel decade= new GLabel(String.valueOf(year), x, getHeight());
            decade.setFont("Cascadia Code-20");
            add(decade);

            //In each step of the loop, we change the decade
            // and the X coordinates for drawing the vertical line.
            year += DECADE;
            x+=getWidth()/NDECADES;
        }

        //Draw vertical and horizontal border
        GLine upperBount = new GLine(0,GRAPH_MARGIN_SIZE,getWidth(),GRAPH_MARGIN_SIZE);
        add(upperBount);
        GLine bottonBount = new GLine(0,getHeight()-GRAPH_MARGIN_SIZE,getWidth(),getHeight()-GRAPH_MARGIN_SIZE);
        add(bottonBount);
    }

    /**
     *The method displays a graph of the popularity of user-entered names on a canvas
     */
    public void drawNameGraph() {
        //Finding the chart step
        //Subtracts the top and bottom borders from the entire length of the screen to find the height of the chart.
        //To find the step, we divide the height of the chart by the maximum possible rating value
        double startY=(getHeight()-(2.0*GRAPH_MARGIN_SIZE))/MAX_RANK;

        //Looping through all user-entered name data
        for (int j = 0; j < namesOnTheScreen.size(); j++) {
            int x = INDENT;

            //Looping through all name data
            for (int i = 1; i < namesOnTheScreen.get(j).length; i++) {

                //Display the name and value of the decade on the screen
                //in coordinates corresponding to the rank.
                double y = startY * checkForRating(j,i);
                GLabel nameYear = new GLabel(namesOnTheScreen.get(j)[0] + " " + getRank(checkForRating(j,i)));
                nameYear.setFont("Cascadia Code-10");
                nameYear.setColor(findColor(j));
                add(nameYear, x, GRAPH_MARGIN_SIZE+y);

                //If there is a next element,
                // then draws a line from the current name rank value in a decade to the next.
                int nextElement= i+1;
                if(nextElement < namesOnTheScreen.get(j).length ) {
                    double dy = startY * checkForRating(j,nextElement);
                    GLine namePopular = new GLine(x, GRAPH_MARGIN_SIZE+y,
                            x + getWidth() / NDECADES,
                            GRAPH_MARGIN_SIZE+dy);
                    namePopular.setColor(findColor(j));
                    add(namePopular);
                }

                //Change position X.
                x += getWidth() / NDECADES;
            }
        }
    }

    /**
     *Determine your current rank.
     * If the value is zero, then assign the maximum value.
     *
     * @param j Current line of name data
     * @param i Decade Data
     * @return Rating value
     */
    private int checkForRating(int j, int i) {
        if((Integer.parseInt(namesOnTheScreen.get(j)[i]))==0){
            return MAX_RANK;
        }
        else
            return Integer.parseInt(namesOnTheScreen.get(j)[i]);
    }

    /**
     *Determine the rank for the subsequent correct display of data on the chart.
     * If the rank has a maximum value, then return "*", which indicates that the name is not in the ranking.
     *
     * @param number name rank per decade
     * @return value displayed on the graph
     */
    private String getRank(int number) {
        if(number==MAX_RANK){
            return "*";
        }
        else
            return String.valueOf(number);
    }

    /**
     *Create a method that loops will color graphics of names in colors
     * @param j name index in the database of user-entered names
     * @return name chart staining color
     */
    private Color findColor(int j) {
        if (j<1) {
            return FIRST_COLOR;
        }
        if (j<2) {
            return SECOND_COLOR;
        }
        if (j<3) {
            return THIRD_COLOR;
        }
        if (j<4) {
            return FOURTH_COLOR;
        }
        return findColor(j - 4);
    }

    /* Implementation of the ComponentListener interface */
    public void componentHidden(ComponentEvent e) {

    }

    public void componentMoved(ComponentEvent e) {

    }

    public void componentResized(ComponentEvent e) {
        update();
    }

    public void componentShown(ComponentEvent e) {
    }
}
