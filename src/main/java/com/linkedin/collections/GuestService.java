package com.linkedin.collections;

import java.util.ArrayList;
import java.util.List;

public class GuestService {

	private final List<Guest> checkInList = new ArrayList<>(100);


	public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {
		/*
		 *  1. Returns a new collection that contains guests from the provided collection
		 *  who have indicated the provided room as the first preference in their preferred
		 *  room list.
		 */
		List<Guest> guestsFilteredByFavRoom = new ArrayList<>();
		for (Guest guest : guests) {
			if (guest.getPreferredRooms().size()>0&&guest.getPreferredRooms().get(0).equals(room)) {
				guestsFilteredByFavRoom.add(guest);
			}

		}

		return guestsFilteredByFavRoom;

	}

	public void checkIn(Guest guest) {

		/*
		 *  2. Adds a guest to the checkiInList, placing members of the loyalty program
		 *  ahead of those guests not in the program. Otherwise, guests are arranged in the
		 *  order they were inserted.
		 */
		if (guest.isLoyaltyProgramMember() && !checkInList.isEmpty()) {
			int i = 0;
			for (; i < this.checkInList.size(); i++) {
				if (checkInList.get(i).isLoyaltyProgramMember()) {
					continue;
				}
				break;
			}
			this.checkInList.add(i, guest);
		} else {
			this.checkInList.add(guest);
		}

	}


	public void swapPosition(Guest guest1, Guest guest2) {

		/*
		 *  3.  Swaps the position of the two provided guests within the checkinList.
		 *  If guests are not currently in the list no action is required.
		 */

		int guest1Index = this.checkInList.indexOf(guest1);
		int guest2Index = this.checkInList.indexOf(guest2);
		if (guest1Index != -1 && guest2Index != -1) {
			checkInList.set(guest1Index, guest2);
			checkInList.set(guest2Index, guest1);
		}


//		for(int i=0; i<this.checkInList.size(); i++){
//
//
//			if(this.checkInList.contains(guest1)&&this.checkInList.contains(guest2)){
//				Guest fakeGuest = new Guest();
//				this.checkInList.add(fakeGuest);
//				int swapPurposesIndex=this.checkInList.indexOf(fakeGuest);
//				int guest1Index = this.checkInList.indexOf(guest1);
//				int guest2Index = this.checkInList.indexOf(guest2);
//				checkInList.set(swapPurposesIndex, guest1);
//				checkInList.set(guest1Index, guest2);
//				checkInList.set(guest2Index, guest1);
//			}
//		}

	}

	public List<Guest> getCheckInList() {
		return List.copyOf(this.checkInList);
	}
}
