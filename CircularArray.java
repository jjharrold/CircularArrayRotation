package circulararray;
import java.io.*;
import java.util.*;

public class CircularArray {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt(); // Set n as the number of element in an array of integers
        int k = in.nextInt(); // Set k as the number of times the operation is performed
        int q = in.nextInt(); // Set q as the number of queries
        
        
        ArrayList<Integer> nList = new ArrayList<Integer>(); // Create a list of the inputs
        ArrayList<Integer> nListNew = nList; // Create a list to store values after rotations 
        
        for(int i = 0; i < n; i++){ //adds all the numbers to a list
            nList.add(in.nextInt());  
        }
        
        ArrayList<Integer> newList = new ArrayList<Integer>();
        
        int rem = k%n; // Get the remainder of k/n
        
        if(k > n){ // Is the number of operations greater than the number of elements in the array?
            if(rem == 0){ // The list is unchanged if the number of operations is divisible by the number of elements in the array
                newList = nList;
            }
            else{
                for(int i = rem; i > 0; i--){ // Add the last element of the list to the front
                    newList.add(nList.get(n - i));
                }
            }
        }
        
        else{
            for(int i = 1; i <= k; i++){
                newList.add(0,(nList.get(n-i))); //adds the last number of the old list to the new list
            }
        }
        
        
        if(rem == 0){ // If k is divisible by n then the list is unchanged
            newList = nList;
        }
        
        else if(k > n){
            for(int y = 0; y < n-rem; y++){
                newList.add(nListNew.get(y)); // Add the items to the list up to n minus the remainder
            }
        }
        else{
            for(int j = 0; j < n-k; j++){
                newList.add(nListNew.get(j)); // Add the items to the list up to n minus k
            }
        }
        
        ArrayList<Integer> qList = new ArrayList<Integer>(); // Create a list of query locations
        for(int i = 0; i < q; i++){
           qList.add(in.nextInt());
           System.out.println(newList.get(qList.get(i))); // Print the list for each query location
        }
        
        in.close(); // Close the scanner
        
    }
}
