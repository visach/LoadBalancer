package com.test.loadbalancer.objects;

import java.util.List;
import java.util.stream.Collectors;

public class RandomDataLoadGenerator {
    Analyzer _analyzer;
    List<Integer> _tasksGenerated;
    boolean _exito;

    public RandomDataLoadGenerator(){
    }

    public void Init(){
        _analyzer = new Analyzer();
        System.out.println("Starting random examples test...");
        for (int i = 1; i <= 10; i++){
            TaskGenerator taskGenerator = new TaskGenerator();
            _tasksGenerated = taskGenerator.GetTasksGenerated();
            System.out.println("Testing random example: " + _tasksGenerated.stream().collect(Collectors.toList()));
            _analyzer.Initialize(_tasksGenerated);
            _exito = _analyzer.StartAnalysis();

            if (_exito) {
                System.out.println("Solution found dropping " + _analyzer._drop1pos + " and " + _analyzer._drop2pos + " positions");
            }
            else {
                System.out.println("Solution not found.");
            }
        }
    }
}
