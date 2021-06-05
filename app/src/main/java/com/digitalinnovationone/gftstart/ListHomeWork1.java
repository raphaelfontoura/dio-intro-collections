package com.digitalinnovationone.gftstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * ListHomeWork
 */
public class ListHomeWork1 {

    private final static List<String> monthsList = new ArrayList<>(Arrays.asList("Janeiro", "Fevereiro", "Março",
            "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"));

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Double> temperatureList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            System.out.printf("Digite a temperatura do mês %d: ", i);
            temperatureList.add(input.nextDouble());
        }

        Double mean = sumList(temperatureList) / temperatureList.size();

        System.out.printf("A temperatura média do semestre foi: %.2f. \n", mean);
        // Collections.sort(temperatureList, Collections.reverseOrder());
        // System.out.println(temperatureList);
        System.out.println("Meses com maior temperatura: ");
        var result = getMonths(temperatureList, mean);
        result.forEach(System.out::println);

    }

    private static List<String> getMonths(List<Double> temperatureList, Double mean) {
        var listIterator = temperatureList.iterator();
        var resultList = new ArrayList<String>();

        while (listIterator.hasNext()) {
            var actual = listIterator.next();
            var monthIndex = temperatureList.indexOf(actual);
            if (actual > mean) {
                resultList.add((monthIndex + 1) + " - " + monthsList.get(monthIndex));
            }
        }
        return resultList;
    }

    private static Double sumList(List<Double> temperatureList) {
        Double sum = 0d;
        for (int i = 0; i < temperatureList.size(); i++) {
            sum += temperatureList.get(i);
        }
        return sum;
    }

}