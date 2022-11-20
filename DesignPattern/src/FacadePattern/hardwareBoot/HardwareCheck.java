package FacadePattern.hardwareBoot;

public class HardwareCheck {
    MotherBoard motherBoard;
    RAM ram;

    public HardwareCheck() {
        this.motherBoard = new MotherBoard();
        this.ram = new RAM();
    }

    public boolean checkAllHardware() {
        return motherBoard.checkMotherBoardOnBoot() && ram.checkRAMOnBoot();
    }
}
