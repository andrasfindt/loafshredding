package xyz.andrasfindt.loafshredding;

import xyz.andrasfindt.loafshredding.tasks.ScheduleRequest;

import java.util.Objects;

public class ScheduleCacheKey {
    private String blockCode;
    private StageEnum stage;

    public ScheduleCacheKey(String blockCode, StageEnum stage) {
        this.blockCode = blockCode;
        this.stage = stage;
    }

    public ScheduleCacheKey(ScheduleRequest request) {
        this.blockCode = request.getSuburb().getBlockCode();
        this.stage = request.getStageEnum();
    }

    public String getBlockCode() {
        return blockCode;
    }

    public StageEnum getStage() {
        return stage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleCacheKey that = (ScheduleCacheKey) o;
        return Objects.equals(blockCode, that.blockCode) &&
                stage == that.stage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockCode, stage);
    }
}
