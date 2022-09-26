package Exercises;

import java.util.*;

public class AlgorithmsCollections {
    public static void main(String[] args) {
        //findingMaxProfit();
        //multiplyOtherElements();
        //isDuplicate();

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
            if (!duplicatesCountedOfNumbers.containsKey(arrayToCheck[i])){
                duplicatesCountedOfNumbers.put(arrayToCheck[i],0 );
            }
            else {
                Integer newVale = duplicatesCountedOfNumbers.get(arrayToCheck[i])+1;
                System.out.println(newVale);
                duplicatesCountedOfNumbers.replace(arrayToCheck[i],newVale );
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

}
