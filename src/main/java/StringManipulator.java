public class StringManipulator {
    public String reverseString(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = input.length()-1; i>-1; i--){
            sb.append(input.toCharArray()[i]);
        }
        return sb.toString();
    }

    public boolean isPalindrome(String input) {
        return input.equalsIgnoreCase(reverseString(input));
    }
}
