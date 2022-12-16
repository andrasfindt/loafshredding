package xyz.andrasfindt.loafshredding;


import org.apache.commons.collections4.map.PassiveExpiringMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Cache {
    private static final Cache INSTANCE = new Cache();
    private final Map<String, Block> blocks = new HashMap<>();
    private final Map<ScheduleCacheKey, List<ScheduleEvent>> schedules = new PassiveExpiringMap<>(2, TimeUnit.HOURS);
    private Map<String, StageEnum> scheduleStage = new PassiveExpiringMap<>(2, TimeUnit.HOURS);

    private Cache() {
    }

    public static Cache getInstance() {
        return INSTANCE;
    }

    public synchronized StageEnum getCurrentStage() {
        return scheduleStage.get(Config.STAGE);
    }

    public synchronized void setCurrentStage(int stage) {
        scheduleStage.put(Config.STAGE, StageEnum.valueOf(stage));
    }

    public synchronized void putBlock(String key, Block value) {
        blocks.put(key, value);
    }

    public synchronized Block getBlock(String key) {
        return blocks.get(key);
    }

    public synchronized List<Suburb> getAllSuburbs() {
        List<Suburb> suburbs = new ArrayList<>();
        for (Block block : blocks.values()) {
            suburbs.addAll(block.getSuburbs());
        }
        return suburbs;
    }

    public synchronized void putSchedule(ScheduleCacheKey scheduleCacheKey, List<ScheduleEvent> list) {
        schedules.put(scheduleCacheKey, list);
    }

    public synchronized List<ScheduleEvent> getSchedule(ScheduleCacheKey scheduleCacheKey) {
        return schedules.get(scheduleCacheKey);
    }


}
