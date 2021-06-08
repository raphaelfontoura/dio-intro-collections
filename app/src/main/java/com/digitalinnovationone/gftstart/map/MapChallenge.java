package com.digitalinnovationone.gftstart.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class MapChallenge {

    public static void main(String[] args) {
        
        Map<Integer, Integer> dado = new HashMap<>(){{
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(6, 0);
        }};

        Random random = new Random();
        
        for (int i = 0; i < 100; i++) {
            var sorted = random.ints(1, 7).findFirst().getAsInt();
            if (dado.containsKey(sorted)) {
                dado.put(sorted, dado.get(sorted) + 1);
            } 
        }

        System.out.println(dado);
        var sum = dado.values().stream().collect(Collectors.summingInt(Integer::intValue));

        System.out.println("Número de vezes que o dado foi jogado: " + sum);
        
    }
}
