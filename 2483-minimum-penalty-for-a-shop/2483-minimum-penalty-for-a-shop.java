class Solution {
    public int bestClosingTime(String customers) {
       int n=customers.length();

        int min_penalty=0;
        int min_hour=0; 
        int penalty=0;

        // if shop close at 0th hour
        for(int i=0; i<n; i++)
        {
            if(customers.charAt(i)=='Y')
                penalty++;    
        }   

        min_penalty=penalty;

        for(int i=1; i<=n; i++)
        {
            if(customers.charAt(i-1)=='Y')
                penalty--;
            else
                penalty++;

            if(penalty<min_penalty)
            {
                min_penalty=penalty;
                min_hour=i;
            }    
        } 

        return min_hour;
    }
}