    public class Laptop {
    public final int ram;
    public final long hddSize;
    public final String os;
    public final String color;

    public Laptop(int ram, long hddSize, String os, String color) {
        this.ram = ram;
        this.hddSize = hddSize;
        this.os = os;
        this.color = color;
    }

    // Getters for fields
    public int getRam() {
        return ram;
    }

    public long getHddSize() {
        return hddSize;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }
}