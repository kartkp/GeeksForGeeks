class Solution {
String compareFrac(String str) {
        int n = str.length();
        int a = 0, b = 0, c = 0, d = 0;
        int i = 0;
        while (i < n && str.charAt(i) != '/') {
            a = a * 10 + str.charAt(i) - '0';
            i++;
        }
        i++;
        while (i < n && str.charAt(i) != ',') {
            b = b * 10 + str.charAt(i) - '0';
            i++;
        }
        i += 2; // Skip ", "
        while (i < n && str.charAt(i) != '/') {
            c = c * 10 + str.charAt(i) - '0';
            i++;
        }
        i++;
        while (i < n) {
            d = d * 10 + str.charAt(i) - '0';
            i++;
        }
        if ((a * d) > (b * c)) {
            return a + "/" + b;
        } else if ((a * d) < (b * c)) {
            return c + "/" + d;
        }
        return "equal";
    }
}
