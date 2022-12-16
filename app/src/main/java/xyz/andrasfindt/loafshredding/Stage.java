package xyz.andrasfindt.loafshredding;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Stage {
    private final List<Period> periods = new ArrayList<>();
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
