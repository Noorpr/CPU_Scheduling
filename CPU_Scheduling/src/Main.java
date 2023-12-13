import java.util.*;
import javafx.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numOfProcesses;
		ArrayList<Pair<String, Integer>> processes = new ArrayList<Pair<String, Integer>>();
		// ProcessName, Burst time

		System.out.print("Please Enter the number of processes: ");
		numOfProcesses = scanner.nextInt();

		for (int i = 0; i < numOfProcesses; i++) {
			String ProcessName;
			int BurstTime;

			System.out.print("Please Enter the " + (i + 1) + " process name: ");
			ProcessName = scanner.next();

			System.out.print("Please Enter the " + (i + 1) + " process burst time: ");
			BurstTime = scanner.nextInt();

			Pair<String, Integer> temp = new Pair<String, Integer>(ProcessName, BurstTime);

			processes.add(temp);
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
					break;

				default:
					System.exit(0);

			}

		}
	}

}
