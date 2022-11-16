package InterfaceImplClasses;

public class Leave {
    private int totalLeave ;
    private int leaveApplied;
    private int remainingLeave;

    public void setTotalLeave(int totalLeave) {
        this.totalLeave = totalLeave;
    }

    public int getTotalLeave() {
        return totalLeave;
    }

    public void setLeaveApplied(int leaveApplied) {
        this.leaveApplied = leaveApplied;
    }

    public void setRemainingLeave(int remainingLeave) {
        this.remainingLeave = remainingLeave;
    }

    public int getLeaveApplied() {
        return leaveApplied;
    }

    public int getRemainingLeave() {
        return remainingLeave;
    }

}
