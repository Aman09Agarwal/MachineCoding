package ChainOfResponsibilityPattern;

public class CORMain {
    public static void main(String[] args) {
        ChainCreator chainCreator = new ChainCreator();
        Manager manager = chainCreator.createChain();
        manager.approveSalary(500);
        manager.approveSalary(1500);
        manager.approveSalary(2500);
        manager.approveSalary(5500);
    }
}
