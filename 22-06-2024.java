    long ExtractNumber(String sentence) {
        long num = -1;
        long currentNum = 0;
        boolean validNum = true;
        boolean hasDigit = false;

        for (char c : sentence.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
                if (c - '0' > 8) {
                    validNum = false;
                }
                currentNum = currentNum * 10 + (c - '0');
            } else {
                if (hasDigit && validNum && currentNum > num) {
                    num = currentNum;
                }
                currentNum = 0;
                validNum = true;
                hasDigit = false;
            }
        }

        if (hasDigit && validNum && currentNum > num) {
            num = currentNum;
        }

        return num;
    }
}
