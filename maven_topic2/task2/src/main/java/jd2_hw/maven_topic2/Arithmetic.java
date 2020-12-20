package jd2_hw.maven_topic2;

import java.util.List;

/**
 * Класс принимает список целых чисел. И может вернуть среднее арифметическое из метода getResult
 */
public class Arithmetic {

    private List<Integer> list;
    private double result;

    public Arithmetic(List<Integer> list) {
        this.list = list;
    }

    /**
     * Возвращает среднее арифметическое списка
     * @return Число типа double
     */
    public double getResult() {
        for (Integer integer : list) {
            result += integer;
        }
        return result/ list.size();
    }
}
