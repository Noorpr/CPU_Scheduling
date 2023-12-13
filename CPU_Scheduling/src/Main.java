import java.util.*;
import javafx.util.*;
public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int numOfProcesses, contextSwitching, qt;
		int BurstTime, arrivalTime, priorityNum;
		String ProcessName;

		// process name , brust time
//		ArrayList<Pair<String, Integer>> processes = new ArrayList<Pair<String, Integer>>();

		// Array of processes used in constructors of algorithms
		ArrayList<Process> processes = new ArrayList<Process>();

		// for the loop
		Process process;


		System.out.print("Please Enter the number of processes: ");
		numOfProcesses = scanner.nextInt();
		System.out.print("Please Enter the Round Robin Time Quantum Time: ");
		qt = scanner.nextInt();
		System.out.print("Please Enter the Context Switching: ");
		contextSwitching = scanner.nextInt();

		for (int i = 0; i < numOfProcesses; i++) {

			System.out.print("Please Enter the " + (i + 1) + " process name: ");
			ProcessName = scanner.next();

			System.out.print("Please Enter the " + (i + 1) + " process arrival time: ");
			arrivalTime = scanner.nextInt();

			System.out.print("Please Enter the " + (i + 1) + " process burst time: ");
			BurstTime = scanner.nextInt();

			System.out.print("Please Enter the " + (i + 1) + " process priority number: ");
			priorityNum = scanner.nextInt();

			process = new Process(ProcessName, arrivalTime, BurstTime, priorityNum);

			processes.add(process);
		}


		while(true){
			System.out.println("\nChoice an algorithm to implement\n" +
					"1- SJF\n" +
					"2- SRTF\n" +
					"3- Priority\n" +
					"4- AG\n" +
					"5- Exit");
			System.out.print("Please Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {

				case 1:
					SJF Scheduler = new SJF(processes);

					System.out.println("\n----Implementing SJF----");
					System.out.println("Process Execution Order:");
					Scheduler.getProcessExecutionOrder();
					System.out.println();
					System.out.println("Waiting Time For Each Process:");
					Scheduler.getWaitingTimeForEachProcess();
					System.out.println();
					System.out.println("TurnAround Time For Each Process:");
					Scheduler.getTurnAroundTimeForEachProcess();
					System.out.println("\nAverage waiting time: " + Scheduler.getAverageWaitingTime());
					System.out.println("Average turnaround time: " + Scheduler.getAverageTurnAroundTime());
					break;

				case 2:
					// SRTF
					System.out.println("\n----Implementing SRTF----");
					break;

				case 3:
					// Priority
					System.out.println("\n----Implementing Priority----");
					break;
				case 4:
					// AG
					System.out.println("\n----Implementing AG----");
					AG ag = new AG(processes, contextSwitching, qt);

					break;

				default:
					System.exit(0);

			}

		}
	}

}
