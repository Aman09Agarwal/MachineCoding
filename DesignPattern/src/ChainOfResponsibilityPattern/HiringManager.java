package ChainOfResponsibilityPattern;

public class HiringManager extends Manager {
    public HiringManager(String managerName, int approvalLimit) {
        this.managerName = managerName;
        this.approvalLimit = approvalLimit;
    }

    @Override
    void processSalary(int salary) {
        System.out.println(salary+" approved at level 1, by "+managerName);
    }
}
