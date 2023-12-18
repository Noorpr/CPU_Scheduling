import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Priority {
    private ArrayList<Integer> priorityTimes = new ArrayList<>();
    private ArrayList<Process> processes;
    private ArrayList<Integer> turnAroundTimes = new ArrayList<>();
    private ArrayList<Integer> waitingTimes = new ArrayList<>();
    private int current = 0;
    private Queue<Process> cpu = new LinkedList<>();

    Priority(ArrayList<Process> processes) {
        this.processes = processes;

        for (Process process : processes) {
            priorityTimes.add(process.getPriorityTime());
        }
        //first sort according to priority to solve same arrival time problem
        Collections.sort(processes, new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                return Integer.compare(p1.getPriorityTime(), p2.getPriorityTime());
            }
        });
        //sec sort according to arrival time
        Collections.sort(processes, new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                return Integer.compare(p1.getArrivalTime(), p2.getArrivalTime());
            }
        });

        Collections.sort(processes, new NewComparator());
        if(cpu.size()!=processes.size()){
            for(Process item:processes){
                if(!cpu.contains(item)){
                    cpu.add(item);
                }
            }

        }
        processes.clear();
        current=0;
        for (Process item : cpu) {
            processes.add(item);
        }

    }

    class NewComparator implements Comparator<Process> {
        public int compare(Process p1, Process p2) {
            // for every process in the scheduler we increase the priority each compare step  to fix starvation
            for(Process item :processes){
                //if the item in the cpu queue that's mean the process does not need for aging need
                if ( !cpu.contains(item) &&current > item.getArrivalTime()){
                item.setPriorityTime(item.getPriorityTime()-1);}
            }


            if ( current > p1.getArrivalTime() && current > p2.getArrivalTime()&&!cpu.contains(p1) && !cpu.contains(p2)) {
                if (p1.getPriorityTime() < p2.getPriorityTime()) {
                    if (!cpu.contains(p1)) {
                        cpu.add(p1);
                        current += p1.getBurstTime();
                    }
                    return -1;
                } else {
                    if (!cpu.contains(p2)) {
                        cpu.add(p2);
                        current += p2.getBurstTime();
                    }
                    return 1;
                }
            }
            if (p1 == processes.get(processes.size() - 1)&&cpu.size()==processes.size()-1) {
                if (!cpu.contains(p1)) {
                    cpu.add(p1);
                    current += p1.getBurstTime();
                    return 0;
                }
                else if(!cpu.contains(p2)){

                    cpu.add(p2);
                    current += p2.getBurstTime();
                    return 0;
                }
            }
            if (p2 == processes.get(processes.size() - 1)&&cpu.size()==processes.size()-1) {
                if (!cpu.contains(p2)) {
                    cpu.add(p2);
                    current += p2.getBurstTime();
                    return 0;
                }
                else if (!cpu.contains(p1)) {
                    cpu.add(p1);
                    current += p1.getBurstTime();
                }
                return 0;
            }

            if (!cpu.contains(p1) && !cpu.contains(p2)) {
                if (p1.getArrivalTime() > p2.getArrivalTime()) {

                    if (!cpu.contains(p2)) {
                        cpu.add(p2);
                        current += p2.getBurstTime();
                    }
                    return 1;
                } else if (p1.getArrivalTime() < p2.getArrivalTime()) {

                    if (!cpu.contains(p1)) {
                        cpu.add(p1);
                        current += p1.getBurstTime();
                    }
                    return -1;
                }
            }

            return 0;
        }
    }

    public void execute() {
        int currentTime = processes.get(0).getArrivalTime();

        for (Process process : processes) {
            int waitingTime = currentTime-process.getArrivalTime();
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
