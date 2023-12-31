//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int a[] , int n)
    {
        //add code here.
        // for(int i = 0 ; i < n; i++){
        //     for(int j = i + 1 ; j < n; j++){
        //         for(int k = j + 1 ; k < n ;k++ ){
        //             if (a[i] + a[j] + a[k]==0){
        //                 return true;
        //             }
        //         }
        //     }
        // }
        // return false;
        Arrays.sort(a);
        for ( int i = 0; i < n ; i++){
               int j = i+1;
               int k = n-1;
               while(j<k){
                   if (a[i] + a[j] + a[k] < 0){
                       j++;
                   }
                   else if(a[i] + a[j] + a[k] > 0) {
                       k--;
                   }
                   else{
                       return true;
                   }    
               }
        }
        return false;
    }
}