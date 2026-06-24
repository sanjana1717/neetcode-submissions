class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> c = new HashMap<>();
        Map<Integer, Set<Character>> r = new HashMap<>();
        Map<String, Set<Character>> m = new HashMap<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if (board[i][j]=='.') continue;
                String key=(i/3) + ","+(j/3);
                if(r.computeIfAbsent(i,k-> new HashSet<>()).contains(board[i][j])||
                c.computeIfAbsent(j,k-> new HashSet<>()).contains(board[i][j])||
                m.computeIfAbsent(key,k-> new HashSet<>()).contains(board[i][j])){
                    return false;
                }
                r.get(i).add(board[i][j]);
                c.get(j).add(board[i][j]);
                m.get(key).add(board[i][j]);
            }
        }
        return true;
    }
}
