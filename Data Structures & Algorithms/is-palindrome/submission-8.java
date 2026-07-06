class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder cleaned = new StringBuilder();

        // Keep only letters/numbers and convert to lowercase
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                cleaned.append(Character.toLowerCase(ch));
            }
        }

        // Reverse cleaned string
        String original = cleaned.toString();
        String reversed = cleaned.reverse().toString();

        // Compare original and reversed
        return original.equals(reversed);
    }
}