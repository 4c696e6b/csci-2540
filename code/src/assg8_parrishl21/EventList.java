/**
 * defines the EventList object, it is just a list of Events that is sorted after each change
 * @author Link Parrish
 */
package assg8_parrishl21;

import java.util.*;

public class EventList {
	
	private ArrayList<Event> eventList;
	
	/**
	 * default constructor
	 */
	public EventList() {
		eventList = new ArrayList<Event>();
	}
	
	/**
	 * adds an event to the list and sorts it
	 * @param e the event to add
	 */
	public void addEvent(Event e) {
		eventList.add(e);
		Collections.sort(eventList);
	}
	
	/**
	 * removes an event from the list and sorts it
	 * @param i the index of the event to remove
	 */
	public void removeEvent(int i) {
		eventList.remove(i);
		Collections.sort(eventList);
	}
	
	/**
	 * gets an event from the list
	 * @param i the index of the event to get
	 * @return the event at index i
	 */
	public Event getEvent(int i) {
		return eventList.get(i);
	}
	
	/**
	 * checks if the list is empty
	 * @return true if the list is empty, otherwise false
	 */
	public boolean isEmpty() {
		return eventList.isEmpty();
	}
}
