package FacadePattern;

import FacadePattern.hardwareBoot.HardwareCheck;
import FacadePattern.softwareBoot.SoftwareCheck;

public class LaptopOnSwitch {
    HardwareCheck hardwareCheck;
    SoftwareCheck softwareCheck;

    public LaptopOnSwitch() {
        this.hardwareCheck = new HardwareCheck();
        this.softwareCheck = new SoftwareCheck();
    }

    void switchOnLaptop() {
        if(hardwareCheck.checkAllHardware() && softwareCheck.checkAllSoftware()) {
            System.out.println("Switching on laptop...");
        }
    }
}
