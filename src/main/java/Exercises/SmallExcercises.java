package Exercises;

import Exercises.Helper.*;

import java.util.*;
import java.util.function.LongConsumer;
import java.util.stream.Collectors;

public class SmallExcercises {
    public static void main(String[] args) {
        //evenNumberSum(numberList());
        //sumOfNumberDivisibleWithTwoNumbers(2, 3, numberList());
        //sortNumbers(numberList1());
        //isPersonEligibleForVoting(generatePersonList());
//        String text;
////        Scanner console = new Scanner(System.in);
////        text= console.nextLine();
//        text = "acesta etse nu text";
//        List<String> badWords = Arrays.asList("etse", "nu", "acetsa", "extt");
//        findBadWordsFromText(text, badWords);
        //transactionsSumByAccount(generateTransactions());
        numberOfEmployeeWithMoreThenSalary(generateDepartments(), 2600);

    }

    public static List<Department> generateDepartments() {
        List<Employee> employees1 = new ArrayList<>();
        employees1.add(new Employee("D1E1", 1000));
        employees1.add(new Employee("D1E2", 2000));
        employees1.add(new Employee("D1E2", 3000));
        employees1.add(new Employee("D1E3", 5000));
        employees1.add(new Employee("D1E4", 6000));
        employees1.add(new Employee("D1E5", 4000));
        employees1.add(new Employee("D1E6", 2000));
        List<Employee> employees2 = new ArrayList<>();
        employees2.add(new Employee("D2E1", 1500));
        employees2.add(new Employee("D2E2", 2500));
        employees2.add(new Employee("D2E2", 3500));
        employees2.add(new Employee("D2E3", 5500));
        employees2.add(new Employee("D2E4", 6500));
        employees2.add(new Employee("D2E5", 4500));
        employees2.add(new Employee("D2E6", 2500));
        List<Department> departments = new ArrayList<>();
        Department department1 = new Department("D1", "C1", employees1);
        Department department2 = new Department("D2", "C1", employees2);
        departments.add(department1);
        departments.add(department2);


        return departments;
    }

    public static List<Transaction> generateTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        Account account1 = new Account("Account1", 100);
        transactions.add(new Transaction(1, 1, account1));
        transactions.add(new Transaction(2, 1, account1));
        transactions.add(new Transaction(3, 1, account1));
        transactions.add(new Transaction(4, 1, account1));
        transactions.add(new Transaction(5, 1, account1));
        Account account2 = new Account("Account2", 100);
        transactions.add(new Transaction(1, 2, account2));
        transactions.add(new Transaction(2, 2, account2));
        transactions.add(new Transaction(3, 2, account2));
        transactions.add(new Transaction(4, 2, account2));
        transactions.add(new Transaction(5, 2, account2));
        return transactions;
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

    public static List<Person> generatePersonList() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Person1", 17, "C01"));
        persons.add(new Person("Person2", 18, "C02"));
        persons.add(new Person("Person3", 21, "C03"));
        persons.add(new Person("Person4", 20, "C04"));
        persons.add(new Person("Person5", 15, "C02"));
        return persons;
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

    public static List<Person> isPersonEligibleForVoting(List<Person> personList) {

/*
        4. Filtreaza persoanele care pot vota
        O persoana este caracterizata de nume si varsta.
        Scrie o metoda statica numita isPersonEligibleForVoting(), care accepta ca parametru o lista de persoane si returneaza o lista cu persoanele care pot vota.

        Scrie apoi metoda si fara expresii lambda.
*/
        System.out.println(personList);
        List<Person> personsThatCanVote = new ArrayList<>();
        personsThatCanVote = personList.stream()
                .filter(x -> x.getAge() >= 18)
                .collect(Collectors.toList());
        System.out.println("1. " + personsThatCanVote);
        personsThatCanVote.clear();
        System.out.println(personsThatCanVote);
        for (Person person : personList) {

            if (person.getAge() >= 18) {
                personsThatCanVote.add(person);
            }
        }

        System.out.println("2. " + personsThatCanVote);
        return personsThatCanVote;
    }

    public static List<String> findBadWordsFromText(String text, List<String> badWords) {
        List<String> badWordsFound = new ArrayList<>();
/*
       5. Spell checker 2
       Avand intr-un main un String, in care se stocheaza un text si o lista de cuvinte gresite, scrie o functie care accepta acesti 2 parametrii si returneaza lista cu cuvintele gresite care se regasesc in text
       Ex: Input: String text = “acesta etse nu text”
       List<String> badWords = [“etse”, “nu”, “acetsa”, “extt”]
       Output: [“etse”, “nu”], pentru ca acestea sunt cuvintele din badWords care se regasesc in text
       (HINT: stream pe lista badWords, apoi filtram doar cuvintele care sunt continute in text (folosind metoda contains()) )

       Rezolva problema si fara expresii lambda
*/

        String[] strings = text.split(" ");
        System.out.println(badWords);
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + " ");
            for (int j = 0; j < badWords.size(); j++) {
                if (strings[i].equals(badWords.get(j))) {
                    badWordsFound.add(badWords.get(j));
                }
            }
        }
        System.out.println();
        System.out.println("1. " + badWordsFound);
        badWordsFound.clear();
        System.out.println(badWordsFound);

        badWordsFound = Arrays.stream(strings)
                .filter(x -> badWords.stream().anyMatch(y -> x.equals(y)))
                .collect(Collectors.toList());

        System.out.println("2. " + badWordsFound);
        return badWordsFound;

    }

    public static void transactionsSumByAccount(List<Transaction> transactions) {

   /*     6. Gestiunea tranzactiilor
        O tranzactie este caracterizata de id, amount si de contul din care s-a facut tranzactia
        (HINT: atribute: id, sum, account - care este de tip Account)
        Un cont este caracterizat de balance (sold) si un account number (numar de cont)
        (HINT - aceasta este clasa Account).

        Avand o lista de tranzactii intr-un main, scrie o metoda care primeste aceasta lista de tranzactii si genereaza o mapa in care cheia sa fie numarul de cont, iar valoarea sa fie suma amount-urilor tututor tranzactiilor care au avut loc din acel cont.
        (HINT) - Collectors.summingLong.

                Rezolva apoi problema si fara expresii lambda.
*/


        Map<String, Integer> sumOfTransactionsByAccount = transactions.stream()
                .collect(Collectors.groupingBy(key -> key.getAccountFrom().getName(), Collectors.summingInt(value -> value.getAmount())));
        System.out.println("1. " + sumOfTransactionsByAccount);

        sumOfTransactionsByAccount.clear();
        System.out.println(sumOfTransactionsByAccount);

        for (int i = 0; i < transactions.size(); i++) {
            String transactionAccountName = transactions.get(i).getAccountFrom().getName();
            Integer transactionAmount = transactions.get(i).getAmount();
            if (!sumOfTransactionsByAccount.containsKey(transactionAccountName)) {
                sumOfTransactionsByAccount.put(transactionAccountName, transactionAmount);
            } else {
                sumOfTransactionsByAccount.put(transactionAccountName,
                        sumOfTransactionsByAccount.get(transactionAccountName) + transactionAmount);
            }
        }

        System.out.println("2. " + sumOfTransactionsByAccount);

    }

    public static void numberOfEmployeeWithMoreThenSalary(List<Department> departments, Integer minSalary) {
        System.out.println(minSalary);
        System.out.println(departments);
        System.out.println();
        Long numberOfEmployeeWithTheSalaryMoreThen = departments.stream().

                flatMap(x -> x.getEmployees().stream()).
                //peek(x -> System.out.println(x)).
                        filter(x -> x.getSalary() > minSalary).
                //peek(x -> System.out.println(x)).
                        count();
        System.out.println(numberOfEmployeeWithTheSalaryMoreThen);
        Integer numberOfEmployeeWithTheSalaryMoreThen1  = 0;
        for (int i = 0; i < departments.size(); i++) {
            for (int j = 0; j < departments.get(i).getEmployees().size(); j++) {
                Integer employeeSalary=departments.get(i).getEmployees().get(j).getSalary();
                if(employeeSalary>minSalary){
                    numberOfEmployeeWithTheSalaryMoreThen1++;
                }
            }

        }


        System.out.println(numberOfEmployeeWithTheSalaryMoreThen1);

    }

}



