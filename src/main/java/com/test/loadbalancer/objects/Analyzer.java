package com.test.loadbalancer.objects;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {
    private List<Integer> _taskReceived;

    public void set_taskReceived(List<Integer> _taskReceived) {
        this._taskReceived = _taskReceived;
    }
    public List<Integer> get_taskReceived()
    {
        return this._taskReceived;
    }

    public Analyzer()
    {
        _taskReceived = new ArrayList<> ();
    }
}
