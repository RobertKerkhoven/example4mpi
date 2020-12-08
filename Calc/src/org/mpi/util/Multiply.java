package org.mpi.util;

import org.mpi.misc.Tools;

public class Multiply implements Tools {

    private int x;
    private int y;
    private int multiplication;

    public Multiply(int x, int y){
        this.x = x;
        this.y=y;
        this.multiplication = x*y;
    }


    public String getString(){

        return x+" x "+y+" = "+this.multiplication;
    }


}
