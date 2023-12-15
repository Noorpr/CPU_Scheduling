import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class Priority {
    private ArrayList<Integer> priorityTimes = new ArrayList<>();
    private ArrayList<Process> processes;
    private ArrayList<Integer> turnAroundTimes = new ArrayList<>();
    private ArrayList<Integer> waitingTimes = new ArrayList<>();
    private int i = 0;


    Priority(ArrayList<Process> processes) {
        this.processes = processes;

        for (Process process : processes) {
            priorityTimes.add(process.getPriorityTime());
        }
        Collections.sort(processes, new NewComparator());
    }

    class NewComparator implements Comparator<Process> {
        public int compare(Process p1, Process p2) {
            if (i > 0) {

                if ( processes.get(i-1).getBurstTime()> p1.getArrivalTime()&&processes.get(i-1).getBurstTime()> p2.getArrivalTime() ) {
                    i += 1;
                    if (p1.getPriorityTime() < p2.getPriorityTime()) {

                        return -1;
                    } else {
                        return 1;
                    }
                }

            }
            if (p1.getArrivalTime() > p2.getArrivalTime()) {
                i++;
                return 1;
            } else if (p1.getArrivalTime() < p2.getArrivalTime()) {
                i++;
                return -1;
            }
            return 0;
        }
    }

    public void execute() {
        int currentTime = 0;

        for (Process process : processes) {
            int waitingTime = currentTime;
            waitingTimes.add(waitingTime);

            int turnAroundTime = waitingTime + process.getBurstTime();
            turnAroundTimes.add(turnAroundTime);

            currentTime += process.getBurstTime();
        }
    }

    public void displayResults() {
        System.out.println("Process Execution Order:");
        for (Process process : processes) {
            System.out.println(process.getName());
        }

        System.out.println("\nWaiting Time for Each Process:");
        for (int i = 0; i < waitingTimes.size(); i++) {
            System.out.println(processes.get(i).getName() + " : " + waitingTimes.get(i));
        }

        System.out.println("\nTurnaround Time for Each Process:");
        for (int i = 0; i < turnAroundTimes.size(); i++) {
            System.out.println(processes.get(i).getName() + " : " + turnAroundTimes.get(i));
        }

        System.out.println("\nAverage Waiting Time: " + getAverage(waitingTimes));
        System.out.println("Average Turnaround Time: " + getAverage(turnAroundTimes));
    }

    private double getAverage(ArrayList<Integer> values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.size();
    }
}