package xyz.andrasfindt.loafshredding.tasks;

import xyz.andrasfindt.loafshredding.StageEnum;
import xyz.andrasfindt.loafshredding.Suburb;

public class ScheduleRequest {
    private Suburb suburb;
    private StageEnum stageEnum;

    public ScheduleRequest(StageEnum stage, Suburb suburb) {
        stageEnum = stage;
        this.suburb = suburb;
    }

    public Suburb getSuburb() {
        return suburb;
    }

    public StageEnum getStageEnum() {
        return stageEnum;
    }
}
