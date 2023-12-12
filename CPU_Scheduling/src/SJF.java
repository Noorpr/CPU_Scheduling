import java.util.*;
import javafx.util.*;
public class SJF {
	private ArrayList<Integer> burstTimes = new ArrayList<Integer>();
	private ArrayList<Pair<String,Integer>> processes = new ArrayList<Pair<String,Integer>>();
	private ArrayList<Integer> TurnAroundTimes = new ArrayList<Integer>();
	private ArrayList<Integer> WaitingTimes = new ArrayList<Integer>();
	
	SJF(ArrayList<Pair<String,Integer>> processes){
		for (int i = 0; i < processes.size(); i++) {
			burstTimes.add(processes.get(i).getValue());
			
		}
		
		Collections.sort(burstTimes);
		
		this.processes = processes;
	}
	
	public void getProcessExecutionOrder() {
		for (int i = 0; i < burstTimes.size(); i++) {
			System.out.print("P" + (i + 1) + " : ");
			for (int j = 0; j < burstTimes.size(); j++) {
				if (processes.get(j).getValue() == burstTimes.get(i)) {
					System.out.println(processes.get(j).getKey());
					break;
				}
			}
		}
	}
	
	public void getWaitingTimeForEachProcess() {
		int sum = 0;
		for (int i = 0; i < burstTimes.size(); i++) {
			System.out.println("P" + (i + 1) + " : " + sum);
			WaitingTimes.add(sum);
			sum += burstTimes.get(i);
		}
	}
	
	public void getTurnAroundTimeForEachProcess() {
		int sum = 0;
		for (int i = 0; i < burstTimes.size(); i++) {
			System.out.println("P" + (i + 1) + " : " + (burstTimes.get(i) + sum));
			TurnAroundTimes.add(burstTimes.get(i) + sum);
			sum += burstTimes.get(i);
		}
	}
	
	public int getAverageWaitingTime() {
		int sum = 0;
		for (int i = 0; i < WaitingTimes.size(); i++) {
			sum += WaitingTimes.get(i);
		}
		
		return sum / WaitingTimes.size();
	}
	
	public int getAverageTurnAroundTime() {
		int sum = 0;
		for (int i = 0; i < TurnAroundTimes.size(); i++) {
			sum += TurnAroundTimes.get(i);
		}
		
		return sum / TurnAroundTimes.size();
	}
}
