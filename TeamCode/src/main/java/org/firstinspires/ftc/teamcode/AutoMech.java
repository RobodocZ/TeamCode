package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.*;
import org.firstinspires.ftc.robotcore.external.android.AndroidTextToSpeech;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.lang.Math.*;
public class AutoMech
{
    final double pi = 3.141592653589793;
    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;
    double conversionRate;
    Telemetry telemetry;
    AutoMech(String lf,String rf,String lb, String rb,HardwareMap hardwareMap)
    {
        leftFront = hardwareMap.get(DcMotor.class, lf);
        rightFront = hardwareMap.get(DcMotor.class, rf);
        leftBack = hardwareMap.get(DcMotor.class, lb);
        rightBack = hardwareMap.get(DcMotor.class, rb);

    }

    AutoMech(String lf,String rf,String lb, String rb,int wheelDiameter, HardwareMap hardwareMap,Telemetry telemetry)
    {
        leftFront = hardwareMap.get(DcMotor.class, lf);
        rightFront = hardwareMap.get(DcMotor.class, rf);
        leftBack = hardwareMap.get(DcMotor.class, lb);
        rightBack = hardwareMap.get(DcMotor.class, rb);
        conversionRate = 360/(pi*wheelDiameter)*(24/11);
        this.telemetry = telemetry;

    }

    public void turn(double degrees)
    {
        degrees = (14.985)*degrees;
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setTargetPosition((int)degrees);
        rightFront.setTargetPosition((int)degrees);
        leftBack.setTargetPosition((int)degrees);
        rightBack.setTargetPosition((int)degrees);
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(leftFront.isBusy() ||rightFront.isBusy() || leftBack.isBusy() || rightBack.isBusy())
        {
            leftFront.setPower(1);
            rightFront.setPower(1);
            leftBack.setPower(1);
            rightBack.setPower(1);
            telemetry(leftFront,"Left Front");
            telemetry(rightFront, "Right Front");
            telemetry(leftBack, "Left Back");
            telemetry(rightBack, "Right Back");
            telemetry.update();
        }
        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
    }

    public static double CapData(double LowerBound, double In, double UpperBound)
    {
          if(In<LowerBound)
          {
              return (LowerBound);
          }
           if(In > UpperBound)
           {
               return (UpperBound);
           }
           return(In);
    }

    public void move(int x,int y,int dist)
    {
        x = 8/7 * x;
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setTargetPosition((int) Math.round(dist*conversionRate*CapData(-1,x+y,1)));
        rightFront.setTargetPosition((int) Math.round(dist*conversionRate*CapData(-1,x-y,1)));
        leftBack.setTargetPosition((int) Math.round (dist*conversionRate*CapData(-1,-x+y,1)));
        rightBack.setTargetPosition((int) Math.round (dist*conversionRate*CapData(-1,-x-y,1)));
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(leftFront.isBusy() ||rightFront.isBusy() || leftBack.isBusy() || rightBack.isBusy())
        {
            leftFront.setPower(1);
            rightFront.setPower(1);
            leftBack.setPower(1);
            rightBack.setPower(1);
            telemetry(leftFront,"Left Front");
            telemetry(rightFront, "Right Front");
            telemetry(leftBack, "Left Back");
            telemetry(rightBack, "Right Back");
            telemetry.update();
        }
        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
    }
    public void telemetry(DcMotor DC,String name)
    {
        telemetry.addData(name+" Motor"," ");
        telemetry.addData("\tTarget Value",DC.getTargetPosition());
        telemetry.addData("\tValue",DC.getCurrentPosition());
    }
    public void Gamepad(double x, double y, double turn)
    {
        leftFront.setPower(0.5*(turn+x-y));
        rightFront.setPower(0.5*(turn+x+y));
        leftBack.setPower(0.5*(turn-x-y));
        rightBack.setPower(0.5*(turn-x+y));
    }
}
