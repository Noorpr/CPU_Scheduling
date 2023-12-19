import java.util.*;
import javafx.util.*;
public class SJF {
    private ArrayList<Integer> burstTimes = new ArrayList<>();
    private ArrayList<Process> processes;
    private ArrayList<Integer> TurnAroundTimes = new ArrayList<Integer>();
    private ArrayList<Integer> WaitingTimes = new ArrayList<Integer>();
    private ArrayList<Integer> arrivalTimes = new ArrayList<Integer>();

    private int  contextSwitching;

    SJF(ArrayList<Process> processes, int contextSwitching){
        this.contextSwitching = contextSwitching;
        for (Process process : processes){
            arrivalTimes.add(process.getArrivalTime());
        }
        Collections.sort(arrivalTimes);
        Set<Integer> s = new HashSet<Integer>(arrivalTimes);
        if (s.size() == 1){
            for (int i = 0; i < arrivalTimes.size(); i++){
                if (arrivalTimes.get(i) == processes.get(i).getArrivalTime()){
                    burstTimes.add(processes.get(i).getBurstTime() + contextSwitching);
                }
            }
            Collections.sort(burstTimes);
        }
        else{
            for (int i = 0; i < arrivalTimes.size(); i++){
                for (Process process : processes){
                    if (arrivalTimes.get(i) == process.getArrivalTime()){
                        burstTimes.add(process.getBurstTime() + contextSwitching);
                        i++;
                    }
                }
            }
            int start = 0 , end = 0;
            for (int i = 0; i < arrivalTimes.size() - 1; i++){
                if (arrivalTimes.get(i) == arrivalTimes.get(i + 1)){
                    start = i;
                    for (int j = i + 1; j < arrivalTimes.size(); j++){
                        if (arrivalTimes.get(j) == arrivalTimes.get(j - 1)){
                            end = j;
                        }
                    }
                }
            }
            Collections.sort(burstTimes.subList(start, end + 1));
        }



//        Collections.sort(burstTimes);

        this.processes = processes;
    }

    public void getProcessExecutionOrder() {
        for (int i = 0; i < burstTimes.size(); i++) {
            System.out.print("P" + (i + 1) + " : ");
            ArrayList<Process> temp = this.processes;
            for (int j = 0; j < temp.size(); j++) {
                if (temp.get(j).getBurstTime() == (burstTimes.get(i) - contextSwitching) && arrivalTimes.get(i) == temp.get(j).getArrivalTime()) {
                    System.out.println(temp.get(j).getName());
                    temp.remove(j);
                    break;
                }
            }
        }
    }

    public void getWaitingTimeForEachProcess() {
        int temp = arrivalTimes.get(0);
        for (int i = 0; i < burstTimes.size(); i++) {
            System.out.println("P" + (i + 1) + " : " + (temp - arrivalTimes.get(i)));
            WaitingTimes.add(temp - arrivalTimes.get(i));
            temp += arrivalTimes.get(i) + burstTimes.get(i);
        }
    }

    public void getTurnAroundTimeForEachProcess() {
        int currentTime = 0;
        for (int i = 0; i < burstTimes.size(); i++) {
            currentTime += burstTimes.get(i);
            System.out.println("P" + (i + 1) + " : " + (currentTime - arrivalTimes.get(i)));
            TurnAroundTimes.add(currentTime - arrivalTimes.get(i));
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

    public void run(){
        System.out.println("Process Execution Order:");
        getProcessExecutionOrder();
        System.out.println();
        System.out.println("Waiting Time For Each Process:");
        getWaitingTimeForEachProcess();
        System.out.println();
        System.out.println("TurnAround Time For Each Process:");
        getTurnAroundTimeForEachProcess();
        System.out.println("\nAverage waiting time: " + getAverageWaitingTime());
        System.out.println("Average turnaround time: " + getAverageTurnAroundTime());
    }
}
