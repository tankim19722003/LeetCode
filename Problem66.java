class Solution {
    public int[] plusOne(int[] digits) {

        int i = digits.length - 1;
        int total = digits[i] + 1;
        int carry = 0;

        if (total <= 9) {
            digits[i] = total;
            return digits;
        }

        carry = total / 10;

        while (carry > 0 && i > 0 && digits.length > 1) {
            total = digits[i] + carry;
            carry = total / 10;
            digits[i] = total % 10;
            i--;
        }

        // handle for the first element
        if (carry > 0) {
            total = digits[i] + carry;
            if (total > 9) {
                carry = total / 10;
                digits[0] = total % 10;
                digits = addFirst(digits, carry);
            } else {
                digits[0] = total;
            }
        }

        return digits;
    }

    public static int[] addFirst(int[] arr, int value) {
        int[] newArr = new int[arr.length + 1];

        newArr[0] = value; // gán phần tử mới vào đầu

        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }

    public static void main(String[] args) {
        int[] digits = { 5, 8, 7, 8, 8 };
        Solution solution = new Solution();
        digits = solution.plusOne(digits);

        for (int digits2 : digits) {
            System.err.println(digits2);
        }
    }
}