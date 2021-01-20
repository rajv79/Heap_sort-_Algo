
package p7vivekraj;

import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

public class P7Vivekraj {

  public static int nswaps =0;
  public static double nc = 0;
  


     public static void main(String[] args){
         
      
      int size = Integer.parseInt(JOptionPane.showInputDialog("How Many Items to"
                                                        + " sort," + " n = ?"));
      int[] data = new int [size];
      
      randomValues(data);
      System.out.println("Unsorted");
      System.out.println(Arrays.toString(data));
      System.out.println();
      	
       //reHeapDown(data.length, data, 0);
       heapSort(data);
      
      //reheapDownward(data.length, data, 0);
      System.out.println("Sorted");
      System.out.println(Arrays.toString(data));
      System.out.println("");
      
      System.out.println("********************************************");
    
      //System.out.println("Actual swaps = " + nswaps   + " Predicted swaps  =" + prswaps);
      
     
      
      
      
      double minsorteffort = ( size*(Math.log(size)/Math.log(2)));
      double minsor =   Math.round(minsorteffort*100.0)/100.0;
      
      
      double predicatedsorteff   = ( 3*size*(Math.log(size)/Math.log(2)));
      double pse =  Math.round(predicatedsorteff *100.0)/100.0;
      
      double predicatedswaps = ( 2*size*(Math.log(size)/Math.log(2)));
      double pswasp =  Math.round(predicatedswaps*100.0)/100.0; 
      
      double actualsorteffort =  nc;
      double ase = Math.round(actualsorteffort*100.0)/100.0;
      
      System.out.println("Actual swaps =  " + nswaps   +   "       Predicted swaps  = " + pswasp);
      System.out.println("Actual sort effort =  " + ase +  "    Predicated sort efforts = " + pse+ "     Min sort effort = " + minsor);
      
      
    }
    
    public static void reHeapDown(int size, int[] data, int root)
    {
        if(size <= 1 )// ----------- 1 or no nodes in the tree: BC1
        {
            return;
        }    
        if(root*2+1 >= size )// ------------------root has no children, BC2
        {
            return;
        }    
        if(root*2+1 == size-1 )// ---------------root has 1 child, 
            
        {
            nc++; //---------------- we put the number of comparios before the if statement to count how many comparriosn we did even if it is false but we compare so dont put inisde the if statment
            if(data[root] > data[root*2+1]) // ------------root is larger than its child
            {
                return; //BC case 3
            }
            else
            {
                swap(data, root, root*2+1); //-----------swap root and left child
                return;
            }
        }    
        // root has 2 children
        nc+=1.5; //--(we increment ny 2 as we comapare two things at time )-------------we put the number comparison that how many times we compare dont put inside the if ,becouse if it false it will not increment the comparion number 
        if(data[root] > data[root*2+1] &&
           data[root] > data[root*2+2]) //------- base case 3
        {
            return;
        }
        else
        { 
            nc++;
            if(data[root*2+1] > data[root*2+2]) //----------- left is larger
            {
                swap(data, root,root*2+1);
                reHeapDown(size, data, root*2+1);
            }
            else
            {
                swap(data, root,root*2+2);
                reHeapDown(size, data, root*2+2);
                
            }
        } 
        
        
        
    } 
    public static void heapSort(int[] data)
    { // Step 1: plaace the items in a left balanced binary tree
        // do nothing just remember the 2n+1 & 2n+2 rule

     // Step 2: build the intial heap using reheap down
        for(int ip = data.length/2 - 1; ip>=0; ip--)// this will help to make a intial heap by reheap down alogorthium
        {
            reHeapDown(data.length, data, ip);
        }    
            
      // Step 3: Put root in its proprer spot, rebuild ignoring it
    	for(int i = 1; i<=data.length; i++)
        {
            swap(data, 0, data.length - i);
            reHeapDown(data.length - i, data, 0);
            
        }    
    }
    public static void randomValues(int[] data) // random numbers from 0 to 999, no duplicates
    {  Random rn = new Random();
       int r = -1;
       boolean duplicate;
       data[0] = rn.nextInt(data.length);
    
       for(int index = 1; index < data.length; index++)
       {  duplicate = true;
          while(duplicate == true)  // r is a duplicate value
          { r = rn.nextInt(data.length);
            duplicate = false;
            for(int j = 0; j < index; j++) // check all the set elements for a duplicate
            {  if(data[j] == r) // a duplicate found
               {  duplicate = true;
                  break;
               }// end if	
            }// end for 
            if(duplicate == false)
            	data[index] = r;
          }  
       }		
    }		
    public static void swap(int[] data, int i1, int i2)// --- Algorthium for the swap method
            
    {
        nswaps++; // ------------- this will count number swpas used in the sorting efforts
        
        int temp = data[i1];
        data[i1] = data[i2];
        data[i2] = temp;
    }
  

         
      
  
}    


