/**
 * Created by Harout on 9/24/2015.
 */

import java.io.*;
import java.util.*;


public class StableMarriageAlgorithm {
    private String inputFileName;
    private static int n; //col
    private static int m; //row
    //private String arrayOfStrings[];
    static int[][] combined;
    static int[][] males;
    static int[][] females;

    static int[] maleC;
    static int[] femaleC;



    public StableMarriageAlgorithm(String inputFileName) throws Exception{
        this.inputFileName = inputFileName;
        readInputData();
        printSMA();



    }

    public void printSMA() {
        System.out.println("n is " + n);
        System.out.println("m is " + m);

        System.out.println();

        System.out.println("Male preferences: ");
        for(int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++){
                males[i][j] = combined[i][j];
                System.out.printf("%2d ", males[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Female preferences: ");
        int j;
        for(int i = n; i < m; i++){
            j = 0;
            for(int m = 0; m<n; m++){
                females[j][m] = combined[i][m];
                System.out.printf("%2d ", females[j][m]);
            }
            j++;
            System.out.println();
        }

        /*
        permuations of n x 2
        eg n = 3
        need permuations of m1 m2 m3 vs f1 f2 f3
        for males, have 0...n-1
        for females have n...m-n
        */

        System.out.println();

        //males
        maleC = new int[n];
        for(int i = 0; i < n; i++) {
            maleC[i] = i;
            System.out.println(maleC[i]);
        }

        System.out.println();

        //females
        femaleC = new int[n];
        int x = n;
        while(x<m) {
            for(int k = 0; k < n; k++) {
                femaleC[k] = x;
                System.out.println(femaleC[k]);
                x++;
            }
        }

        System.out.println();
        swap(maleC, 0, 1);
        System.out.println();
        //permute(java.util.Arrays.asList(3, 4, 5), 0);

        /*
        System.out.println();
        System.out.println("Male permuations: ");
        combinations(males);

        System.out.println();
        System.out.println("Female permutations: ");
        combinations(females);
        */

        //System.out.println(arrayOfStrings[1]);
        /*
        //print all
        for (String readline : arrayOfStrings) {
            System.out.println(readline);
        }
        */
/*
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
*/
       //System.out.println(arrayOfStrings.length);

        /*
        int[] newArr = new int[arrayOfStrings.length];

        for(int i = 0; i < n; i++) {
            try {
                newArr[i] = Integer.parseInt(arrayOfStrings[i]);
                System.out.println(newArr[i]);
            } catch (NumberFormatException nfe) {};


        }
        */

    }

    private void readInputData() throws Exception{
        java.io.File inputFile = new java.io.File(inputFileName);
        Scanner input = new Scanner(inputFile);
        n = input.nextInt(); //col
        m = n*2; //row

        combined = new int[m][n];
        males = new int[n][n];
        females = new int[n][n];

        while(input.hasNext()) {
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++) {
                    combined[i][j] = input.nextInt();
                    //System.out.printf("%2d", combined[i][j]);
                }
                //System.out.println();
            }
        }

        //Create an array of m strings
        //arrayOfStrings = new String[m];
/*
        try {
            // Create a bufferreader object to read our file with.
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            String line = ""; // Line will hold our line read from the file
            int counter = 0; //track num lines read
*/
            /*
            Read in a line from the file and store it in "line". Do this while we don't hit null or
            while the counter is less than m. Skip empty lines
            The counter prevents us from reading in too many lines.
            */
/*
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                if(line.trim().length() > 0) {
                    arrayOfStrings[counter] = line;
                    counter++;
                }
            }
            reader.close();
        }
        catch (Exception ex) { System.out.println("Exception: " + ex.getMessage()); }
*/
    }


/*
    //dont need anymore
    public static List<String> combinations(int[][] twoDimStringArray) {

        int sizeArray[] = new int[twoDimStringArray.length];

        int counterArray[] = new int[twoDimStringArray.length];

        int totalCombinationCount = 1;
        for(int i = 0; i < twoDimStringArray.length; ++i) {
            sizeArray[i] = twoDimStringArray[i].length;
            totalCombinationCount *= twoDimStringArray[i].length;
        }

        List<String> combinationList = new ArrayList<String>(totalCombinationCount);

        StringBuilder sb;

        for (int countdown = totalCombinationCount; countdown > 0; --countdown) {

            sb = new StringBuilder();
            for(int i = 0; i < twoDimStringArray.length; ++i) {
                sb.append(twoDimStringArray[i][counterArray[i]]);
            }
            combinationList.add(sb.toString());  // add new combination to list

            for(int incIndex = twoDimStringArray.length - 1; incIndex >= 0; --incIndex) {
                if(counterArray[incIndex] + 1 < sizeArray[incIndex]) {
                    ++counterArray[incIndex];
                    break;
                }
                counterArray[incIndex] = 0;
            }
        }
        System.out.println(combinationList);
        return combinationList;
    }
*/

/*
        //dont need anymore
        static void permute(java.util.List<Integer> arr, int k){
            for(int i = k; i < arr.size(); i++){
                java.util.Collections.swap(arr, i, k);
                permute(arr, k+1);
                java.util.Collections.swap(arr, k, i);
            }
            if (k == arr.size() -1){
                System.out.println(java.util.Arrays.toString(arr.toArray()));
            }
        }

*/

    //swapping works, must make recursive
    public static void swap(final int[] arr, final int pos1, final int pos2){
        final int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
        System.out.println(Arrays.toString(arr));
    }

}
