package problem67;

class Solution {
    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;
        String result = "";
        int carry = 0;
        while (i >= 0 && j >= 0) {

            int aItemInt = Integer.parseInt(a.charAt(i) + "");
            int bItemInt = Integer.parseInt(b.charAt(j) + "");

            if (aItemInt + bItemInt + carry == 3) {
                carry = 1;
                result = '1' + result;
            } else if (aItemInt + bItemInt + carry < 2) {
                result = aItemInt + bItemInt + carry + result;
                carry = 0;
            } else if (aItemInt + bItemInt + carry == 2) {
                carry = 1;
                result = '0' + result;
            }
            i--;
            j--;
        }

        if (a.length() == b.length() && carry > 0) {
            return "1" + result;
        }

        if (a.length() < b.length()) {
            while (carry > 0 && j >= 0) {
                int bItemInt = Integer.parseInt(b.charAt(j) + "");
                if (bItemInt + carry < 2) {
                    result = (bItemInt + carry) + result;
                    carry = 0;
                    j--;
                    break;
                }
                result = '0' + result;
                carry = 1;
                j--;
            }
            for (int k = j; k >= 0; k--)
                result = b.charAt(k) + result;
        } else {
            while (carry > 0 && i >= 0) {
                int aItemInt = Integer.parseInt(a.charAt(i) + "");
                if (aItemInt + carry < 2) {
                    result = (aItemInt + carry) + result;
                    carry = 0;
                    i--;
                    break;
                }

                // SOLVE THIS CASES
                result = '0' + result;
                carry = 1;
                i--;
            }
            for (int k = i; k >= 0; k--)
                result = a.charAt(k) + result;
        }

        if (carry > 0)
            return "1" + result;

        return result;
    }

    public static void main(String[] args) {
        String a = "1101";
        String b = "10";
        Solution problem67 = new Solution();
        String total = problem67.addBinary(a, b);
        System.out.println(total);
    }
}