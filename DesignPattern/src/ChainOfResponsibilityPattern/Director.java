package ChainOfResponsibilityPattern;

public class Director extends Manager {
    public Director(String managerName, int approvalLimit) {
        this.managerName = managerName;
        this.approvalLimit = approvalLimit;
    }

    @Override
    void processSalary(int salary) {
        System.out.println(salary+" approved at level 3, by "+managerName);
    }
}
