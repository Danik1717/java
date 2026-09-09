package Task3;

import java.util.List;

public class Task3Utils {
    private boolean hasEvenDigitCount(String str){
        return str.length()%2==0;
    }

    private static int[] countNumbersInPartSequence(String str){
        int [] arr = new int[10];
        for (int i = 0; i < str.length(); i++){
            char[] charStr = str.toCharArray();
            char ch = charStr[i];
            if ((ch >= '0') && (ch <= '9')){
                arr[ch - '0']++;
            }
        }
        return arr;
    }
    public static int[] countNumberInEntireSequence(String[] sequence) {
        int[] globalSeq = new int[10];

        for (String number : sequence) {
            if (number.length() % 2 == 0) {
                int[] freq = countNumbersInPartSequence(number);
                for (int i = 0; i < 10; i++) {
                    globalSeq[i] += freq[i];
                }
            }
        }
        return globalSeq;
    }
}
