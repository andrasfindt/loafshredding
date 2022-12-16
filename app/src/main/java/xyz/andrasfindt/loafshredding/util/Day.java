package xyz.andrasfindt.loafshredding.util;

import com.google.gson.Gson;

public class Day {
    private final int i;
    private String scheduledTime;

    public Day(int i) {

        this.i = i;
    }

    public int getI() {
        return i;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
