package mystructures;

import main.WashingMachine;
import mylogging.ExcMsgLog;

import java.util.ArrayList;
import java.util.HashMap;

public class MyHashMap extends HashMap<Integer, WashingMachine> {
    private int id_of_obj = 0;

    private long put_total_time = 0L;
    private int put_total_count = 0;

    private long replace_total_time = 0L;
    private int replace_total_count = 0;

    private ArrayList<Long> all_put_time = new ArrayList<>();
    private ArrayList<Long> all_replace_time = new ArrayList<>();

    public void logInfo(ExcMsgLog log) {
        log.writeInfo("putTotalCount: " + put_total_count);
        log.writeInfo("putTotalTime: " + put_total_time);
        log.writeInfo("putMedianTime: " + Actions.getMedian(all_put_time));

        log.writeInfo("replaceTotalCount: " + replace_total_count);
        log.writeInfo("replaceTotalTime: " + replace_total_time);
        log.writeInfo("replaceMedianTime: " + Actions.getMedian(all_replace_time));
    }

    public void put(WashingMachine element, ExcMsgLog log) {
        long startTime = System.nanoTime();
        super.put(id_of_obj, element);
        long endTime = System.nanoTime();
        long operationTime = endTime - startTime;

        put_total_time += operationTime;
        put_total_count += 1;
        all_put_time.add(operationTime);

        log.writeInfo("put, " + " ID = " + id_of_obj + ",  " + operationTime + " nanoseconds");
        id_of_obj += 1;
    }

    public void replace(int obj_id, WashingMachine newElement, ExcMsgLog log) {
        long startTime = System.nanoTime();
        super.replace(obj_id, newElement);
        long endTime = System.nanoTime();
        long operationTime = endTime - startTime;

        replace_total_time += operationTime;
        replace_total_count += 1;
        all_replace_time.add(operationTime);

        log.writeInfo("replace, " + " ID = " + obj_id + ",  " + operationTime + " nanoseconds");
    }
}