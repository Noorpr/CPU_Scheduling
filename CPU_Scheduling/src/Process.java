public class Process {

    int arrivalTime;
    int burstTime;
    int priorityTime;
    String name;


    Process(String name, Integer arvT, Integer bursT, Integer prioNum){
        arrivalTime  = arvT;
        burstTime = bursT;
        priorityTime = prioNum;
        this.name = name;

    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getPriorityTime() {
        return priorityTime;
    }

    public String getName() {
        return name;
    }
}
