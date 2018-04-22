/*
 * Russell Lilljedahl
 * Sorting Algorithm Comparisons
 * 9 April 2018
 */
package sortingapplication;

import java.util.Random;

/**
 *
 * @author Russell Lilljedahl
 */


/*
This class is the bulk of th program
It creates random number of data set sizes. So the size of the array.
It then generates random numbers for each element of the array.
The sort the data via the sorting alg class.
*/
public class CreateData {
    
    static int count = 0;
    static long executionTime = 0, executionTime2 = 0, avgExecutionTime = 0, 
            avgExecutionTime2 = 0, exTime1 = 0, exTime2 = 0;
    static int[] dataSetSize;
    static long[] executionTimeArray, executionTimeArray2;
        
    
    public void CreateData(int dataSets, String sort1, String sort2) {
        
        SortingAlg sortAlg = new SortingAlg();
        executionTimeArray = new long[dataSets];
        executionTimeArray2 = new long[dataSets];
        dataSetSize = new int[dataSets];

        // create arrays
        for (int i = 0; i < dataSets; i++) { // create 50 data sets
            // get data set size
            int value = randomDataSetSize(count);
            int[] array = new int[value];
            dataSetSize[i] = value;
            
            // create array, sort it
            array = createRandomNumbers(value);
            long time1 = performSort(array, sort1); // sort first selection
            System.out.println("Time 1: " + time1);
            executionTime += time1; // sum
            executionTimeArray[i] = time1;
            
            long time2 = performSort(array, sort2); // sort second selection
            System.out.println("Time 2: " + time2);
            executionTime2 += time2; // sum
            executionTimeArray2[i] = time2;
            
            count++; 
        } // end create array for loop
        
        // find average times
        avgExecutionTime = findAvgExecutionTime(dataSets, executionTime);
        avgExecutionTime2 = findAvgExecutionTime(dataSets, executionTime2);
        setExecutionTims(avgExecutionTime, avgExecutionTime2);
    }
    
    int[] createRandomNumbers(int count) {
        int[] array = new int[count];
        int value;
        
        for (int i = 0; i < count; i++) {
            Random rand = new Random();
            value = rand.nextInt(100000); // seems large enough
            array[i] = value;
        }
        
        return array;
    }
    
    int randomDataSetSize(int count) {
        Random rand = new Random();
        int value = rand.nextInt(5000);
        return value;
    }
    
    public long performSort(int[] array, String one) {
        
        SortingAlg sort = new SortingAlg();
        long time = 0;
        
        if (one.contains("bubble")) {
            time = sort.bubbleSort(array);
        } else if(one.contains("insertion")) {
            time = sort.insertionSort(array);
        } else if(one.contains("selection")) {
            time = sort.selectionSort(array);
        } else if(one.contains("shell")) { 
            time = sort.shellSort(array);
        }
        return time;
    }
    
    long findAvgExecutionTime(int dataSets, long executionTime) {
        long avgET = executionTime / dataSets;
        return avgET;
    }
        
    int getDataSetSize(int count) {
        return dataSetSize[count];
    }
    
    void setExecutionTims (long eT, long eT2) {
        exTime1 = eT;
        exTime2 = eT2;
    }
    
    long getExecutionTime1() {
        return exTime1;
    }
    long getExecutionTime2() {
        return exTime2;
    }
    long getTime1(int count) {
        return executionTimeArray[count];
    }
    long getTime2(int count) {
        return executionTimeArray2[count];
    }

    
} // end class create data
