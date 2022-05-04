package com.test.loadbalancer.objects;

import java.util.List;
import java.util.Objects;

public class Analyzer {

    private List<Integer> _tasksReceived;
    private Integer _w1;
    private Integer _w2;
    private Integer _w3;
    public Integer _drop1pos;
    public Integer _drop2pos;
    private Long _numOfElements;
    private boolean _solutionFound;

    public List<Integer> getTaskReceived() { return this._tasksReceived;}
    public Long getNumOfElements(){return this._numOfElements;}
    public Analyzer(){
    }
    public void Initialize(List<Integer> taskReceived){
        this._tasksReceived = taskReceived;
        this._numOfElements = (long) taskReceived.size();
        this._solutionFound = false;
        //Initial drop positions
        this._drop1pos = 1;
        this._drop2pos = this._drop1pos + 2;
    }
    public boolean StartAnalysis(){
        if (_numOfElements < 5)
        {
            //Solution not found, if we drop 3 of tasks, we will have one idle worker.
            return false;
        }
        while (!_solutionFound && (_drop1pos < _numOfElements-3))
        {
            //Potential parallel process including CalculateW3() too
            CalculateW1();
            CalculateW2();
            if (Objects.equals(_w1, _w2)){
                CalculateW3();
                _solutionFound = Objects.equals(_w1, _w3);
                if (!_solutionFound){
                    updateDropPositions();
                }
            }
            else updateDropPositions();
        }
        return this._solutionFound;
    }
    private void updateDropPositions()
    {
        if (_drop2pos != _numOfElements-1){
            _drop2pos++;
        }
        else {
            _drop1pos++;
            _drop2pos = _drop1pos + 2;
        }
    }
    public Integer CalculateW1(){
        _w1 = _tasksReceived.stream().limit(_drop1pos).reduce(0,Integer::sum);
        return _w1;
    }
    public Integer CalculateW2(){
        _w2 = _tasksReceived.stream().skip(_drop1pos+1).limit(_drop2pos-_drop1pos-1).reduce(0,Integer::sum);
        return _w2;
    }
    public Integer CalculateW3(){
        _w3 = _tasksReceived.stream().skip(_drop2pos+1).limit(_numOfElements-_drop2pos-1).reduce(0,Integer::sum);
        return _w3;
    }
}
