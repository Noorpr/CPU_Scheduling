public class Process {

    private int arrivalTime;
    private int burstTime;
    private int priorityTime;
    private int agFactor;
    private int quantumTime;
    private String name;
    private int remainingTime;

    // Constructor for normal process
    public Process(String name, int arvT, int bursT, int prioNum, int qt) {
        this.arrivalTime = arvT;
        this.burstTime = bursT;
        this.priorityTime = prioNum;
        this.quantumTime = qt;
        this.name = name;
        this.remainingTime = bursT;
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

    public int getQuantumTime() {
        return quantumTime;
    }

    public void setQuantumTime(int quantumTime) {
        this.quantumTime = quantumTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
}
