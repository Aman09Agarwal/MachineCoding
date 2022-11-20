package ChainOfResponsibilityPattern;

public abstract class Manager {
    Manager manager;
    int approvalLimit;
    String managerName;

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void approveSalary(int salary) {
        if(salary<approvalLimit) {
            processSalary(salary);
        } else if(manager != null) {
            manager.approveSalary(salary);
        } else {
            System.out.println("Salary demanded is out of budget");
        }
    }

    abstract void processSalary(int salary);
}
