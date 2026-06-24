class Solution {
    public boolean isValidSudoku(char[][] b) {
    Set s=new HashSet<>();
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            char c=b[i][j];
            if(c!='.'){
                if(!s.add(c+"in r"+i)||
                !s.add(c+"in c"+j)||
                !s.add(c+" in b"+i/3+"."+j/3)){
return false;
                }
            }
        }

    }
return true;
    }
}

