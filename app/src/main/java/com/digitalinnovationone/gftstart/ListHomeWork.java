package com.digitalinnovationone.gftstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        List<Double> temperatureList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            System.out.print("Digite a temperatura do mês: ");
            try {
                temperatureList.add(Double.parseDouble(in.readLine()));
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor válido. Ex.: 24.5");
                --i;
            } catch (IOException e) {
                System.out.println("Falha na leitura do terminal");
                System.out.println(e.getMessage());
            }
        }

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