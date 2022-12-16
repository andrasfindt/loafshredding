package xyz.andrasfindt.loafshredding;

public enum StageEnum {
    ONE(1), TWO(2), THREE(3), FOUR(4), UNKNOWN(-99);

    private int i;

    StageEnum(int i) {

        this.i = i;
    }

    public static StageEnum valueOf(int stage) {
        for (StageEnum stageEnum : values()) {
            if (stageEnum.i == stage) {
                return stageEnum;
            }
        }
        return UNKNOWN;
    }

    public int asInt() {
        return i;
    }
}
