package com.linkedin.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
		Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
		Room westminister = new Room("Westminister", "Premiere Room", 4, 175.00);
		Room oxford = new Room("Oxford", "Suite", 5, 225.0);
		Room oxford1 = new Room("Oxford", "Guest Room", 5, 225.0);
		Room victoria = new Room("Victoria", "Suite", 5, 225.0);
		Room manchester = new Room("Manchester", "Suite", 5, 225.0);
		
		List<Room> rooms = new ArrayList<>(List.of(piccadilly, oxford1, cambridge, westminister, victoria, oxford, manchester));
		Comparator<Room> priceComparator = Comparator.comparing(Room::getRate).thenComparing(Room::getType).reversed();

		rooms.sort(priceComparator);
		
		rooms.stream()
			.forEach(r -> System.out.format("%s %s %f %n", r.getName(), r.getType(), r.getRate()));
		
	}

}
