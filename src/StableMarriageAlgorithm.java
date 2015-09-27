/**
 * Created by Harout on 9/24/2015.
 */

import java.io.*;
import java.util.*;


public class StableMarriageAlgorithm {
    private String inputFileName;
    private int n;


    public StableMarriageAlgorithm(String inputFileName) throws Exception{
        this.inputFileName = inputFileName;
        readInputData();
        printSMA();

    }

    public void printSMA() {
        System.out.print("n is " + n);
    }

    private void readInputData() throws Exception{
        java.io.File inputFile = new java.io.File(inputFileName);
        Scanner input = new Scanner(inputFile);
        n = input.nextInt();
        int m = (n+1)*2;

        //Create an array of m strings
        String arrayOfStrings[] = new String[m];


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
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() == 0) {
                    continue;
                }
                else {

                    while (((line = reader.readLine()) != null) && (counter < m)) {
                        arrayOfStrings[counter] = line;
                        counter++;
                    }

                }
            }


            // print array
            for (String readline : arrayOfStrings) {
                System.out.println(readline);
            }

            reader.close();

            System.out.println();
            System.out.println(arrayOfStrings[1]);
        }


        catch (Exception ex) { System.out.println("Exception: " + ex.getMessage()); }
    }







}
