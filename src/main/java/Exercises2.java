import java.util.*;

public class Exercises2 {

    //region [ - twoSum(int[] nums, int target) - ]
    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] nums, int target) {
        int[] answerIndices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                if (nums[i] + nums[j] == target) {
                    answerIndices[0] = i;
                    answerIndices[1] = j;
                    return answerIndices;
                }
            }
        }

        return answerIndices;
    }
    //endregion

    //region [ - romanToInt(String s) - ]
    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public static int romanToInt(String s) {
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int n = switch (currentChar) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };

            if (i != s.length() - 1) {
                char nextChar = s.charAt(i + 1);
                int m = switch (nextChar) {
                    case 'I' -> 1;
                    case 'V' -> 5;
                    case 'X' -> 10;
                    case 'L' -> 50;
                    case 'C' -> 100;
                    case 'D' -> 500;
                    case 'M' -> 1000;
                    default -> 0;
                };
                if (n < m) {
                    n = m - n;
                    i++;
                }
            }
            number += n;
        }

        return number;
    }
    //endregion

    //region [ - permute(int[] nums) - ]
    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());

        for (int currentNumber : nums) {
            int n = permutations.size();

            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutations.poll();

                for (int j = 0; j <= Objects.requireNonNull(oldPermutation).size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(j, currentNumber);

                    if (newPermutation.size() == nums.length)
                        result.add(newPermutation);

                    else
                        permutations.add(newPermutation);
                }
            }
        }

        return result;
    }
    //endregion

    //region [ - main(String[] args) - ]
    public static void main(String[] args) {
        // test your code here!
    }
    //endregion

}