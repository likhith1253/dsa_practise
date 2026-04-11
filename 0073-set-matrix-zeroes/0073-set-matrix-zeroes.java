class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList <Integer> cols = new ArrayList<>();
        ArrayList <Integer> rows = new ArrayList<>();
        for(int i =0; i<matrix.length;i++){
            for(int j =0; j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    cols.add(i);
                    rows.add(j);
                }
            }
        }
        for(int k : cols){
            for(int i =0;i<matrix[0].length;i++){
                matrix[k][i] = 0;
            }
        }
        for(int m : rows){
            for(int j = 0;j<matrix.length;j++){
                matrix[j][m] = 0;
            }
        }
}}