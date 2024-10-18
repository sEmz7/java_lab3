package main;


import mylogging.ExcMsgLog;
import mystructures.MyArrayList;
import mystructures.MyHashMap;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    static WashingMachine generateMachine() {
        return new AutomaticMachine((int) (Math.random() * 100));
    }
    public static void main(String[] args) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        int n = 0;  // номер лог файла

        /*
         *      Эксперименты  для  ArrayList
         *                   |
         *                   V
         * */

        MyArrayList my_array;


        for (int size = 10; n < 5; n++, size *= 10) {
            my_array = new MyArrayList();
            ExcMsgLog log = new ExcMsgLog(n);
            log.writeFine("Start programm: " + LocalDateTime.now().format(formatter));

            for (int j = 0; j < size; j++) {
                my_array.add(generateMachine(), log);
            }

            for (int j = 0; j < (int) (size * 0.1); j++) {
                my_array.remove((int) (Math.random() * my_array.size()), log);
            }

            my_array.logInfo(log);
            log.writeInfo("Amount of exceptions: " + log.getException_count());
            log.writeFine("Finish programm: " + LocalDateTime.now().format(formatter));
        }
        /*
         *      Эксперименты  для  HashMap
         *                   |
         *                   V
         * */

        MyHashMap my_hashmap;

        for (int size = 10; n < 10; n++, size *= 10) {
            my_hashmap = new MyHashMap();
            ExcMsgLog log = new ExcMsgLog(n);
            log.writeFine("Start programm: " + LocalDateTime.now().format(formatter));

            for (int j = 0; j < size; j++) {
                my_hashmap.put(generateMachine(), log);
            }

            for (int j = 0; j < (int) (size * 0.1); j++) {
                my_hashmap.replace((int) (Math.random() * my_hashmap.size()), generateMachine(), log);
            }

            my_hashmap.logInfo(log);
            log.writeInfo("Amount of exceptions: " + log.getException_count());
            log.writeFine("Finish programm: " + LocalDateTime.now().format(formatter));
        }

    }
}