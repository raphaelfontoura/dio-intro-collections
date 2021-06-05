package com.digitalinnovationone.gftstart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ListHomeWork
 */
public class ListHomeWork {

    private final static List<String> monthsList = new ArrayList<>(Arrays.asList("Janeiro", "Fevereiro", "Março",
            "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"));

    public static void main(String[] args) {
        List<Double> temperatureList = new ArrayList<>() {
            {
                add(21d);
                add(25d);
                add(28d);
                add(24.3);
                add(27.8);
                add(31d);
            }
        };

        Double mean = calcMeanDouble(temperatureList, 6);

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

    private static Double calcMeanDouble(List<Double> temperatureList, Integer count) {
        Double sum = 0d;
        for (int i = 0; i < count; i++) {
            sum += temperatureList.get(i);
        }
        Double mean = sum / count;
        return mean;
    }

}