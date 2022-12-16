package xyz.andrasfindt.loafshredding.util;

import org.junit.Ignore;
import org.junit.Test;
import xyz.andrasfindt.loafshredding.Schedule;
import xyz.andrasfindt.loafshredding.Stage;
import xyz.andrasfindt.loafshredding.StageEnum;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScheduleGenTest {

    private static final StageEnum DEFAULT_STAGE = StageEnum.ONE;

    @Test
    public void testStageOneIncludingWeirdMod48Offset() {
        Stage stage = ScheduleGen.makeSchedule(StageEnum.ONE);
        for (int i = 1; i <= 31; i++) {
            if (i < 10) {
                System.out.print(" " + i + "  ");
            } else {
                System.out.print(i + "  ");
            }
        }
        System.out.println();
        String p0 = makeString(stage, 0);
        String p1 = makeString(stage, 1);
        String p2 = makeString(stage, 2);
        String p3 = makeString(stage, 3);
        String p4 = makeString(stage, 4);
        String p5 = makeString(stage, 5);
        System.out.println(p0);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        assertEquals("1A  7A  5B  3A  1B  7B  5A  3B  2A  8A  6B  4A  2B  8B  6A  4B  3A  1B  7B  5A  3B  1A  7A  5B  4A  2B  8B  6A  4B  2A  8A", p0);
        assertEquals("2A  8A  6B  4A  2B  8B  6A  4B  3A  1B  7B  5A  3B  1A  7A  5B  4A  2B  8B  6A  4B  2A  8A  6B  5A  3B  1A  7A  5B  3A  1B", p1);
        assertEquals("3A  1B  7B  5A  3B  1A  7A  5B  4A  2B  8B  6A  4B  2A  8A  6B  5A  3B  1A  7A  5B  3A  1B  7B  6A  4B  2A  8A  6B  4A  2B", p2);
        assertEquals("4A  2B  8B  6A  4B  2A  8A  6B  5A  3B  1A  7A  5B  3A  1B  7B  6A  4B  2A  8A  6B  4A  2B  8B  7A  5B  3A  1B  7B  5A  3B", p3);
        assertEquals("5A  3B  1A  7A  5B  3A  1B  7B  6A  4B  2A  8A  6B  4A  2B  8B  7A  5B  3A  1B  7B  5A  3B  1A  8A  6B  4A  2B  8B  6A  4B", p4);
        assertEquals("6A  4B  2A  8A  6B  4A  2B  8B  7A  5B  3A  1B  7B  5A  3B  1A  8A  6B  4A  2B  8B  6A  4B  2A  1B  7B  5A  3B  1A  7A  5B", p5);
    }

    @Test
    public void testPDFGen() {
        Schedule pdfSchedule = ScheduleGen.getPDFSchedule();
        Stage stageOne = pdfSchedule.getStage(StageEnum.ONE);
        List<String> expected = new ArrayList<>();
        expected.add("1A  7A  5B  3A  1B  7B  5A  3B  2A  8A  6B  4A  2B  8B  6A  4B  3A  1B  7B  5A  3B  1A  7A  5B  4A  2B  8B  6A  4B  2A  8A");
        expected.add("2A  8A  6B  4A  2B  8B  6A  4B  3A  1B  7B  5A  3B  1A  7A  5B  4A  2B  8B  6A  4B  2A  8A  6B  5A  3B  1A  7A  5B  3A  1B");
        expected.add("3A  1B  7B  5A  3B  1A  7A  5B  4A  2B  8B  6A  4B  2A  8A  6B  5A  3B  1A  7A  5B  3A  1B  7B  6A  4B  2A  8A  6B  4A  2B");
        expected.add("4A  2B  8B  6A  4B  2A  8A  6B  5A  3B  1A  7A  5B  3A  1B  7B  6A  4B  2A  8A  6B  4A  2B  8B  7A  5B  3A  1B  7B  5A  3B");
        expected.add("5A  3B  1A  7A  5B  3A  1B  7B  6A  4B  2A  8A  6B  4A  2B  8B  7A  5B  3A  1B  7B  5A  3B  1A  8A  6B  4A  2B  8B  6A  4B");
        expected.add("6A  4B  2A  8A  6B  4A  2B  8B  7A  5B  3A  1B  7B  5A  3B  1A  8A  6B  4A  2B  8B  6A  4B  2A  1B  7B  5A  3B  1A  7A  5B");
        testStage(stageOne, expected);
        System.out.println();
        Stage stageTwo = pdfSchedule.getStage(StageEnum.TWO);
        expected = new ArrayList<>();
        expected.add("5A  3B  1A  7A  5B  3A  1B  7B  6A  4B  2A  8A  6B  4A  2B  8B  7A  5B  3A  1B  7B  5A  3B  1A  8A  6B  4A  2B  8B  6A  4B");
        expected.add("6A  4B  2A  8A  6B  4A  2B  8B  7A  5B  3A  1B  7B  5A  3B  1A  8A  6B  4A  2B  8B  6A  4B  2A  1B  7B  5A  3B  1A  7A  5B");
        expected.add("7A  5B  3A  1B  7B  5A  3B  1A  8A  6B  4A  2B  8B  6A  4B  2A  1B  7B  5A  3B  1A  7A  5B  3A  2B  8B  6A  4B  2A  8A  6B");
        expected.add("8A  6B  4A  2B  8B  6A  4B  2A  1B  7B  5A  3B  1A  7A  5B  3A  2B  8B  6A  4B  2A  8A  6B  4A  3B  1A  7A  5B  3A  1B  7B");
        expected.add("1B  7B  5A  3B  1A  7A  5B  3A  2B  8B  6A  4B  2A  8A  6B  4A  3B  1A  7A  5B  3A  1B  7B  5A  4B  2A  8A  6B  4A  2B  8B");
        expected.add("2B  8B  6A  4B  2A  8A  6B  4A  3B  1A  7A  5B  3A  1B  7B  5A  4B  2A  8A  6B  4A  2B  8B  6A  5B  3A  1B  7B  5A  3B  1A");
        testStage(stageTwo, expected);
        System.out.println();
        Stage stageThree = pdfSchedule.getStage(StageEnum.THREE);
        expected = new ArrayList<>();
        expected.add("1B  7B  5A  3B  1A  7A  5B  3A  2B  8B  6A  4B  2A  8A  6B  4A  3B  1A  7A  5B  3A  1B  7B  5A  4B  2A  8A  6B  4A  2B  8B");
        expected.add("2B  8B  6A  4B  2A  8A  6B  4A  3B  1A  7A  5B  3A  1B  7B  5A  4B  2A  8A  6B  4A  2B  8B  6A  5B  3A  1B  7B  5A  3B  1A");
        expected.add("3B  1A  7A  5B  3A  1B  7B  5A  4B  2A  8A  6B  4A  2B  8B  6A  5B  3A  1B  7B  5A  3B  1A  7A  6B  4A  2B  8B  6A  4B  2A");
        expected.add("4B  2A  8A  6B  4A  2B  8B  6A  5B  3A  1B  7B  5A  3B  1A  7A  6B  4A  2B  8B  6A  4B  2A  8A  7B  5A  3B  1A  7A  5B  3A");
        expected.add("5B  3A  1B  7B  5A  3B  1A  7A  6B  4A  2B  8B  6A  4B  2A  8A  7B  5A  3B  1A  7A  5B  3A  1B  8B  6A  4B  2A  8A  6B  4A");
        expected.add("6B  4A  2B  8B  6A  4B  2A  8A  7B  5A  3B  1A  7A  5B  3A  1B  8B  6A  4B  2A  8A  6B  4A  2B  1A  7A  5B  3A  1B  7B  5A");
        testStage(stageThree, expected);
        System.out.println();
        Stage stageFour = pdfSchedule.getStage(StageEnum.FOUR);
        expected = new ArrayList<>();
        expected.add("5B  3A  1B  7B  5A  3B  1A  7A  6B  4A  2B  8B  6A  4B  2A  8A  7B  5A  3B  1A  7A  5B  3A  1B  8B  6A  4B  2A  8A  6B  4A");
        expected.add("6B  4A  2B  8B  6A  4B  2A  8A  7B  5A  3B  1A  7A  5B  3A  1B  8B  6A  4B  2A  8A  6B  4A  2B  1A  7A  5B  3A  1B  7B  5A");
        expected.add("7B  5A  3B  1A  7A  5B  3A  1B  8B  6A  4B  2A  8A  6B  4A  2B  1A  7A  5B  3A  1B  7B  5A  3B  2A  8A  6B  4A  2B  8B  6A");
        expected.add("8B  6A  4B  2A  8A  6B  4A  2B  1A  7A  5B  3A  1B  7B  5A  3B  2A  8A  6B  4A  2B  8B  6A  4B  3A  1B  7B  5A  3B  1A  7A");
        expected.add("1A  7A  5B  3A  1B  7B  5A  3B  2A  8A  6B  4A  2B  8B  6A  4B  3A  1B  7B  5A  3B  1A  7A  5B  4A  2B  8B  6A  4B  2A  8A");
        expected.add("2A  8A  6B  4A  2B  8B  6A  4B  3A  1B  7B  5A  3B  1A  7A  5B  4A  2B  8B  6A  4B  2A  8A  6B  5A  3B  1A  7A  5B  3A  1B");
        testStage(stageFour, expected);

        System.out.println();
        System.out.println();

        System.out.println(pdfSchedule);
    }

    // there is a bug somewhere here...
    @Ignore
    @Test
    public void testStageTwo() {
        Stage stageTwo = ScheduleGen.makeSchedule(StageEnum.TWO);
        List<String> expected = new ArrayList<>();
        expected.add("5A  3B  1A  7A  5B  3A  1B  7B  6A  4B  2A  8A  6B  4A  2B  8B  7A  5B  3A  1B  7B  5A  3B  1A  8A  6B  4A  2B  8B  6A  4B");
        expected.add("6A  4B  2A  8A  6B  4A  2B  8B  7A  5B  3A  1B  7B  5A  3B  1A  8A  6B  4A  2B  8B  6A  4B  2A  1B  7B  5A  3B  1A  7A  5B");
        expected.add("7A  5B  3A  1B  7B  5A  3B  1A  8A  6B  4A  2B  8B  6A  4B  2A  1B  7B  5A  3B  1A  7A  5B  3A  2B  8B  6A  4B  2A  8A  6B");
        expected.add("8A  6B  4A  2B  8B  6A  4B  2A  1B  7B  5A  3B  1A  7A  5B  3A  2B  8B  6A  4B  2A  8A  6B  4A  3B  1A  7A  5B  3A  1B  7B");
        expected.add("1B  7B  5A  3B  1A  7A  5B  3A  2B  8B  6A  4B  2A  8A  6B  4A  3B  1A  7A  5B  3A  1B  7B  5A  4B  2A  8A  6B  4A  2B  8B");
        expected.add("2B  8B  6A  4B  2A  8A  6B  4A  3B  1A  7A  5B  3A  1B  7B  5A  4B  2A  8A  6B  4A  2B  8B  6A  5B  3A  1B  7B  5A  3B  1A");
        testStage(stageTwo, expected);
    }

    private void testStage(Stage stage, List<String> expected) {
        for (int i = 1; i <= 31; i++) {
            if (i < 10) {
                System.out.print(" " + i + "  ");
            } else {
                System.out.print(i + "  ");
            }
        }
        System.out.println();
        String p0 = makeString(stage, 0);
        String p1 = makeString(stage, 1);
        String p2 = makeString(stage, 2);
        String p3 = makeString(stage, 3);
        String p4 = makeString(stage, 4);
        String p5 = makeString(stage, 5);
        assertEquals(expected.get(0), p0);
        System.out.println(p0);
        assertEquals(expected.get(1), p1);
        System.out.println(p1);
        assertEquals(expected.get(2), p2);
        System.out.println(p2);
        assertEquals(expected.get(3), p3);
        System.out.println(p3);
        assertEquals(expected.get(4), p4);
        System.out.println(p4);
        assertEquals(expected.get(5), p5);
        System.out.println(p5);
    }

    private String makeString(Stage stage, int index) {
        StringBuilder stringBuilder = new StringBuilder();
        stage.getPeriods().get(index).getBlocks().forEach(s -> stringBuilder.append(s).append("  "));
        return stringBuilder.toString().trim();
    }

    @Test
    public void findScheduleForBlock() {
        Stage stage = ScheduleGen.makeSchedule(StageEnum.TWO);
        System.out.println(stage);
        List<Day> blockInStage = ScheduleGen.findBlockInStage(stage, "2B");
        blockInStage.forEach(System.out::println);
    }

    @Test
    public void find2BInPDF() {
        Stage stage = ScheduleGen.getPDFSchedule().getStage(StageEnum.TWO);
        System.out.println(stage);
        List<Day> blockInStage = ScheduleGen.findBlockInStage(stage, "2B");
        blockInStage.forEach(System.out::println);
    }

    @Test
    public void shouldReturn1AIfInput0() {
        assertEquals("1A", ScheduleGen.mapIntToBlock(0, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn2AIfInput1() {
        assertEquals("2A", ScheduleGen.mapIntToBlock(1, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn3AIfInput2() {
        assertEquals("3A", ScheduleGen.mapIntToBlock(2, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn4AIfInput3() {
        assertEquals("4A", ScheduleGen.mapIntToBlock(3, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn5AIfInput4() {
        assertEquals("5A", ScheduleGen.mapIntToBlock(4, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn6AIfInput5() {
        assertEquals("6A", ScheduleGen.mapIntToBlock(5, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn7AIfInput6() {
        assertEquals("7A", ScheduleGen.mapIntToBlock(6, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn8AIfInput7() {
        assertEquals("8A", ScheduleGen.mapIntToBlock(7, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn1BIfInput8() {
        assertEquals("1B", ScheduleGen.mapIntToBlock(8, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn2BIfInput9() {
        assertEquals("2B", ScheduleGen.mapIntToBlock(9, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn3BIfInput10() {
        assertEquals("3B", ScheduleGen.mapIntToBlock(10, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn4BIfInput11() {
        assertEquals("4B", ScheduleGen.mapIntToBlock(11, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn5BIfInput12() {
        assertEquals("5B", ScheduleGen.mapIntToBlock(12, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn6BIfInput13() {
        assertEquals("6B", ScheduleGen.mapIntToBlock(13, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn7BIfInput14() {
        assertEquals("7B", ScheduleGen.mapIntToBlock(14, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn8BIfInput15() {
        assertEquals("8B", ScheduleGen.mapIntToBlock(15, DEFAULT_STAGE));
    }

    @Test
    public void shouldReturn1AIfInput16() {
        assertEquals("1A", ScheduleGen.mapIntToBlock(16, DEFAULT_STAGE));
    }
}
//// 1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30  31

////5A  3B  1A  7A  5B  3A  1B  7B  6A  4B  2A  8A  6B  4A  2B  8B  7A  5B  3A  1B  7B  5A  3B  1A  8A  6B  4A  2B  8B  6A  4B
////5A  3B  1A  7A  5B  3A  1B  7B  6A  4B  2A  8A  6B  4A  2B  8B  7A  5B  3A  1B  7B  5A  3B  1A  8A  6B  4A  2B  8B  6A  4B

////6A 	4B 	2A 	8A 	6B 	4A	2B 	8B	7A 	5B	3A 	1B 	7B 	5A 	3B 	1A 	8A 	6B 	4A 	2B 	8B 	6A 	4B 	2A 	1B 	7B 	5A 	3B 	1A 	7A 	5B
////6A  4B  2A  8A  6B  4A  2B  8B  7A  5B  3A  1B  7B  5A  3B  1A  8A  6B  4A  2B  8B  6A  4B  2A  1B  7B  5A  3B  1A  7A  5B

////7A 	5B 	3A 	1B 	7B 	5A	3B 	1A	8A 	6B	4A 	2B 	8B 	6A 	4B 	2A 	1B 	7B 	5A 	3B 	1A 	7A 	5B 	3A 	2B 	8B 	6A 	4B 	2A 	8A 	6B
////7A  5B  3A  1B  7B  5A  3B  2A  8A  6B  4A  2B  8B  6A  4B  3A  1B  7B  5A  3B  1A  7A  5B  4A  2B  8B  6A  4B  2A  8A  6B

////8A 	6B 	4A 	2B 	8B 	6A	4B 	2A	1B 	7B	5A 	3B 	1A 	7A 	5B 	3A 	2B 	8B 	6A 	4B 	2A 	8A 	6B 	4A 	3B 	1A 	7A 	5B 	3A 	1B 	7B
////