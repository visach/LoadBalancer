package com.test.loadbalancer.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class TaskGenerator {
    private List<Integer> taskGenerated;
    public List<Integer> GetTasksGenerated(){return this.taskGenerated;}
    public TaskGenerator(){
        taskGenerated = new ArrayList<>();
        //Min value 4 to test case of less than 5 elements.
        int numOfElements = ThreadLocalRandom.current().nextInt(4,12);
        for (int elem= 0; elem <= numOfElements;elem++){
            taskGenerated.add(ThreadLocalRandom.current().nextInt(1,4));
        }

    }
}
