class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        list.add(firstRow);
        
        if (numRows == 1) return list;

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = list.get(i - 1);
            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }
            list.add(temp);
        }
        return list;
    }
}