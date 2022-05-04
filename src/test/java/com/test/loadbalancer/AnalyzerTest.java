package com.test.loadbalancer;

import com.test.loadbalancer.objects.Analyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AnalyzerTest {
    private Analyzer analyzer;

    @BeforeEach
    void FirstOfAll()
    {
        List<Integer> _taskReceived = new ArrayList<>(Arrays.asList(1,3,4,2,2,2,1,1,2)) ;
        analyzer = new Analyzer();
        analyzer.Initialize(_taskReceived);
        analyzer._drop1pos = 1;
        analyzer._drop2pos = 3;
    }
    @Test
    void GetTasksReceivedTest(){
        assertEquals(Arrays.asList(1,3,4,2,2,2,1,1,2),analyzer.getTaskReceived());
    }
    @Test
    void getNumOfElements(){
        assertEquals(9,analyzer.getNumOfElements());
    }

    @Test
    void CalculateW1Test(){
        assertEquals(1,analyzer.CalculateW1());
    }
    @Test
    void CalculateW2Test(){
        assertEquals(4,analyzer.CalculateW2());
    }
    @Test
    void CalculateW3Test(){
        assertEquals(8,analyzer.CalculateW3());
    }
}
