package com.shpp.p2p.cs.vpereverza.assignment7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class NameSurferDataBase implements NameSurferConstants{
    ArrayList<String> database = new ArrayList <String>();
    /**
     * Creates a new NameSurferDataBase and initializes it using the
     * data in the specified file.  The constructor throws an error
     * exception if the requested file does not exist or if an error
     * occurs as the file is being read.
     */
    public NameSurferDataBase(String filename) {
        try {
            BufferedReader aaa = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = aaa.readLine()) !=null){
                database.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the NameSurferEntry associated with this name, if one
     * exists.  If the name does not appear in the database, this
     * method returns null.
     */
    public NameSurferEntry findEntry(String name) {
        for (String nameData : database) {
            NameSurferEntry entry = new NameSurferEntry(nameData);
            if (Objects.equals(entry.getName().toLowerCase(), name.toLowerCase()))
                return entry;
        }
            return null;
    }
}

