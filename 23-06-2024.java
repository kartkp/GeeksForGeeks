class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        int op = 0;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                op++;
                stack.push(op);
                result.add(op);
            } else if (c == ')') {
                result.add(stack.pop());
            }
        }
        return result;
    }
}
