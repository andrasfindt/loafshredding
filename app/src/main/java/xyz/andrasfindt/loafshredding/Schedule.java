package xyz.andrasfindt.loafshredding;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Schedule {
    private final Map<StageEnum, Stage> stages = new HashMap<>();

    public Stage getStage(StageEnum stage) {
        return stages.get(stage);
    }

    public void putStage(StageEnum stageKey, Stage stageValue) {
        stages.put(stageKey, stageValue);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
