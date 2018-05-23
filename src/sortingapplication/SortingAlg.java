/*
 * Russell Lilljedahl
 * Sorting Algorithm Comparisons
 * 9 April 2018
 */
package sortingapplication;

/**
 *
 * @author Russell Lilljedahl
 */


/*
Class containing various sorting algorithms
*/
public class SortingAlg {
    
    long executionTime = 0;

    long bubbleSort(int array[]) {
        int temp, n = array.length;
        boolean swap;
      
        // initialize the time
        long startTime = executionTime();

        for (int i = 0; i < n - 1; i++) {
            swap = false;
            for (int j = 0; j < n - i - 1; j++){
                temp = array[j];
                array[i]= array[j + 1];
                array[j + 1] = temp;
                swap = true;
            }
            if (swap == false) {
                // list was already sorted
                break;
            }
        }
        long endTime = executionTime();   
        executionTime = endTime - startTime;
        return executionTime;
    } // end bubble sort
    
    long insertionSort(int array[]) {
        int position, value, n = array.length;
               
        // initialize the time
        long startTime = executionTime();
        
        for (int i = 1; i < n; ++i) {
            value = array[i];
            position = 1;
            
            while ((position > 0) && (array[position - 1] > value)) {
                array[position] = array[position - 1];
                position = position - 1;
            }
            
            array[position] = value;
        }
        
        long endTime = executionTime();   
        executionTime = endTime - startTime;
        return executionTime;
    } // end insertion sort
    
    long selectionSort(int array[]) {
        int n = array.length, min;
                
        // initialize the time
        long startTime = executionTime();
        
        for (int i = 1; i < n - 1; i++){
            // set minimum
            min = i;
            
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            } // end innter for
            
            // swap
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        } // end outer for
        
        long endTime = executionTime();   
        executionTime = endTime - startTime;
        return executionTime;
    } // end selection sort  
       
    long shellSort(int array[]) {
               
        // initialize the time
        long startTime = executionTime();
        
        // find the interval using Knuth's Formula
        int interval = 1;
        while (interval <= array.length / 3){
            interval = interval * 3 + 1;
        }
        
        while (interval > 0){
            for (int i = 0; i < array.length; i++){
                int value = array[i];
                int j;
                for (j = i; j > interval - 1 && array[j-interval] >= value; j = j - interval){
                    array[j] = array[j - interval];
                } // end inner for
                array[j] = value;
            } // end outer for
            interval = (interval - 1) / 3;
        } // end while       

        long endTime = executionTime();   
        executionTime = endTime - startTime;
        return executionTime;
    } // end shell sort
    
        
    private long executionTime() {
        long time = System.nanoTime();
        return time;
    }
    
} // end sorting class

/*
Bubble sort algorithm
begin BubbleSort(list)
   for all elements of list
      if list[i] > list[i+1]
         swap(list[i], list[i+1])
      end if
   end for
   return list
end BubbleSort

Pseudocode: https://www.tutorialspoint.com/data_structures_algorithms/bubble_sort_algorithm.htm
Bubble sort pseudocode
procedure bubbleSort( list : array of items )
   loop = list.count;
   for i = 0 to loop-1 do:
      swapped = false
      for j = 0 to loop-1 do:
         // compare the adjacent elements  
         if list[j] > list[j+1] then
            // swap them 
            swap( list[j], list[j+1] )		 
            swapped = true
         end if
      end for
      //if no number was swapped that means 
      //array is sorted now, break the loop.
      if(not swapped) then
         break
      end if
   end for
end procedure return list

Insertion sort algorithm
Step 1 − If it is the first element, it is already sorted. return 1;
Step 2 − Pick next element
Step 3 − Compare with all elements in the sorted sub-list
Step 4 − Shift all the elements in the sorted sub-list that is greater than the value to be sorted
Step 5 − Insert the value
Step 6 − Repeat until list is sorted

Pseudocode: https://www.tutorialspoint.com/data_structures_algorithms/insertion_sort_algorithm.htm
Insertion sort pseudocode
procedure insertionSort( A : array of items )
   int holePosition
   int valueToInsert

   for i = 1 to length(A) inclusive do:

      // select value to be inserted 
      valueToInsert = A[i]
      holePosition = i

      //locate hole position for the element to be inserted 

      while holePosition > 0 and A[holePosition-1] > valueToInsert do:
         A[holePosition] = A[holePosition-1]
         holePosition = holePosition -1
      end while

      //insert the number at hole position 
      A[holePosition] = valueToInsert

   end for

end procedure

Algorithm for selection sort
Step 1 − Set MIN to location 0
Step 2 − Search the minimum element in the list
Step 3 − Swap with value at location MIN
Step 4 − Increment MIN to point to next element
Step 5 − Repeat until list is sorted

Pseudocode: https://www.tutorialspoint.com/data_structures_algorithms/selection_sort_algorithm.htm
Selection sort pseudocode
procedure selection sort 
   list  : array of items
   n     : size of list
   for i = 1 to n - 1
   //set current element as minimum
      min = i    
      //check the element to be minimum
      for j = i+1 to n 
         if list[j] < list[min] then
            min = j;
         end if
      end for
      //swap the minimum element with the current element
      if indexMin != i  then
         swap list[min] and list[i]
      end if
   end for
end procedure

Algorithm for merge sort
    Step 1 − if it is only one element in the list it is already sorted, return.
    Step 2 − divide the list recursively into two halves until it can no more be divided.
    Step 3 − merge the smaller lists into new list in sorted order.

Pseudocode: https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm.htm
Merge sort pseudocode
    procedure mergesort( var a as array )
       if ( n == 1 ) return a
       var l1 as array = a[0] ... a[n/2]
       var l2 as array = a[n/2+1] ... a[n]
       l1 = mergesort( l1 )
       l2 = mergesort( l2 )
       return merge( l1, l2 )
    end procedure

    procedure merge( var a as array, var b as array )
       var c as array
       while ( a and b have elements )
          if ( a[0] > b[0] )
             add b[0] to the end of c
             remove b[0] from b
          else
             add a[0] to the end of c
             remove a[0] from a
          end if
       end while
       while ( a has elements )
          add a[0] to the end of c
          remove a[0] from a
       end while
       while ( b has elements )
          add b[0] to the end of c
          remove b[0] from b
       end while
       return c
    end procedure

*/