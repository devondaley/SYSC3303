package src.main.elevator;

import src.main.net.Requester;
import src.main.net.Responder;
import src.main.settings.Settings;

/**
 * Elevator Subsystem that creates and starts required number of elevators in separate threads.
 * 
 * @author Samuel English
 *
 */
public class ElevatorSubsystem {
	private Thread[] elevatorThreads = new Thread[Settings.NUMBER_OF_ELEVATORS];
	
	public ElevatorSubsystem() {
		createElevators();
	}
	
	
	/**
	 * Create an elevator thread for each required from Settings.NUMBER_OF_ELEVATORS
	 */
	private void createElevators() {
		 for (int i = 0; i < elevatorThreads.length; i++) {
			 elevatorThreads[i] = new Thread(new Elevator((i + 1), 0, Settings.NUMBER_OF_FLOORS,  new Requester(), new Responder()));
			 elevatorThreads[i].start();
		 }
	}
	
	
	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args) {
		new ElevatorSubsystem();
	}
}
