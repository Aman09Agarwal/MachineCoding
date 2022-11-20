package FacadePattern.softwareBoot;

public class SoftwareCheck {
    DriverCheck driverCheck;
    OSCheck osCheck;

    public SoftwareCheck() {
        this.driverCheck = new DriverCheck();
        this.osCheck = new OSCheck();
    }

    public boolean checkAllSoftware() {
        return driverCheck.checkDriverOnBoot() && osCheck.checkOSOnBoot();
    }
}
