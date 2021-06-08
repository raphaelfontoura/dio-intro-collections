package com.digitalinnovationone.gftstart.map;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapHomeWork1 {
    
    private static NumberFormat nf = NumberFormat.getInstance();
    
    public static void main(String[] args) {
        Map<String, Integer> states = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(states);;

        states.put("RN", 3534165);
        System.out.println(states);

        if (! states.containsKey("PB")) {
            states.put("PB", 4039277);
        }
        System.out.println(states);

        System.out.println("População do estado de PE: " + nf.format(states.get("PE")));

        Map<String, Integer> statesLinked = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 4039277);
        }};

        for (Map.Entry<String, Integer> state : statesLinked.entrySet()) {
            System.out.printf("%s - %s \n", state.getKey(), nf.format(state.getValue()));
        }

        System.out.println("Estados em ordem alfabética.");
        Map<String, Integer> statesOrderByLetter = new TreeMap<>(statesLinked);
        for (Map.Entry<String, Integer> state : statesOrderByLetter.entrySet()) {
            System.out.printf("%s - %s \n", state.getKey(), nf.format(state.getValue()));
        }

        var smaller = Collections.min(states.values());
        for (Map.Entry<String, Integer> state : states.entrySet()) {
            if (state.getValue() == smaller) System.out.printf("Menor população: %s - %s \n", state.getKey(), nf.format(state.getValue()));
        }

        var bigger = Collections.max(states.values());
        for (Map.Entry<String, Integer> state : states.entrySet()) {
            if (state.getValue() == bigger) {
                System.out.printf("Maior população: %s - %s \n", state.getKey(), nf.format(state.getValue()));
            }
        }

        var total = states.values().stream().reduce(0, (sum, value) -> sum + value);
        var total2 = states.values().stream().reduce(0, Integer::sum);

        System.out.println("Total de população dos estados: " + nf.format(total2));

        System.out.println("Média de população dos estados: " + total/states.size());


        System.out.println("Retirar estados com população menor que 4.000.000");
        System.out.println(states);
        states.entrySet().removeIf(s -> s.getValue() < 4000000);
        System.out.println(states);

        System.out.println("Dicionário de estados está vazia? " + states.isEmpty());
        states.clear();
        System.out.println("Dicionário de estados está vazia agora? " + states.isEmpty());

    }
}
