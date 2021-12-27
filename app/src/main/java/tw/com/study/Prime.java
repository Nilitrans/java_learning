package tw.com.study;

public class Prime {
    public boolean isPrime(int x){
        for (int i = 2 ; i <= x/2 ; i++) {
            if(x%2 ==0){
                return false;
            }
        }
        return true;
    }
    public int isTwinPrim(int inputNumber){
        int groupSum = 0 ;
        for(int i =2 ; i< inputNumber;i++){
            if(isPrime(i) && isPrime(i+2) && (i+2)<=inputNumber){
                groupSum++;
            }
        }
        return groupSum;
    }
}
