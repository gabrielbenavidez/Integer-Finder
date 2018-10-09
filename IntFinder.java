/************************************************** 

Purpose/ Description: A program to find a given number within an array in sub linear time

**************************************************/



import java.util.*;

public class Problem2 
{
    static ArrayList<Integer> exists = new ArrayList<>();
    static int[] array = new int[]{1,2,3,4,9,-1,-2,-3,-9};
    static int key;
    static int maximum;
    static int maxPosition = 0;
    public static void findMax(int arr[])
    {   int max = 0;
        int low = 0;
        int high = arr.length - 1; 
        boolean done = false;
        
        while(low <= high && !done)
        {
            int mid = ((high + low)/2);
          
           
             if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid + 1])
            {
                maxPosition = mid;
               
                max = arr[mid];
                done = true;
            }
             
             else if(arr[mid] < arr[mid - 1])
            {
                high = mid;
            }
            
             else if(arr[mid] > arr[mid - 1])
            {
                if(arr[mid] > max)
                {
                    maxPosition = mid;
                    max = arr[mid];
                    
                }
                low = mid; 
            }
                
        }
       
        maximum = max;
    }
    

    public static void checkFirstHalf(int arr[],int num)
    {
        int low1 = 0;
        int high1 = maxPosition;
        int mid1 = ((low1 + high1)/2);
        int status = 0;
        
        while(low1 <= high1)
        {
           
            if(num < arr[mid1] )
            {
                high1 = mid1-1;
            }
            
            else if(num > arr[mid1])
            {
               low1 = mid1 + 1;
            
            }
            
            else 
            {
              
                status = 1;
                break;
            }
           mid1 = ((low1 + high1)/2);
           
        }
        
        if(status == 1)
        {
            System.out.println("Integer "+ key + " found in array");
           
        }
        
        else if(status == 0)
        {
            
            
            checkSecondHalf(arr, num);
        }
        
        
    }
    
   public static void checkSecondHalf(int arr[],int num)
    {
       int status = 0;
       int low2 = maxPosition+1;
       int high2 = arr.length - 1;
       int mid2 = ((low2 + high2)/2);
      
       while(low2 <= high2)
       {
           
           
           if(num < arr[mid2])
           {
               low2 = mid2+1;
           }
           
           else if(num > arr[mid2])
           {
               high2 = mid2 -1;
           }
           
           else
           {
            
             status = 1;
             break;
           }
           
           mid2 = ((low2 + high2)/2);
           
       } 
       
       if(status == 1)
       {
           System.out.println("Integer "+ key + " found in array");
       
       }
       
       if(status == 0)
       {
          System.out.println(key + " Not found in array ");
       }
          
      
    }
  
    
    
    public static void main(String args[])
  {
      findMax(array);
      Scanner in = new Scanner(System.in);
      System.out.println("Enter a number: ");
      key = in.nextInt();
      checkFirstHalf(array,key);
      
  }
    
    
    
    
}
