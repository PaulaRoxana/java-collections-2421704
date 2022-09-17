package com.linkedin.collections;



import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Guest john = new Guest("John", "Doe", false);
        Guest maria = new Guest("Maria", "Doe", false);
        Guest sonia = new Guest("Sonia", "Doe", true);
        Guest siri = new Guest("Siri", "Doe", true);

//declaring the ArrayList with a larger initial capacity,
// as by default it has an initial capacity of 10, and we want to avoid resizing;
        List<Guest> checkInList = new ArrayList<>(100);
        checkInList.add(john);
        checkInList.add(maria);
        print(checkInList);

        checkInList.add(0, sonia);
        System.out.println(checkInList);
        checkInList.get(2).setLoyaltyProgramMember(true);
        checkInList.addAll(1, List.of(maria, siri));
        System.out.println(checkInList);
        checkInList.remove(checkInList.size()-1);
        System.out.println(checkInList);
        System.out.println("John is now at non-dev position: " + (checkInList.indexOf(john)+1));


    }
//utility method to print info to the console
    public static void print(List<Guest> guests) {
        System.out.println("%n -- List Contents -- %n");

        for (int i = 0; i < guests.size(); i++) {
            System.out.format("%x: %s %n", i, guests.get(i));

        }
    }


}
