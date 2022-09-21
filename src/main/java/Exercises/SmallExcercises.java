package Exercises;

import java.util.*;

public class SmallExcercises {
    public static void main(String[] args) {
        //evenNumberSum(numberList());
        //sumOfNumberDivisibleWithTwoNumbers(2, 3, numberList());
        //sortNumbers(numberList1());
    }

    public static List<Integer> numberList() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);
        integers.add(11);
        integers.add(12);
        integers.add(13);
        integers.add(14);
        integers.add(15);
        return integers;
    }

    public static List<Integer> numberList1() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(-3);
        integers.add(-2);
        integers.add(-4);
        integers.add(-5);
        integers.add(6);
        integers.add(5);
        integers.add(-8);
        integers.add(9);
        integers.add(10);
        integers.add(-11);
        integers.add(12);
        integers.add(-13);
        integers.add(14);
        integers.add(-15);
        return integers;
    }

    public static void evenNumberSum(List<Integer> numbers) {
/*
        1. Suma numerelor pare
        Calculeaza suma numerelor pare dintr-o lista de Integer-uri.
        (HINT: filter si sum sau reduce)

        Rezolva problema si fara expresii lambda.
*/


        System.out.println(numbers);
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {

            if (numbers.get(i) % 2 == 0) {
                sum += numbers.get(i);
            }
        }
        System.out.println("1. " + sum);

        Optional<Integer> suma = numbers.stream()
                .filter(x -> x % 2 == 0)
                .reduce((x, y) -> x + y);
        System.out.println("2. " + suma.orElse(0));

    }

    public static void sumOfNumberDivisibleWithTwoNumbers(Integer d1, Integer d2, List<Integer> numbers) {
/*

        Scrie o metoda care sa calculeze suma numerelor divizibile cu x sau y (unde x si y sunt primiti ca parametri), dintr-o lista de Integer-uri.
        (HINT: filter si sum sau reduce)

        Rezolva problema si fara expresii lambda.
*/


        System.out.println(numbers);
        Integer sumNumberDevededByD1D2 = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % d1 == 0 | numbers.get(i) % d2 == 0)
                sumNumberDevededByD1D2 += numbers.get(i);
        }
        System.out.println("1. " + sumNumberDevededByD1D2);

        Optional<Integer> sumOfNumberDevidedByD1D2 = numbers.stream()
                .filter(x -> x % d1 == 0 | x % d2 == 0)
                .reduce((sum, number) -> sum + number);

        System.out.println("2. " + sumNumberDevededByD1D2);
    }

    public static void sortNumbers(List<Integer> numbers) {

/*
        Scrie o metoda care sa sorteze numerele dintr-o lista de Integer-uri, dar inainte de asta sa le transforme in valori pozitive
        Ex: Input: [-1,2,-3,4,-5]
        Output:[1,2,3,4,5]
        (HINT: map pentru a transforma fiecare numar din negativ in pozitiv, apoi sorted() ca si operatie finala. Foloseste Math.abs() pentru a transforma un numar din negativ in pozitiv)

        Rezolva problema si fara expresii lambda

        Rezolva problema si fara expresii lambda. (HINT: foloseste metoda sort din arraylist)
*/


        System.out.println(numbers);
        numbers.stream()
                .map(x -> {
                    if (x < 0) {
                        x = x * -1;
                    }
                    return x;
                })
                .sorted()
                .forEach(x -> System.out.println(x));


        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 0) {
                numbers.set(i, numbers.get(i) * -1);
            }
        }
        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);

    }

}



