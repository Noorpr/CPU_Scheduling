// Import statements

import java.util.List;
import java.util.Random;

public class AG {
    private List<Process> agProcesses;
    private int contextSwitching;
    private int quantumTime;

    public AG(List<Process> processes, int contextSwitching, int quantumTime) {
        this.contextSwitching = contextSwitching;
        this.quantumTime = quantumTime;
        this.agProcesses = processes;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(20);
    }

    public void run() {
        for (Process process : agProcesses) {
            int halfQuantum = process.getQuantumTime() / 2;

            if (process.getArrivalTime() < halfQuantum && halfQuantum != 0) {
                System.out.println("Process " + process.getName() + " is running non-preemptively for half quantum time.");
                process.setRemainingTime(0);
            } else {
                int currentTime = 0;

                while (process.getRemainingTime() > 0) {
                    boolean switched = false;

                    if (currentTime >= halfQuantum) {
                        for (Process otherProcess : agProcesses) {
                            if (otherProcess.getAgFactor() < process.getAgFactor() &&
                                    otherProcess.getRemainingTime() > 0) {
                                System.out.println("Switching to process " + otherProcess.getName() +
                                        " due to smaller AG factor.");
                                process.setQuantumTime(0);
                                agProcesses.add(process);
                                process = otherProcess;
                                agProcesses.remove(otherProcess);
                                switched = true;
                                break;
                            }
                        }
                    }

                    if (!switched) {
                        System.out.println("Process " + process.getName() + " is running preemptively.");
                        process.setRemainingTime(process.getRemainingTime() - quantumTime);
                        process.setAgFactor(process.getAgFactor() + getRandomNumber());

                        if (process.getRemainingTime() <= 0) {
                            System.out.println("Process " + process.getName() + " has finished execution.");
                            break; // Break the loop when a process finishes
                        }
                    }

                    currentTime++;
                }
            }
        }
    }
}
