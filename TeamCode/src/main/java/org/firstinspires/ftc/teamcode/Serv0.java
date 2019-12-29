package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Serv0 {
    Servo main;
    double min;
    double max;
    Serv0(double min, double max, String path, OpMode opmode)
    {
        main =  opmode.hardwareMap.get(Servo.class, path);
        this.min = min;
        this.max = max;
        this.up();
    }
    public void down()
    {
        main.setPosition(min);
    }

    public void up()
    {
        main.setPosition(max);
    }
}
