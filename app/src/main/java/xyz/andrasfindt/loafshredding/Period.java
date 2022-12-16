package xyz.andrasfindt.loafshredding;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Period {
    private final List<String> blocks = new ArrayList<>();
    private String start;
    private String end;

    public static Period createFromTableString(String tableRow) {
        Period period = new Period();
        String[] split = tableRow.split("\\s+");
        period.start = split[0];
        period.end = split[1];
        period.blocks.addAll(Arrays.asList(Arrays.copyOfRange(split, 2, 33)));
        return period;
    }

    public static Period createFromTableString(String tableRow, String start, String end) {
        Period period = new Period();
        period.start = start;
        period.end = end;
        period.blocks.addAll(Arrays.asList(tableRow.split("\\s+")));
        return period;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public List<String> getBlocks() {
        return blocks;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
