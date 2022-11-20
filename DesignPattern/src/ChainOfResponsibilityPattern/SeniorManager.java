package ChainOfResponsibilityPattern;

public class SeniorManager extends Manager {
    public SeniorManager(String managerName, int approvalLimit) {
        this.managerName = managerName;
        this.approvalLimit = approvalLimit;
    }

    @Override
    void processSalary(int salary) {
        System.out.println(salary+" approved at level 2, by "+managerName);
    }
}
