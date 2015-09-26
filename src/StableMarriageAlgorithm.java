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

        BufferedReader in = new BufferedReader(new FileReader(inputFileName));
        String str;

        List<String> list = new ArrayList<String>();
        while((str = in.readLine()) != null){
            list.add(str);
        }

        String[] stringArr = list.toArray(new String[0]);

    }


}
