class Solution {
    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        board[m-1][n-1] = 1;
        return backtracking(board, m, n, 0, 0);
    }
    
    private int backtracking(int[][] board, int m, int n, int r, int c){
        if(r == m || c == n) return 0;
        if(board[r][c] != 0) return board[r][c];
        int n1 = backtracking(board, m, n, r+1, c);
        int n2 = backtracking(board, m, n, r, c+1);
        board[r][c] = n1 + n2;
        return board[r][c];
    }
}