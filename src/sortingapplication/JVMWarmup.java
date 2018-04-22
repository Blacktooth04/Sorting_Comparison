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
public class JVMWarmup {
    
    protected void run() {
        for (int i = 0; i < 100000000; i++) {
            otherMethod();
        }
        System.out.println("Warmed up");
    }
    
    void otherMethod() {
        thirdMethod();
    }
    
    void thirdMethod() {
        
    }
}

