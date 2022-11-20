package ChainOfResponsibilityPattern;

public class ChainCreator {
    public Manager createChain() {
        Manager hiringManager = new HiringManager("Mike", 1000);
        Manager seniorManager = new SeniorManager("Bill", 2000);
        Manager director = new Director("John", 5000);
        hiringManager.setManager(seniorManager);
        seniorManager.setManager(director);
        return hiringManager;
    }
}
