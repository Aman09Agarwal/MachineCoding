package main.command;

import main.service.BranchService;

public class OnboardBranch implements CommandExecutorService {
    BranchService branchService = BranchService.getInstance();

    public void execute(String command) {
        String[] commandElements = command.split(" ");
        System.out.println(branchService.onboardBranch(commandElements[1], commandElements[2].split(",")));
    }
}
