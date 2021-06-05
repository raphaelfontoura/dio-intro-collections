package com.digitalinnovationone.gftstart;

import java.util.ArrayList;
import java.util.Arrays;
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

        try (Scanner scan = new Scanner(System.in)) {
            for (int i = 1; i <= 6; i++) {
                System.out.printf("Digite a temperatura do mês %d: ", i);
                temperatureList.add(input.nextDouble());
            }

            Double mean = sumList(temperatureList) / temperatureList.size();

            System.out.printf("A temperatura média do semestre foi: %.2f. \n", mean);
            System.out.println("Meses com temperatura acima da média: ");
            var result = getMonths(temperatureList, mean);
            result.forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("Erro ao processar a entrada da temperatura");
            System.out.println(e);
        }

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