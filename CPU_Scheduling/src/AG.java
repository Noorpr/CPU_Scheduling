import javafx.util.Pair;
import java.util.*;
import javafx.util.*;



public class AG {

    // i think i dont need all of these i just need Integer not array then i will
    // return each process values from get()

//    private ArrayList<Integer> burstTimes = new ArrayList<>();
//    private ArrayList<Process> processes;
//    private ArrayList<Integer> TurnAroundTimes = new ArrayList<>();
//    private ArrayList<Integer> WaitingTimes = new ArrayList<>();

    private ArrayList<Process> agProcesses;
    private int burstTime;
    private int turnAroundTime;
    private int waitingTime;
    private int qt;
    private int agFactor;
    private int contextSwitching;
    int arrivalTime;
    int priorityNumber;
//    Process agProcess;

    // Constructor
    AG(ArrayList<Process> processes, int contextSw, int qt ){
        int randInt;
        this.qt = qt;
        this.contextSwitching = contextSw;

        for (Process process : processes) {

            // old style to be removed if the new works good and remove the attributs
//            burstTime = process.getBurstTime();
//            priorityNumber = process.getPriorityTime();
//            arrivalTime = process.getArrivalTime();


            randInt = rand();
            if(randInt < 10)
                agFactor = arrivalTime + burstTime + randInt;
            else if(randInt == 10)
                agFactor = arrivalTime + burstTime + priorityNumber;
            else
                agFactor = arrivalTime + burstTime + 10;

            // set the ag Factor as an attribute with the process
            // and then set the list of agProcess to the normal process
            process.setAgFactor(agFactor);
            this.agProcesses = processes;


            // all the following is from the old style to be removed

            // if there is error try to unComment the next line
//            assert false;
            // call constructor of the AG from the Process
//            agProcesses.add(new Process(process.getName(), arrivalTime, burstTime, priorityNumber, agFactor));

        }
    }


    private int rand(){
        // do rand between 0,20 and return it to use it in calculation
        Random random = new Random();
        return random.nextInt(20);
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


