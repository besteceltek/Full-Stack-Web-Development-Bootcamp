public class Main {
    public static void main(String[] args) {
        //Created a loop that goes from 2 to 100
        for(int i = 2; i <= 100; i++){
            //Defined a boolean value that will contain if a number is prime or not
            boolean isPrime= true;
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    isPrime= false;
                    break;
                }
            }
            //Printed the numbers if they are prime
            if(isPrime){
                System.out.print(i + " ");
            }
        }
    }
}