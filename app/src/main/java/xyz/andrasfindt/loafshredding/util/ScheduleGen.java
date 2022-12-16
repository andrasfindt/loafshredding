package xyz.andrasfindt.loafshredding.util;

import xyz.andrasfindt.loafshredding.Period;
import xyz.andrasfindt.loafshredding.Schedule;
import xyz.andrasfindt.loafshredding.Stage;
import xyz.andrasfindt.loafshredding.StageEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ScheduleGen {

    private static final int DAYS_IN_MONTH_MAX = 31;
    private static Schedule PDF_SCHEDULE;

    public static Schedule getPDFSchedule() {
        if (PDF_SCHEDULE == null) {
            PDF_SCHEDULE = new Schedule();
            PDF_SCHEDULE.putStage(StageEnum.ONE, makePDFStage(StageEnum.ONE));
            PDF_SCHEDULE.putStage(StageEnum.TWO, makePDFStage(StageEnum.TWO));
            PDF_SCHEDULE.putStage(StageEnum.THREE, makePDFStage(StageEnum.THREE));
            PDF_SCHEDULE.putStage(StageEnum.FOUR, makePDFStage(StageEnum.FOUR));
        }
        return PDF_SCHEDULE;
    }

    private static Stage makePDFStage(StageEnum stageEnum) {
        Stage stage = new Stage();
        List<Period> periods = stage.getPeriods();
        switch (stageEnum) {
            case ONE:
                periods.add(Period.createFromTableString("0:00\t4:30\t1A \t7A \t5B \t3A \t1B \t7B\t5A \t3B\t2A \t8A\t6B \t4A \t2B \t8B \t6A \t4B \t3A \t1B \t7B \t5A \t3B \t1A \t7A \t5B \t4A \t2B \t8B \t6A \t4B \t2A \t8A"));
                periods.add(Period.createFromTableString("4:00\t8:30\t2A \t8A \t6B \t4A \t2B \t8B\t6A \t4B\t3A \t1B\t7B \t5A \t3B \t1A \t7A \t5B \t4A \t2B \t8B \t6A \t4B \t2A \t8A \t6B \t5A \t3B \t1A \t7A \t5B \t3A \t1B"));
                periods.add(Period.createFromTableString("8:00\t12:30\t3A \t1B \t7B \t5A \t3B \t1A\t7A \t5B\t4A \t2B\t8B \t6A \t4B \t2A \t8A \t6B \t5A \t3B \t1A \t7A \t5B \t3A \t1B \t7B \t6A \t4B \t2A \t8A \t6B \t4A \t2B"));
                periods.add(Period.createFromTableString("12:00\t16:30\t4A \t2B \t8B \t6A \t4B \t2A\t8A \t6B\t5A \t3B\t1A \t7A \t5B \t3A \t1B \t7B \t6A \t4B \t2A \t8A \t6B \t4A \t2B \t8B \t7A \t5B \t3A \t1B \t7B \t5A \t3B"));
                periods.add(Period.createFromTableString("16:00\t20:30\t5A \t3B \t1A \t7A \t5B \t3A\t1B \t7B\t6A \t4B\t2A \t8A \t6B \t4A \t2B \t8B \t7A \t5B \t3A \t1B \t7B \t5A \t3B \t1A \t8A \t6B \t4A \t2B \t8B \t6A \t4B"));
                periods.add(Period.createFromTableString("20:00\t00:30\t6A \t4B \t2A \t8A \t6B \t4A\t2B \t8B\t7A \t5B\t3A \t1B \t7B \t5A \t3B \t1A \t8A \t6B \t4A \t2B \t8B \t6A \t4B \t2A \t1B \t7B \t5A \t3B \t1A \t7A \t5B"));
                break;
            case TWO:
                periods.add(Period.createFromTableString("0:00\t4:30\t5A \t3B \t1A \t7A \t5B \t3A\t1B \t7B\t6A \t4B\t2A \t8A \t6B \t4A \t2B \t8B \t7A \t5B \t3A \t1B \t7B \t5A \t3B \t1A \t8A \t6B \t4A \t2B \t8B \t6A \t4B"));
                periods.add(Period.createFromTableString("4:00\t8:30\t6A \t4B \t2A \t8A \t6B \t4A\t2B \t8B\t7A \t5B\t3A \t1B \t7B \t5A \t3B \t1A \t8A \t6B \t4A \t2B \t8B \t6A \t4B \t2A \t1B \t7B \t5A \t3B \t1A \t7A \t5B"));
                periods.add(Period.createFromTableString("8:00\t12:30\t7A \t5B \t3A \t1B \t7B \t5A\t3B \t1A\t8A \t6B\t4A \t2B \t8B \t6A \t4B \t2A \t1B \t7B \t5A \t3B \t1A \t7A \t5B \t3A \t2B \t8B \t6A \t4B \t2A \t8A \t6B"));
                periods.add(Period.createFromTableString("12:00\t16:30\t8A \t6B \t4A \t2B \t8B \t6A\t4B \t2A\t1B \t7B\t5A \t3B \t1A \t7A \t5B \t3A \t2B \t8B \t6A \t4B \t2A \t8A \t6B \t4A \t3B \t1A \t7A \t5B \t3A \t1B \t7B"));
                periods.add(Period.createFromTableString("16:00\t20:30\t1B \t7B \t5A \t3B \t1A \t7A\t5B \t3A\t2B \t8B\t6A \t4B \t2A \t8A \t6B \t4A \t3B \t1A \t7A \t5B \t3A \t1B \t7B \t5A \t4B \t2A \t8A \t6B \t4A \t2B \t8B"));
                periods.add(Period.createFromTableString("20:00\t00:30\t2B \t8B \t6A \t4B \t2A \t8A\t6B \t4A\t3B \t1A\t7A \t5B \t3A \t1B \t7B \t5A \t4B \t2A \t8A \t6B \t4A \t2B \t8B \t6A \t5B \t3A \t1B \t7B \t5A \t3B \t1A"));
                break;
            case THREE:
                periods.add(Period.createFromTableString("0:00\t4:30\t1B \t7B \t5A \t3B \t1A \t7A\t5B \t3A\t2B \t8B\t6A \t4B \t2A \t8A \t6B \t4A \t3B \t1A \t7A \t5B \t3A \t1B \t7B \t5A \t4B \t2A \t8A \t6B \t4A \t2B \t8B"));
                periods.add(Period.createFromTableString("4:00\t8:30\t2B \t8B \t6A \t4B \t2A \t8A\t6B \t4A\t3B \t1A\t7A \t5B \t3A \t1B \t7B \t5A \t4B \t2A \t8A \t6B \t4A \t2B \t8B \t6A \t5B \t3A \t1B \t7B \t5A \t3B \t1A"));
                periods.add(Period.createFromTableString("8:00\t12:30\t3B \t1A \t7A \t5B \t3A \t1B\t7B \t5A\t4B \t2A\t8A \t6B \t4A \t2B \t8B \t6A \t5B \t3A \t1B \t7B \t5A \t3B \t1A \t7A \t6B \t4A \t2B \t8B \t6A \t4B \t2A"));
                periods.add(Period.createFromTableString("12:00\t16:30\t4B \t2A \t8A \t6B \t4A \t2B\t8B \t6A\t5B \t3A\t1B \t7B \t5A \t3B \t1A \t7A \t6B \t4A \t2B \t8B \t6A \t4B \t2A \t8A \t7B \t5A \t3B \t1A \t7A \t5B \t3A"));
                periods.add(Period.createFromTableString("16:00\t20:30\t5B \t3A \t1B \t7B \t5A \t3B\t1A \t7A\t6B \t4A\t2B \t8B \t6A \t4B \t2A \t8A \t7B \t5A \t3B \t1A \t7A \t5B \t3A \t1B \t8B \t6A \t4B \t2A \t8A \t6B \t4A"));
                periods.add(Period.createFromTableString("20:00\t00:30\t6B \t4A \t2B \t8B \t6A \t4B\t2A \t8A\t7B \t5A\t3B \t1A \t7A \t5B \t3A \t1B \t8B \t6A \t4B \t2A \t8A \t6B \t4A \t2B \t1A \t7A \t5B \t3A \t1B \t7B \t5A"));
                break;
            case FOUR:
                periods.add(Period.createFromTableString("0:00\t4:30\t5B \t3A \t1B \t7B \t5A \t3B\t1A \t7A\t6B \t4A\t2B \t8B \t6A \t4B \t2A \t8A \t7B \t5A \t3B \t1A \t7A \t5B \t3A \t1B \t8B \t6A \t4B \t2A \t8A \t6B \t4A"));
                periods.add(Period.createFromTableString("4:00\t8:30\t6B \t4A \t2B \t8B \t6A \t4B\t2A \t8A\t7B \t5A\t3B \t1A \t7A \t5B \t3A \t1B \t8B \t6A \t4B \t2A \t8A \t6B \t4A \t2B \t1A \t7A \t5B \t3A \t1B \t7B \t5A"));
                periods.add(Period.createFromTableString("8:00\t12:30\t7B \t5A \t3B \t1A \t7A \t5B\t3A \t1B\t8B \t6A\t4B \t2A \t8A \t6B \t4A \t2B \t1A \t7A \t5B \t3A \t1B \t7B \t5A \t3B \t2A \t8A \t6B \t4A \t2B \t8B \t6A"));
                periods.add(Period.createFromTableString("12:00\t16:30\t8B \t6A \t4B \t2A \t8A \t6B\t4A \t2B\t1A \t7A\t5B \t3A \t1B \t7B \t5A \t3B \t2A \t8A \t6B \t4A \t2B \t8B \t6A \t4B \t3A \t1B \t7B \t5A \t3B \t1A \t7A"));
                periods.add(Period.createFromTableString("16:00\t20:30\t1A \t7A \t5B \t3A \t1B \t7B\t5A \t3B\t2A \t8A\t6B \t4A \t2B \t8B \t6A \t4B \t3A \t1B \t7B \t5A \t3B \t1A \t7A \t5B \t4A \t2B \t8B \t6A \t4B \t2A \t8A"));
                periods.add(Period.createFromTableString("20:00\t00:30\t2A \t8A \t6B \t4A \t2B \t8B\t6A \t4B\t3A \t1B\t7B \t5A \t3B \t1A \t7A \t5B \t4A \t2B \t8B \t6A \t4B \t2A \t8A \t6B \t5A \t3B \t1A \t7A \t5B \t3A \t1B"));
                break;
        }
        return stage;
    }

    public static String mapIntToBlock(int i, StageEnum stage) {
        // /
        // this caters for a weird error introduced in the PDF version of the schedule.
        // it does not make any sense why they would do this, and it only appears to
        // fully work for STAGE ONE load shedding
        if (stage == StageEnum.ONE) {
            i += applyStageOneOffsetRule(i);
        }
        // /
        i %= 16;
        return (i % 8 + 1) + (i < 8 ? "A" : "B");
    }

    private static int applyStageOneOffsetRule(int i) {
        return Math.floorDiv(i, 48);
    }

    public static Stage makeSchedule(StageEnum stage) {
        Stage stage1 = new Stage();
        List<Period> periods = stage1.getPeriods();
        make(periods, 0);
        make(periods, 1);
        make(periods, 2);
        make(periods, 3);
        make(periods, 4);
        make(periods, 5);
        int stageOffset = getStageOffset(stage);
        int bound = periods.size() * DAYS_IN_MONTH_MAX;
        for (int i = 0; i < bound; i++) {
            periods.get(i % 6).getBlocks().add(mapIntToBlock(i + stageOffset, stage));
        }
        stage1.setId(stage.toString());
        return stage1;
    }

    private static int getStageOffset(StageEnum stage) {
        if (stage != null) {
            switch (stage) {
                case ONE:
                    return 0;
                case TWO:
                    return 4;
                case THREE:
                    return 8;
                case FOUR:
                    return 12;
            }
        }
        return 0;
    }

    private static void make(List<Period> periods, int offset) {
        Period period = new Period();
        period.setStart(String.format(Locale.getDefault(), "%d:00", 4 * offset));
        period.setEnd(String.format(Locale.getDefault(), "%d:30", 4 * (offset + 1)));
        periods.add(period);
    }

    public static List<Day> findBlockInStage(Stage stage, String block) {
        List<Day> days = createDays();
        for (Day day : days) {
            day.setScheduledTime(findBlockInDay(stage, block, day.getI()));
        }
        return days;
    }

    private static String findBlockInDay(Stage stage, String block, int i) {
        for (Period period : stage.getPeriods()) {
            if (block.equalsIgnoreCase(period.getBlocks().get(i - 1))) {
                return period.getStart();
            }
        }
        return null;
    }

    private static List<Day> createDays() {
        ArrayList<Day> days = new ArrayList<>(31);
        for (int i = 0; i < 31; i++) {
            days.add(new Day(i + 1));
        }
        return days;
    }
}
