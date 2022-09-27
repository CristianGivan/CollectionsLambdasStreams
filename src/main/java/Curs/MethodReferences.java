package Curs;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferences {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer>maxFunction =(x,y)->Integer.max(x,y);
        BiFunction<Integer,Integer,Integer>maxFunction2 = Integer::max;
        System.out.println(maxFunction.apply(1,2));
        System.out.println(maxFunction2.apply(1,2));
        String word="java";
        int indexOfChar =word.indexOf('v');
        System.out.println(indexOfChar);
        Function<Character,Integer>indexOfCh =s->word.indexOf(s);
        System.out.println(indexOfCh.apply('v'));
        Function<Character,Integer>indexOfCh1 =word::indexOf;
        System.out.println(indexOfCh1.apply('a'));
        Function<Integer,Double> converter=x->x.doubleValue();
        Function<Integer,Double> converter2=Integer::doubleValue;
        System.out.println(converter2.apply(34));
    }
}
