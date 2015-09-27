/**
 * Created by Harout on 9/24/2015.
 */

import java.io.*;
import java.util.*;


public class StableMarriageAlgorithm {
    private String inputFileName;
    private int n;
    private int m;
    private String arrayOfStrings[];


    public StableMarriageAlgorithm(String inputFileName) throws Exception{
        this.inputFileName = inputFileName;
        readInputData();
        printSMA();

    }

    public void printSMA() {
        System.out.println("n is " + n);
        //System.out.println(arrayOfStrings[1]);
        /*
        //print all
        for (String readline : arrayOfStrings) {
            System.out.println(readline);
        }
        */

        System.out.println("Male preferences: ");
        for(int i = 0; i < n; i++) {
            System.out.println("Male " + i + " preferences " + arrayOfStrings[i]);
        }

        System.out.println();

        System.out.println("Female preferences: ");
        int j = m-n;
        while(j < m) {
            for (int i = 0; i < n; i++) {
                System.out.println("Female " + i + " preferences " + arrayOfStrings[j]);
                j++;
            }
        }

    }

    private void readInputData() throws Exception{
        java.io.File inputFile = new java.io.File(inputFileName);
        Scanner input = new Scanner(inputFile);
        n = input.nextInt();
        m = n*2;

        //Create an array of m strings
        arrayOfStrings = new String[m];


        try {
            // Create a bufferreader object to read our file with.
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));

            String line = ""; // Line will hold our line read from the file

            int counter = 0; //track num lines read

            /*
            Read in a line from the file and store it in "line". Do this while we don't hit null or
            while the counter is less than m. Skip empty lines
            The counter prevents us from reading in too many lines.
            */
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                if(line.length() > 0) {
                    arrayOfStrings[counter] = line;
                    counter++;
                }
            }

            reader.close();


        }


        catch (Exception ex) { System.out.println("Exception: " + ex.getMessage()); }
    }







}
