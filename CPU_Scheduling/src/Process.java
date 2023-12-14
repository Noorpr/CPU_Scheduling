public class Process {

    private int arrivalTime;
    private int burstTime;
    private int priorityTime;
    private int agFactor;
    private String name;

    // Constructor for normal process
    Process(String name, Integer arvT, Integer bursT, Integer prioNum){
        arrivalTime  = arvT;
        burstTime = bursT;
        priorityTime = prioNum;
        this.name = name;

    }


    // Constructor for AG process TO BE REMOVED IF OLD STYLE REMOVED
    Process(String name, Integer arvT, Integer bursT, Integer prioNum, Integer agFactor){
        arrivalTime  = arvT;
        burstTime = bursT;
        priorityTime = prioNum;
        this.name = name;
        this.agFactor = agFactor;

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
    public void setAgFactor(int agFactor) {
        this.agFactor = agFactor;
    }

    public int getAgFactor() {
        return agFactor;
    }
}
