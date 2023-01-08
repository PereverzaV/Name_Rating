package com.shpp.p2p.cs.vpereverza.assignment7;

/**
 * This file declares several constants that are shared by the
 * different modules in the NameSurfer application.  Any class
 * that implements this interface can use these constants.
 */

import java.awt.*;

public interface NameSurferConstants {

    /**
     * The width of the application window
     */
    public static final int APPLICATION_WIDTH = 800;

    /**
     * The height of the application window
     */
    public static final int APPLICATION_HEIGHT = 600;

    /**
     * The name of the file containing the data
     */
    public static final String NAMES_DATA_FILE = "name/names-data.txt";

    /**
     * The first decade in the database
     */
    public static final int START_DECADE = 1900;

    /**
     * Time interval
     */
    public static final int DECADE = 10;
    /**
     * The number of decades
     */
    public static final int NDECADES = 12;

    /**
     * The maximum rank in the database
     */
    public static final int MAX_RANK = 1000;

    /**
     * The number of pixels to reserve at the top and bottom
     */
    public static final int GRAPH_MARGIN_SIZE = 20;

    /**
     * Number of pixels to reserve on the left
     */
    public static final int INDENT = 2;

    /**
     *Colors for Displaying Name Graphs
     */
    public static final Color FIRST_COLOR = Color.BLUE;
    public static final Color SECOND_COLOR = Color.RED;
    public static final Color THIRD_COLOR = Color.MAGENTA;
    public static final Color FOURTH_COLOR = Color.BLACK;

    /**
     *The maximum length of the entered name
     */
    public static final int NAME_SIZE = 20;


}
