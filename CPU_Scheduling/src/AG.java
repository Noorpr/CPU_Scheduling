import javafx.util.Pair;

import java.util.ArrayList;

public class AG {

    // i think i dont need all of these i just need Integer not array then i will
    // return each process values from get()

//    private ArrayList<Integer> burstTimes = new ArrayList<>();
//    private ArrayList<Process> processes;
//    private ArrayList<Integer> TurnAroundTimes = new ArrayList<>();
//    private ArrayList<Integer> WaitingTimes = new ArrayList<>();

    private ArrayList<Process> processes;
    private int burstTime;
    private int turnAroundTime;
    private int waitingTime;
    private int qt;
    private int agFactor;
    private int contextSwitching;
    int arrivalTime;
    int priorityNumber;

    // Constructor
    AG(ArrayList<Process> processes, int contextSw, int qt ){
        this.qt = qt;
        this.contextSwitching = contextSw;

        for (Process process : processes) {
//            this.agFactor = rand();
            burstTime = process.getBurstTime();
            priorityNumber = process.getPriorityTime();
            arrivalTime = process.getArrivalTime();
        }
    }


    int rand(){
        // do rand between 0,20 and return it to use it in calculation
        return 0;
    }


    void getProcessExecutionOrder() {

    }
    void getWaitingTimeForEachProcess() {
    }


    void getTurnAroundTimeForEachProcess() {
    }

    int getAverageWaitingTime() {

        return 0;
    }

    int getAverageTurnAroundTime() {

        return 0;
    }

    void getQauntumTimetHistory(){
        System.out.println();
    }

    public void run(){

    }

}


