 public class Solution {
    private final int MOD = 1_000_000_007;
    int N;
    int GOAL;
    int K;
    private Long[][] t;

    public int numMusicPlaylists(int n, int goal, int k) {
        t = new Long[goal + 1][n + 1];
        for(Long[] row : t) {
            Arrays.fill(row, -1L);
        }
        N    = n;
        GOAL = goal;
        K    = k;
        
        return (int) (solve(0, 0));
    }

    private long solve(int count_song, int count_unique) {
        if(count_song == GOAL) {
            if(count_unique == N)
                return 1;
            
            return 0;
        }
        
        if(t[count_song][count_unique] != -1)
            return t[count_song][count_unique];
        
        long result = 0;
        
        //Option-1 (Play a unique song)
        if(count_unique < N)
            result += (N-count_unique) * solve(count_song+1, count_unique+1);
        
        //Option-2 (Replay a song)
        if(count_unique > K)
            result += (count_unique - K) * solve(count_song+1, count_unique);
        
        
        return t[count_song][count_unique] = result % MOD;

    }
}