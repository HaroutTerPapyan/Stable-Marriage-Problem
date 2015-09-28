/**
 * Created by Harout on 9/24/2015.
 */

import java.io.*;
import java.util.*;


public class StableMarriageAlgorithm {
    private String inputFileName;
    private static int n; //col
    private static int m; //row
    public int[][] combined;
    public int[][] males;
    public int[][] females;
    public int[] maleC;
    public int[] femaleC;
    public int N, engagedCount;
    public int[] womenPartner;
    public boolean[] menEngaged;


    public StableMarriageAlgorithm(String inputFileName) throws Exception{
        this.inputFileName = inputFileName;
        readInputData();
        printSMA();

        System.out.println();
        StableMatching(maleC, maleC, males, females);



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
        System.out.println("Female permutations: ");
        permuteFemale();


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
                    System.out.printf("%2d", combined[i][j]);
                }
                System.out.println();
            }
        }


    }

    public void permuteMale() {
        int[] temp = Arrays.copyOf(maleC, maleC.length);
        printAll(0,temp);
    }

    public void permuteFemale() {
        int[] temp = Arrays.copyOf(femaleC, femaleC.length);
        printAll(0,temp);
    }

    private void printAll(int index,int[] temp) {
        if(index==n) {
            System.out.println(Arrays.toString(temp));
        }
        else {
            for(int i = index; i < n; i++) {//change the first element stepwise
                swap(temp,index,i);//swap to change
                printAll(index+1, temp);//call recursively
                swap(temp,index,i);//swap again to backtrack
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]  = temp;
    }

    public void StableMatching(int[] m, int[] w, int[][] mp, int[][] wp)
    {
        N = mp.length;
        engagedCount = 0;
        maleC = m;
        femaleC = w;
        males = mp;
        females = wp;
        menEngaged = new boolean[N];
        womenPartner = new int[N];
        calcMatches();
    }

    public void calcMatches()
    {
        while(engagedCount < N){
            int free;
            for(free = 0; free < N; free++){
                if(!menEngaged[free]){
                    break;
                }
            }
            for( int i = 0; i < N && !menEngaged[free]; i++){
                int index = womenIndexOf(males[free][i]);
                if (womenPartner[index] == 0){
                    womenPartner[index] = maleC[free];
                    menEngaged[free] = true;
                    engagedCount++;
                }
                else{
                    int currentPartner = womenPartner[index];
                    if(morePreference(currentPartner, maleC[free], index)){
                        womenPartner[index] = maleC[free];
                        menEngaged[free] = true;
                        menEngaged[menIndexOf(currentPartner)] = false;
                    }
                }
            }
        }
        printCouples();
    }

    public boolean morePreference(int currentPartner, int men2, int index){
        for(int i = 0; i < N; i++){
            if(females[index][i] == men2){
                return true;
            }
            if(females[index][i] == currentPartner){
                return false;
            }
        }
        return false;
    }

    public int menIndexOf(int str){
        for(int i = 0; i < N; i++){
            if(maleC[i] == str){
                return i;
            }
        }
        return -1;
    }

    public int womenIndexOf(int menPref2){
        for(int i = 0; i < N; i++){
            if(femaleC[i] == menPref2){
                return i;
            }
        }
        return -1;
    }

    public void printCouples(){
        System.out.println("Couples are : ");
        for(int i = 0; i < N; i++){
            System.out.println(womenPartner[i] + " " + femaleC[i]);
        }
    }
}
