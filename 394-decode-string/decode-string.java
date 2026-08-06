class Solution {
    public String decodeString(String s) {
       Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If digit, build the number
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            }

            // If opening bracket
            else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            }

            // If closing bracket
            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                for (int j = 0; j < repeat; j++) {
                    decoded.append(current);
                }
                current = decoded;
            }

            // If letter
            else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}