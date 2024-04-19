/**
 * defines the Event object, each event has a type, time, and arrival events have a transaction time
 * @author Link Parrish
 */
package assg8_parrishl21;

public class Event implements Comparable<Event> {
	
	private char eventType;
	private int eventTime, transactionTime;
	
	/**
	 * 2 parameter constructor, used for departure events
	 * @param eventType the event type
	 * @param eventTime the time of the event
	 */
	public Event(char eventType, int eventTime) {
		this.eventType = eventType;
		this.eventTime = eventTime;
	}
	
	/**
	 * 3 parameter constructor, used for arrival events
	 * @param eventType the event type
	 * @param eventTime the time of the event
	 * @param transactionTime the amount of time the event takes to complete
	 */
	public Event(char eventType, int eventTime, int transactionTime) {
		this.eventType = eventType;
		this.eventTime = eventTime;
		this.transactionTime = transactionTime;
	}
	
	/**
	 * gets the event type
	 * @return the event type
	 */
	public char getEventType() {
		return this.eventType;
	}
	
	/**
	 * gets the event time
	 * @return the event time
	 */
	public int getEventTime() {
		return this.eventTime;
	}
	
	/**
	 * gets the event transaction time
	 * @return the event transaction time
	 */
	public int getTransactionTime() {
		return this.transactionTime;
	}
	
	/**
	 * compares the events based on event time, if the time is the same arrivals go before departures
	 * @param e = the event to compare to
	 * @return -1 if the event goes before, 0 if its the same, and 1 if it goes after
	 */
	public int compareTo(Event e) {
		if (this.eventTime < e.getEventTime())
			return -1;
		
		else if (this.eventTime > e.getEventTime())
			return 1;
		else {
			if (this.eventType == 'A')
				return -1;
			else if (e.getEventType() == 'A')
				return 1;
			else
				return 0;
		}
	}
	
	/**
	 * returns a string with the event information doesn't display the transaction time if the event is a departure
	 * @return the string with the event info
	 */
	public String toString() {
		if (eventType == 'A')
			return "Arrival, " + eventTime + ", " + transactionTime;
		else
			return "Departure, " + eventTime; 
	}
	
	/**
	 * checks if an event is an arrival
	 * @return true if the event is an arrival, otherwise false
	 */
	public boolean isArrival() {
		if (eventType == 'A')
			return true;
		else
			return false;
	}
	
	/**
	 * checks if an event is a departure
	 * @return true if the event is a departure, otherwise false
	 */
	public boolean isDeparture() {
		if (eventType == 'D')
			return true;
		else
			return false;
	}
}
