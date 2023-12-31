package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Characters {
    public static void main(String[] args) {
        String characters = "adhj3sdjabscja42kjdhsyahs169llcoibsnsnj0cuscsc" +
                "soalsn4ncatrqiepancgsla6kuysthesjc,bsklas" +
                "ajsbcgbxmzlaoquenchsgaksndscnjsgawkdlso9y" +
                "piuetwhnsclsnmzh[sjetaydhcbnvldo;'ehapdns" +
                "tqrehckcnaa1gdnmcldo4ehadtdkcl6cnahdncsjd" +
                "hagbstz5fscvcnvk6dmmaozpieytruao8qlnxmsmx" +
                "loikmn*juyhbvgtr]fcxdeswsza]qwsxcderfvbgt";

        Map<Character, Integer> map = new HashMap<>();

        System.out.println(imperative(characters, map));

    }
    public static Map declarative(String characters, Map<Character, Integer> map){
        // Using the Character List, will put every character and initialize the value as 1,
        // then increase the value by 1 if repeats
        convert(characters).stream()
                .filter(Character::isLetter)
                .forEach(character -> {
                    if(map.containsKey(character)){
                        map.put(character, map.get(character) + 1);
                    } else {
                        map.put(character, 1);
                    }
                });

        // Print the map
        return map;
    }
    public static Map imperative(String characters, Map<Character, Integer> map){
        List<Character> list = convert(characters);
        for(int i = 0; i < list.size(); i++){
            if(Character.isLetter(list.get(i))){
                if(!map.containsKey(list.get(i))){
                    map.put(list.get(i), 1);
                } else {
                    map.put(list.get(i), map.get(list.get(i)) + 1);
                }
            }
        }

        return map;
    }

    // Convert String to Character List
    public static List<Character> convert(String characters){

        // Blank List to store the characters
        List<Character> list = new ArrayList<>() ;

        // Adding the characters to the list
        for ( int i = 0 ; i < characters.length(); i++){
            list.add(characters.charAt(i));
        }

        return list ;
    }
}
