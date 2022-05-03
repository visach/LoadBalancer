package com.test.loadbalancer.objects;


import java.util.List;

public class BruteForce {

    private List<Integer> _data;
    private int[] _requests;
    private int _drop1pos;
    private int _drop2pos;
    private int _suma1;
    private int _suma2;
    private int _suma3;
    private boolean _continuar1;
    private boolean _continuar2;
    private boolean _exito;
    private int _n;

    public BruteForce()
    {
        //_requests = new requests;
        _n = 8;

        int[] _requests = new int[9];
        _requests[0] = 1;
        _requests[1] = 3;
        _requests[2] = 4;
        _requests[3] = 2;
        _requests[4] = 2;
        _requests[5] = 2;
        _requests[6] = 1;
        _requests[7] = 1;
        _requests[8] = 2;

        for (int i = 0 ; i<= _n; i++)
        {
            System.out.println(_requests[i]);
        }

        //Asumimos que no puede ser 0
        _drop1pos = 1;
        //Asumimos que no tiene sentido que sean consecutivos porque no habria 3 workers
        _drop2pos = _drop1pos +2;
        _continuar1 =true;
        _continuar2 = false;

        System.out.println("Sumador 1: " + sumador1());
        System.out.println("Sumador 2: " + sumador2());
        System.out.println("Sumador 3: " + sumador3());
        //muevo el pos1

        _exito = false;
        while (!_exito)
        {
            //sumador1();
            System.out.println("Sumador 1: " + sumador1());
            System.out.println("Sumador 2: " + sumador2());
            //sumador2();
            if (_suma1 == _suma2)
            {
                //sumador3();
                System.out.println("Sumador 3: " + sumador3());
                if (_suma1 == _suma3)
                {
                    _exito = true;
                }
                else
                {
                    if (_drop2pos!=_n)
                    {
                        _drop2pos++;
                    }
                    else
                    {
                        _drop1pos++;
                        _drop2pos = _drop1pos + 2;
                    }
                }
            }
            else
            {
                if (_drop2pos!=_n)
                {
                    _drop2pos++;
                }
                else
                {
                    _drop1pos++;
                    _drop2pos = _drop1pos + 2;
                }
            }
        }
        if (_exito)
            System.out.println("exito con Drop1 en: " + _drop1pos + " y Drop2 en: " + _drop2pos);
        else
            System.out.println("error");
    }
    private int sumador1()
    {
        _suma1 = 0;
        for (int i = 0; i <_drop1pos;i++)
            _suma1=_suma1+_requests[i];

        return _suma1;
    }
    private int sumador2()
    {
        _suma2 = 0;
        for (int i = _drop1pos+1; i <_drop2pos;i++)
            _suma2=_suma2+_requests[i];

        return _suma2;
    }
    private int sumador3()
    {
        _suma3 = 0;
        for (int i = _drop2pos+1; i <= _n;i++)
            _suma3=_suma3+_requests[i];

        return _suma3;
    }

    /*public void BruteForce (List<Integer> data)
    {
        _data = data;
        Long counter = _data.stream().count();
        System.out.println(counter);
    }*/
}
