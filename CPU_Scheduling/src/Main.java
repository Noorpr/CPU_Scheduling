import java.util.*;
import javafx.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numOfProcesses;
		ArrayList<Pair<String,Integer>> processes = new ArrayList<Pair<String,Integer>>();
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
		System.out.println("###########################");
		System.out.print("Please Enter your choice: ");
		int choice = scanner.nextInt();
		
		if (choice == 1) {
			SJF Scheduler = new SJF(processes);
			
			Scheduler.getProcessExecutionOrder();
			System.out.println();
			Scheduler.getWaitingTimeForEachProcess();
			System.out.println();
			Scheduler.getTurnAroundTimeForEachProcess();
			System.out.println("Average waiting time: " + Scheduler.getAverageWaitingTime());
			System.out.println("Average turnaround time: " + Scheduler.getAverageTurnAroundTime());
		}
	}

}
