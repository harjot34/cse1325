public class Clock {
    // fields
    int hour;
    int min;
    int sec;

    // constructor
    public Clock(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public String toString() {
        // String hhmmssFormat = " The time is " + hour + ":" + min + ":" + sec;
        // return hhmmssFormat;
        return twoDigit();
    }

    private String twoDigit() {
        String format = String.format("The time is %02d:%02d:%02d", hour, min, sec);
        return format;
    }
}
