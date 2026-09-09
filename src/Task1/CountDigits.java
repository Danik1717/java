package Task1;

public class CountDigits{
    public static int countLessThanFive(int num){
        int count = 0;
        int remainder = 0;
        int absNumber = num;
        if (num<0){
            absNumber = num*(-1);
        }

        if (num==0) return 0;

        while(absNumber!=0){
            remainder = absNumber%10;
            if(remainder<5){count++;}
            absNumber /= 10;
        }

        return count;

    }
}
