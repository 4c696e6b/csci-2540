/**
 * simulates a line and calculates the average waiting time in the line
 * @author Link Parrish
 */
package assg8_parrishl21;

import java.util.*;
import java.io.*;

public class Simulation {

	public static void main(String[] args) {
		
		Queue<Event> eventQueue = new LinkedList<Event>();
		EventList eventList = new EventList();
		Scanner in = null;
		String filename = "assg8_input.txt";
		String line;
		String[] lineArgs;
		Event currentEvent;
		int numOfPeople = 0;
		int totalWaitTime = 0;
		
		// try catch for opening the input file
		try {
			in = new Scanner(new File(filename));
		}
		
		catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(1);
		}
		
		// gets the first line and splits it on the tab character
		line = in.nextLine();
		lineArgs = line.split("\t");
		
		// creates the first event and adds it to the list
		eventList.addEvent(new Event('A', Integer.parseInt(lineArgs[0]), Integer.parseInt(lineArgs[1])));
		numOfPeople++;
		
		System.out.println("Simulation Begin:");
		
		// loop until all events are processed
		while (!eventList.isEmpty()) {
			
			// gets the event to process
			currentEvent = eventList.getEvent(0);
			
			//processes the event if it is an arrival
			if (currentEvent.isArrival()) {
				
				// if we added a new arrival to the list increases the number of people
				if (in.hasNextLine())
					numOfPeople++;
				
				processArrival(currentEvent, in, eventList, eventQueue);
			}
			
			// processes the event if it is a departure
			else
				totalWaitTime += processDeparture(currentEvent, eventList, eventQueue);
		}
		
		// display the final statistics
		System.out.println("\nNumber of People:\t\t" + numOfPeople);
		double averageWaitTime = totalWaitTime / (double)numOfPeople;
		System.out.println("Average Wait Time:\t\t" + averageWaitTime);
		
		in.close();
	}
	
	/**
	 * processes arrival events
	 * @param arrival the current event we are processing
	 * @param in the input file
	 * @param eventList the event list
	 * @param eventQueue the event queue
	 */
	public static void processArrival(Event arrival, Scanner in, EventList eventList, Queue<Event> eventQueue) {
		
		String line;
		String[] lineArgs;
		
		// gets the time of the current arrival event
		int currentTime = arrival.getEventTime();
		
		// stores if the queue is currently empty before we add the current event to it
		boolean empty = eventQueue.isEmpty(); 
		
		// adds the current event from the queue and removes it from the list
		eventQueue.offer(arrival);
		eventList.removeEvent(0);
		
		System.out.println("Processing Arrival at time:\t" + currentTime);
		
		// if the queue was empty add the departure event
		if (empty) {
			
			// since the queue was empty the departure time is just the current time + the transaction time
			currentTime += arrival.getTransactionTime();
			
			eventList.addEvent(new Event('D', currentTime));
		}
		
		// if the queue wasn't empty and there's another arrival event in the input add it to the list
		if (in.hasNextLine()) {
			
			line = in.nextLine();
			lineArgs = line.split("\t");
			
			eventList.addEvent(new Event('A', Integer.parseInt(lineArgs[0]), Integer.parseInt(lineArgs[1])));
		}
	}
	
	/**
	 * processes departure events
	 * @param departure the current event we are processing
	 * @param eventList the event list
	 * @param eventQueue the event queue
	 * @return the amount of time the departure waited before they were served
	 */
	public static int processDeparture(Event departure, EventList eventList, Queue<Event> eventQueue) {
		
		//removes the arrival event from the queue and the corresponding departure event from the list
		Event arrival = eventQueue.remove();
		eventList.removeEvent(0);
		
		// the current time is the time that the departure happens
		int currentTime = departure.getEventTime();
		
		// retroactively calculates the wait time, wait time is: departure time - arrival time - transaction time
		int waitTime = departure.getEventTime() - arrival.getEventTime() - arrival.getTransactionTime();

		System.out.println("Processing Departure at time:\t" + currentTime);
		
		// if the queue isn't empty create the next departure event
		if (!eventQueue.isEmpty()) {
			
			// the next departure time is the current departure time + the next transaction time
			currentTime += eventQueue.peek().getTransactionTime();
			eventList.addEvent(new Event('D', currentTime));
		}
		
		return waitTime;
	}
}
