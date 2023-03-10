package com.shpp.p2p.cs.vpereverza.assignment7;

/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

public class NameSurferEntry implements NameSurferConstants {

    /**
     *An array of strings that stores a string from the base, divided into strings.
     */
    String [] nameData;

    /**
     * Creates a new NameSurferEntry from a data line as it appears
     * in the data file.  Each line begins with the name, which is
     * followed by integers giving the rank of that name for each
     * decade.
     */
    public NameSurferEntry(String line) {
        nameData = line.split(" ");
    }

    /**
     * Returns the name associated with this entry.
     */
    public String getName() {
        return nameData[0];
    }

    /**
     * Returns the rank associated with an entry for a particular
     * decade.  The decade value is an integer indicating how many
     * decades have passed since the first year in the database,
     * which is given by the constant START_DECADE.  If a name does
     * not appear in a decade, the rank value is 0.
     */
    public int getRank(int decade) {
        return Integer.parseInt(nameData[decade]);
    }


    /**
     * Returns a string that makes it easy to see the value of a
     * NameSurferEntry.
     */
    public String toString() {
       String v = "";
        for (int i = 0; i < nameData.length; i++) {
            v += nameData[i] + " ";
        }
        return (v);
    }
}

