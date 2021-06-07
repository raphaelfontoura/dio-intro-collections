package com.digitalinnovationone.gftstart.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * SetHomeWork1
 */
public class SetHomeWork1 {

    public static void main(String[] args) {
        Set<String> arcoIris = new HashSet<>(Arrays.asList("violeta", "anil", "azul", "verde", "amarelo", "laranja", "vermelho"));
        
        for (String cor : arcoIris) {
            System.out.println(cor);
        }

        System.out.println("## Total de cores: " + arcoIris.size());

        System.out.println("## Cores em ordem alfabética");
        Set<String> arcoIrisSorted = new TreeSet<>(arcoIris);
        for (String cor : arcoIrisSorted) {
            System.out.println(cor);
        }

        System.out.println("## Cores em ordem inversa.");
        Set<String> arcoIrisReverse = new TreeSet<>(Comparator.reverseOrder());
        arcoIrisReverse.addAll(arcoIris);
        System.out.println(arcoIrisReverse);

        var iterator = arcoIris.iterator();
        while (iterator.hasNext()){
            var cor = iterator.next();
            if (cor.substring(0, 1).equalsIgnoreCase("v")) {
                System.out.println(cor);
                continue;
            } else {
                iterator.remove();
            }
        }
        System.out.println(arcoIris);
        arcoIris.clear();
        System.out.println(arcoIris.isEmpty());
    }
}