package test;

import main.model.Branch;
import main.service.BranchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BranchServiceTest {

    BranchService branchService;

    @BeforeEach
    void setUp() {
        branchService = BranchService.getInstance();
    }

    @Test
    void onboardBranch_validVehicleTypes() {
        boolean ack = branchService.onboardBranch("B1", new String[]{"CAR", "BIKE", "BUS"});
        assertEquals(true, ack);
    }

    @Test
    void onboardBranch_invalidVehicleTypes() {
        boolean ack = branchService.onboardBranch("B1", new String[]{"CAR", "TRUCK", "BUS"});
        assertEquals(false, ack);
    }

    @Test
    void getBranchByName_validBranchName() {
        Optional<Branch> branchOptional = branchService.getBranchByName("B1");
        assertEquals(true, branchOptional.isPresent());
    }

    @Test
    void getBranchByName_invalidBranchName() {
        Optional<Branch> branchOptional = branchService.getBranchByName("B2");
        assertEquals(false, branchOptional.isPresent());
    }
}