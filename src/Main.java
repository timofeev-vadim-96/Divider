//Дано целое число N из отрезка [1; 1000]. Также даны N целых чисел Ai из отрезка [1; 1000000].
//        Требуется для каждого числа Ai вывести количество различных делителей этого числа.
//        В этой задаче несколько верных решений, попробуйте найти наиболее оптимальное.
//        Для полученного решения укажите сложность в О-нотации.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        calculateDividers(5);
    }

    //Поиск количества делителей каждого из заданного количества рандомных чисел. Сложность O(n*sqrt(n))
    public static void calculateDividers(int quantityNumbs) { //O(n) * O(n) = O(n^2)
        Random random = new Random();
        int tempNumber;
        for (int i = 0; i < quantityNumbs; i++) {
            tempNumber = random.nextInt(1, 1000001);
            ArrayList<Integer> dividers = (ArrayList<Integer>) findDividersOptimize(tempNumber);
            int dividersTotalQuantity = dividers.size();
            System.out.printf("Number %d. Total dividers quantity = %d.\n", tempNumber, dividersTotalQuantity);
        }
    }

    //Классическое решение. Ищем все делители числа. Сложность O(n).
    public static List<Integer> findDividers(int number) {
        List<Integer> dividers = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) dividers.add(i);
        }
        return dividers;
    }

    //    Оптимизированный поиск всех делителей числа. Сложность O(sqrt(n))
    public static List<Integer> findDividersOptimize(int number) {
        List<Integer> dividers = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                if (i * i == number) dividers.add(i); //случай, если мы нашли корень числа. Пары ему нет, поэтому
//                добавляем только его
                else {
                    dividers.add(i);
                    dividers.add(number / i);
                }
            }
        }
        return dividers;
    }
}