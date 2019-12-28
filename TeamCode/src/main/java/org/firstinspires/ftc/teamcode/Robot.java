package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot{
    AutoMech auto;
    Intake intake;
    Robot(String lf, String rf, String lb, String rb, String left, String right, HardwareMap hardwareMap)
    {
        this.auto = new AutoMech(lf,rf,lb, rb, hardwareMap);
        this.intake = new Intake(left,right,hardwareMap);
    }

    Robot(String lf, String rf, String lb,  String rb, int wheelDiameter, String left, String right, HardwareMap hardwareMap, Telemetry telemetry)
    {
        this.auto = new AutoMech(lf,rf,lb, rb, wheelDiameter, hardwareMap, telemetry);
        this.intake = new Intake(left,right,hardwareMap);
    }

    public void move(int x,int y,int dist)
    {
        auto.move(x,y,dist);
    }

    public void Gamepad(double x, double y, double turn, double LT, double RT, boolean a)
    {
        if (a) {
            auto.Gamepad(2*x, 2*y, 2*turn);
        }
        else{
            auto.Gamepad(x, y, turn);
        }
        intake.Gamepad(LT,RT);
    }

    public void Suck()
    {
        intake.Suck();
    }

    public void Out()
    {
        intake.Out();
    }

    public void Null()
    {
        intake.Null();
    }


}
