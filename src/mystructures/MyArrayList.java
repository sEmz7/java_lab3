package mystructures;



import main.WashingMachine;
import mylogging.ExcMsgLog;
import java.util.ArrayList;

public class MyArrayList extends ArrayList<WashingMachine> {

    private int id_of_obj = 0;

    private long add_total_time = 0L;
    private int add_total_count = 0;

    private long remove_total_time = 0L;
    private int remove_total_count = 0;

    private ArrayList<Long> all_add_time = new ArrayList<>();
    private ArrayList<Long> all_remove_time = new ArrayList<>();

    public void logInfo(ExcMsgLog log) {
        log.writeInfo("addTotalCount: " + add_total_count);
        log.writeInfo("addTotalTime: " + add_total_time);
        log.writeInfo("addMedianTime: " + Actions.getMedian(all_add_time));

        log.writeInfo("removeTotalCount: " + remove_total_count);
        log.writeInfo("removeTotalTime: " + remove_total_time);
        log.writeInfo("removeMedianTime: " + Actions.getMedian(all_remove_time));
    }

    public void add(WashingMachine element, ExcMsgLog log) {
        long startTime = System.nanoTime();
        super.add(element);
        long endTime = System.nanoTime();
        long operationTime = endTime - startTime;

        add_total_time += operationTime;
        add_total_count += 1;
        all_add_time.add(operationTime);

        log.writeInfo("add, " + " ID = " + id_of_obj + ",  " + operationTime + " nanoseconds");
        id_of_obj += 1;
    }

    public void remove(int index, ExcMsgLog log) {
        long startTime = System.nanoTime();
        try {
            super.remove(index);
        } catch (IndexOutOfBoundsException e) {
            log.writeSevere(e.getMessage());
        }
        id_of_obj -= 1;
        long endTime = System.nanoTime();
        long operationTime = endTime - startTime;

        remove_total_time += operationTime;
        remove_total_count += 1;
        all_remove_time.add(operationTime);

        log.writeInfo("remove, " + " ID = " + index + ",  " + operationTime + " nanoseconds");
    }
}
