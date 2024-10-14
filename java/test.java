import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;


public class test {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n1 = sc.nextInt();
//        1st way to implement an interface
//        Calculate add = new Addition();
//        System.out.println("sum is : "+add.calc(n,n1));
//
//        //2nd way to implement an interface using anonymous class
//        Calculate product = new Calculate () {
//            @Override
//            public int calc(int a,int b){
//                return a*b;
//            }
//        };
//        System.out.println("product is : "+ product.calc(n,n1));
//
//        //3rd way of implementing an interface using lambda function
//        Pallindrome pal = (str)->{
//            int low =0;
//            int high = str.length() -1;
//            while(low<= high){
//                if(str.charAt(low) != str.charAt(high)){
//                    return false;
//                }
//                low++;high--;
//            }
//            return true;
//        };
//        String str = sc.next();
//        System.out.println("is Pallindrome : " + pal.isPallindrome2(str));

        // 4 base functional interface -> consumer,supplier,predicate,Function
        BiFunction<Integer,Integer,Integer> sum = (a,b)-> a+b;
        Function<Integer,Boolean> oddOrEven = (a) -> a%2 ==0;
        Predicate<Integer> isEven = (a)-> a%2 ==0;
        Predicate<String> isPallindrome1 = (str)->{

            int low = 0;
            int high = str.length()-1;
            while(low<= high){
                if(str.charAt(low) != str.charAt(high)){
                    return false;
                }
                low++;high--;
            }
            return true;
        };
        BiFunction<Integer,Integer,Double> powerOf = (a,b)-> Math.pow(a,b);
        Function<String,Boolean> isPallindrome2 = (str)->{
            int low = 0;
            int high = str.length()-1;
            while(low<= high){
                if(str.charAt(low) != str.charAt(high)){
                    return false;
                }
                low++;high--;
            }
            return true;

        };

        System.out.println("Bi functional sum is : " + sum.apply(n,n1));
        System.out.println("isEven : " + oddOrEven.apply(n));
        System.out.println("isPallindrome2 : " + isPallindrome2.apply("madam"));
        System.out.println(n + " to the power "+n1+" is: "+powerOf.apply(n,n1));



    }






}
