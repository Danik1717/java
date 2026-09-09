import java.math.BigInteger;

public class GetReverseNumber {
    private static int getSumOfDigits(BigInteger num){
        int sum = 0;
        while(num.compareTo(BigInteger.ZERO)>0){
            sum+=num.mod(BigInteger.TEN).intValue();
            num = num.divide(BigInteger.TEN);
        }
        return sum;
    }

    private static boolean hasEvenDigitSum(BigInteger num) {
        int sum = getSumOfDigits(num);
        return sum % 2 == 0;
    }
    private static BigInteger reverseNumber(BigInteger num){
        BigInteger revNum = BigInteger.ZERO;
        while(num.compareTo(BigInteger.ZERO)>0){
            revNum= revNum.multiply(BigInteger.TEN).add(num.mod(BigInteger.TEN));
            num = num.divide(BigInteger.TEN);
        }

        return revNum;
    }

    public static String processNumber(BigInteger num) {
        if (hasEvenDigitSum(num)) {
            return reverseNumber(num).toString();
        } else {
            return "";
        }
    }
}
