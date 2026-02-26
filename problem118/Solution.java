package problem118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  pascalTriangle = new ArrayList<>();
        List<Integer> firstItem = new ArrayList<>();
        firstItem.add(1);
        pascalTriangle.add(firstItem);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i+1);
            row.add(1);
            for (int j = 1; j <= i - 1; j++) {
                int firstValue = pascalTriangle.get(i - 1).get(j-1);
                int secondValue = pascalTriangle.get(i - 1).get(j);
                row.add(firstValue + secondValue);
            }
            row.add(1);
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }

    public void print(List<List<Integer>> lists) {

        for (List<Integer> list : lists) {
            for (int item : list) {
                System.out.print(item + " ");
            }
            System.out.println("\n");
        }

    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        List<List<Integer>> result = solution.generate(5);
        solution.print(result);

    }
}
