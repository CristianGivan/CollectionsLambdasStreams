package Exercises;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AlgorithmsCollections {
    public static void main(String[] args) {
        //findingMaxProfit();
        //multiplyOtherElements();
        //isDuplicate();
        //findMessingConsecutiveElement();
        //orderConsecutiveDuplicate();
        //maximDifferenceSmallerNumberFirs();
        //findNearestNumber();
        //moveZeroAtTheEnd();
        //subArraySum();
        rotateToRight();
    }

    public static void findingMaxProfit() {
    /*
    Afla profitul maxim pe care il poti face cumparand si vanzand actiuni.
    Ca si input ai un array cu preturile unei actiuni in fiecare zi. Va trebui sa determini in ce zi trebuie sa cumperi
    si in ce zi trebuie sa vinzi ca sa obtii profitul maxim
    Exemplu:
    Input: [100, 180, 260, 310, 40, 535, 695]
    Output: Cumpara in ziua 5 (la pretul de 40) si vinde in ziua 7 (la pretul de 695), adica profit maxim 695-40=655
    Input2: [2, 3, 10, 6, 4, 8, 1]
    Output: Cumpara in ziau 0 (la pretul de 2) si vinde in ziua 2 (la pretul de 10), adica profit maxim 10-2=8

*/
        //todo stream

        List<Integer> price = Arrays.asList(100, 180, 260, 310, 40, 535, 695);
        //List<Integer>price=Arrays.asList(2,3,10,6,4,8,1);
        int maxProfit = 0;
        for (int i = 0; i < price.size() - 1; i++) {
            for (int j = i; j < price.size(); j++) {
                if (price.get(j) - price.get(i) > maxProfit) {
                    maxProfit = price.get(j) - price.get(i);
                }
            }
        }
        System.out.println(maxProfit);
    }

    public static void multiplyOtherElements() {
/*
    2. Inlocuieste fiecare element dintr-un array cu produsul tuturor celorlalte elemente
    Exemplu:
    Input: { 1, 2, 3, 4, 5 }
    Output: { 120, 60, 40, 30, 24 }
    (hint: foloseste un alt array in care sa pui rezultatul)
*/
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> multiplyOtherElementsFromLis = new ArrayList<>();
        Integer multiply = 1;
        for (int i = 0; i < testList.size(); i++) {
            for (int j = 0; j < testList.size(); j++) {
                if (i != j) {
                    multiply *= testList.get(j);
                }
            }
            multiplyOtherElementsFromLis.add(multiply);
            multiply = 1;
        }
        System.out.println(multiplyOtherElementsFromLis);
    }

    public static boolean isDuplicate() {

/*
        3.Sa se verifice daca un array contine duplicate
        Exemplu:
        Input: [6,5,6,2,3,1]
        Output: true, pentru ca 6 apare de doua ori

        (hint: construieste o mapa care sa numere de cate ori apare fiecare element din lista)
*/
        int[] arrayToCheck = {6, 5, 6, 2, 3, 1};
        Map<Integer, Integer> duplicatesCountedOfNumbers = new HashMap<>();
        for (int i = 0; i < arrayToCheck.length; i++) {
            if (!duplicatesCountedOfNumbers.containsKey(arrayToCheck[i])) {
                duplicatesCountedOfNumbers.put(arrayToCheck[i], 0);
            } else {
                Integer newVale = duplicatesCountedOfNumbers.get(arrayToCheck[i]) + 1;
                System.out.println(newVale);
                duplicatesCountedOfNumbers.replace(arrayToCheck[i], newVale);
            }

        }
        System.out.println(duplicatesCountedOfNumbers);

        for (int i = 0; i < arrayToCheck.length; i++) {
            for (int j = 0; j < arrayToCheck.length; j++) {
                if (i != j & arrayToCheck[i] == arrayToCheck[j]) {
                    System.out.println(true);
                    return true;
                }

            }
        }


        System.out.println(false);
        return false;

    }

    public static void findMessingConsecutiveElement() {
        /*
        4. Sunt afisate n-1 numere dintr-un interval de la 1 la n. Sa se gaseasca numarul care lipseste.
        Exemplu:
        Input: n=7, a=[3,2,1,6,5,7]
        Output: 4 - lipseste doar 4 din array.
*/

        int n = 7;
        int[] a = {3, 2, 1, 6, 5, 7};
        Map<Integer, Long> foundExistingNumbers = new HashMap<>();
        List<Integer> notExistingInArray = new ArrayList<>();
        //Arrays.stream(a).forEach(x -> System.out.println(x));
        for (int i = 1; i < n; i++) {
            //todo de ce a trebuit sa adaug acest finalI
            int finalI = i;
            long countNumber = Arrays.stream(a).
                    filter(x -> x == finalI).
                    count();
            // creating a map with the number of elements in array
            Long put = foundExistingNumbers.put(i, countNumber);
            //create a list with the number that don't exist in array
            if (Arrays.stream(a).noneMatch(x -> x == finalI)) {
                notExistingInArray.add(i);
            }
        }
        System.out.println(foundExistingNumbers);
        System.out.println(notExistingInArray);
        List<Integer> notExistingInArray1 = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (i == a[j]) {
                    count++;
                }
            }
            if (count == 0) {
                notExistingInArray1.add(i);
            }
        }
        System.out.println(notExistingInArray1);
        List<Integer> notExistingInArray2 = new ArrayList<>();
        List<Integer> sortedArray = Arrays.stream(a).boxed()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedArray);
        for (int i = 1; i < sortedArray.size(); i++) {
            if (sortedArray.get(i) != sortedArray.get(i - 1) + 1) {
                notExistingInArray2.add(sortedArray.get(i - 1) + 1);
            }
        }
        System.out.println(notExistingInArray2);
    }

    public static void orderConsecutiveDuplicate() {
/*

        5. Grupeaza elementele dintr-un array astfel incat elementele duplicate sa fie unul langa altul
        Exemplu:
        Input: { 1, 2, 3, 1, 2, 1 }
        Output: { 1, 1, 1, 2, 2, 3 }

        (hint: construieste o mapa in care cheia este elementul, iar valoarea de cate ori apare. Apoi construieste rezultatul parcurgand mapa si adaugand elementele unul dupa altul intr-un nou array, in functie de mumarul de aparitii al fiecarui element)
*/
        //todo cum s-a facut acest exercitiu
        //todo si cu mapa
        //iau primul element si vad daca mai exista daca da ai ladaug si pe acesta intr-o lista noua si il sterg din lista veche si repet asta pana ce nu mai exista dupa care
        // trec la urmatorul elemnt din lista veche
        // creez o noua lista in care numar cate elemente sunt de tipul acela si le trec intr-o noua lista dupa care trec la un alt element care nu este in lista noua creata si numar elementele
        // le ordonez.
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numbersOrdered = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        numbers.add(1);
        System.out.println(numbers);
        numbersOrdered = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(numbersOrdered);
    }

    public static void maximDifferenceSmallerNumberFirs() {
/*

        7. Gaseste diferenta maxima intre 2 numere dintr-o lista, astfel incat elementul mai mic sa apara inaintea elementului mai mare
        Exemplu: Input: [2,7,9,5,1,3,5]
        Output: 7 (perechea de numere care indeplineste conditia este (2,9)
*/

        Integer[] numbers = {2, 7, 9, 5, 1, 3, 5};
        Stream<Integer> intStream = Arrays.stream(numbers);

        //ieu primul element si fac diferenta cu toate celelate numere mai mari ca el pun intru maxim rezultatul
        // ieu al doilea numa si fac la fel daca gasesc o diferenta mai mare o trec in acumulator
        //afises acumulatorul
        /*V2
         * gasesc minimul si maximul daca minimul este dupa maxim ma opresc
         * daca minimul este dupa maxim
         * */
        int maximumDifferance = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length - 1; j++) {
                if (numbers[j + 1] - numbers[i] > maximumDifferance) {
                    maximumDifferance = numbers[j + 1] - numbers[i];
                }
                // System.out.println(maximumDifferance);
            }
        }
        System.out.println(maximumDifferance);
        int maximumDifferance1 = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            Optional<Integer> maxNumberAfterI = Arrays.stream(numbers)
                    .skip(i)
                    .max(Integer::compare);
            int maxDif = maxNumberAfterI.orElse(0) - numbers[i];
            if (maxDif > maximumDifferance1) {
                maximumDifferance1 = maxDif;
            }
        }
        System.out.println(maximumDifferance1);
    }

    public static void findNearestNumber() {
         /* 8. Gaseste cea mai apropiata valoare de un anumit numar dintr-o lista de numere
    Exemplu: Input: [2,7,9,5,1,3,5], 8
    Output: 9 sau 7 sunt cele mai apropiate valori de 8*/

        int[] numbers = {2, 7, 9, 5, 1, 3, 5};
        int number = 8;
        double aboveNumber = Double.MAX_VALUE;
        double belowNumber = Double.MIN_VALUE;
        List<Integer> numbersClosest = new ArrayList<>();
        /*v1
         * sortez numerele
         * verific primul numer mai mare ca numarul selectat
         * fac diferenta dintre acel numar si numarul mai mic din lista si vad care ii mai aproape*/
        /*v2
         * fac diferenta fiecarui numar cu numarul selecta si aflu cea mai mica diferenta*/
        /*v3
         * filtrez numerele mai mari decat numarul selectat si  si aflu minimuldin sirul acela
         * filtrez numerele mai mici si aflu maximul sirului
         * verific daca diferenta idnte cele doua numere fata de numarul catutat este egala atunci le pun pe ambele daca nu o sa il pun cel cu diferenta mai mica */

        for (int i = 0; i < numbers.length; i++) {
            if (number == numbers[i]) {
                numbersClosest.add(number);
                break;
            }
            if (belowNumber < numbers[i] - number) {
                belowNumber = number - numbers[i];
            }
            if ((aboveNumber > numbers[i] - number) && (numbers[i] - number > 0)) {
                aboveNumber = numbers[i] - number;
            }
        }
        if (!numbersClosest.contains(number) & belowNumber * -1 == aboveNumber) {
            numbersClosest.add(number + (int) belowNumber);
            numbersClosest.add(number - (int) belowNumber);

        }
        System.out.println(numbersClosest);
        numbersClosest.clear();
        System.out.println(numbersClosest);
        //System.out.println("min: "+belowNumber+" max: "+aboveNumber);

        Integer[] numbers1 = {2, 7, 9, 5, 1, 3, 5};
        Integer number1 = number;
        List<Integer> numberList = convertArrayToList(numbers1);
        Optional<Integer> aboveNr = numberList.stream().filter(x -> x >= number1).min(Integer::compareTo);
        Optional<Integer> belowNr = numberList.stream().filter(x -> x <= number1).max((x,y)->x.compareTo(y));
        System.out.println(aboveNr);
        System.out.println(belowNr);


        if (numberList.stream().anyMatch(x -> x == number)) {
            numbersClosest.add(number);
        } else if (aboveNr.orElse(Integer.MAX_VALUE) - number == number - belowNr.orElse(Integer.MIN_VALUE)) {
            numbersClosest.add(aboveNr.orElse(Integer.MAX_VALUE));
            numbersClosest.add(belowNr.orElse(Integer.MIN_VALUE));
        }

        System.out.println(numbersClosest);
    }

    public static void moveZeroAtTheEnd() {
/*

        9. Muta toate zero-urile dintr-un array la final
        Exemplu: Input: [6,0,8,2,3,0,4,0,1]
        Output: [6,8,2,3,4,1,0,0,0]

*/
        /*v01
        * verific fiecare element daca am identificat unu il mut siftez foate elementele iar la sfarsit pun un zero*/
        /*v2
        * numar cati de 0 sunt
        * elimin toti 0
        * adaug la sfarzit cati de 0 am numarat*/
    Integer[] input ={6,0,8,2,3,0,4,0,1};
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
        for (int i = 0; i < input.length; i++) {
            if (input[i]==0){
                for (int j = i+1; j < input.length; j++) {
                    input[j-1]=input[j];
                }
                input[input.length-1]=0;
            }
        }
        System.out.println("--------------");
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }

        List<Integer> integerList= Arrays.stream(input).collect(Collectors.toList());
        Long numberOfZero=integerList.stream().filter(x->x==0).count();
        List<Integer>listWithoutZero=integerList.stream().filter(x->x!=0).collect(Collectors.toList());
        List<Integer>listWithZero=listWithoutZero;
        for (int i = 0; i < numberOfZero; i++) {
            listWithZero.add(0);

        }
        System.out.println(listWithZero);
/*todo de ce nu merge;

        List<Integer>newList=integerList;
        System.out.println(newList);
        for (Integer i:integerList){
            if (i==0){
                newList.remove(i);
                newList.add(0);
            }
        }
        System.out.println(newList);
*/

        System.out.println();

    }

    public static void subArraySum(){
/*

        10. Gaseste un subarray dintr-un array,  care sa aiba o anumita suma
        Un subarray are capatul din stanga inaintea capatului din dreapta in array-ul original.
                Array-ul original poate avea doar numere pozitive
        Exemplu: Input: [1,4,20,3,10,5], sum=33
        Ouput:suma a fost gasita intre indicii 2 si 4 (20+3+10=33)
        Input: [1,4], sum = 0
        Output: niciun subarray nu a fost gasit
*/
    Integer[] array={1,4,20,3,10};
    Integer sumToCheck=33;
    Integer minIndex=0;
    Integer maxIndex = 0;
    Integer sum;


        for (int i = 0; i < array.length; i++) {
            int sumIndex=i;
            sum=0;
            while (sum<sumToCheck&&sumIndex<array.length){
                sum+=array[sumIndex];
                sumIndex++;
            }
            if (sum==sumToCheck){
                minIndex=i;
                maxIndex=sumIndex-1;
                break;
            }
        }
        System.out.println(minIndex);
        System.out.println(maxIndex);
    }

    public static void rotateToRight(){
/*

        11. Roteste un array la stanga cu o pozitie
        Exemplu: Input: [1,2,3,4,5]
        Output: [5,1,2,3,4]

        Rezolva apoi problema in mod general, adica roteste un array la stanga cu n pozitii
        Exemplu: Input: [1,2,3,4,5] , n=2
        Output: [3,4,5,1,2] - array-ul s-a rotit cu 2 pozitii
*/
        Integer[] array={1,2,3,4,5};
        List<Integer> list=convertArrayToList(array);
        int numberOfRotations=3;
        List<Integer> result=new ArrayList<>();
        /*v1
        * pentru n ori ieu size*/

        for (int i = numberOfRotations; i >=1; i--) {
            result.add(list.get(list.size()-i));
        }
        for (int i = 0; i < list.size()-numberOfRotations; i++) {
         result.add(list.get(i));
        }
        System.out.println(result);

    }
    public static <T> List<T> convertArrayToList(T[] array) {
        List<T> list = new ArrayList<>();
        for (T t : array) {
            list.add(t);
        }
        return list;
    }

}
