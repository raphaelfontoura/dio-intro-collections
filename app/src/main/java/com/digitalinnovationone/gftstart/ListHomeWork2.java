package com.digitalinnovationone.gftstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ListHomeWork2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        List<Boolean> responses = new ArrayList<>();
        System.out.println("Responda as perguntas a seguir com Sim ou S e Não ou N");

        System.out.print("Telefonou para a vítima?");
        responses.add(verifyResponse(in.readLine()));

        System.out.print("Esteve no local do crime?");
        responses.add(verifyResponse(in.readLine()));

        System.out.print("Mora perto da vítima?");
        responses.add(verifyResponse(in.readLine()));

        System.out.print("Devia para a vítima?");
        responses.add(verifyResponse(in.readLine()));

        System.out.println("Já trabalhou com a vítima?");
        responses.add(verifyResponse(in.readLine()));

        switch (classifyPerson(responses)) {
            case 2:
                System.out.println("Suspeita.");
                break;
            case 3, 4:
                System.out.println("Cúmplice.");
                break;
            case 5:
                System.out.println("Assassina.");
                break;
            default:
                System.out.println("Inocente.");
                break;
        }

    }

    private static Boolean verifyResponse(String response) {
        return response.equalsIgnoreCase("sim") || response.equalsIgnoreCase("s") ? true : false;
    }

    private static Integer classifyPerson(List<Boolean> listResponses) {
        var listIterator = listResponses.iterator();
        var totalTrue = 0;
        while (listIterator.hasNext()) {
            if (listIterator.next()) totalTrue++;
        }
        return totalTrue;
    }
}
