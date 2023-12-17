public class Process {

    private int arrivalTime;
    private int burstTime;
    private int priorityTime;
    private int agFactor;
    private int quantumTime;
    private String name;

    // Constructor for normal process
    Process(String name, Integer arvT, Integer bursT, Integer prioNum, Integer qt){
        arrivalTime  = arvT;
        burstTime = bursT;
        priorityTime = prioNum;
        quantumTime = qt;
        this.name = name;

    }


    // Constructor for AG process TO BE REMOVED IF OLD STYLE REMOVED
    Process(String name, Integer arvT, Integer bursT, Integer prioNum, Integer qt, Integer agFactor){
        arrivalTime  = arvT;
        burstTime = bursT;
        priorityTime = prioNum;
        quantumTime = qt;
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
    //for solving starvation 
       public void setPriorityTime(int newPriority) {
        this.priorityTime = newPriority;
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

    public int getQuantumTime() {
        return quantumTime;
    }

    public void setQuantumTime(int quantumTime) {
        this.quantumTime = quantumTime;
    }
}
