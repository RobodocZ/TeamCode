package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    DcMotor Left;
    DcMotor Right;
    Intake(String left, String right, HardwareMap hardwareMap)
    {
        Left = hardwareMap.get(DcMotor.class, left);
        Right = hardwareMap.get(DcMotor.class, right);
    }

    public void Suck()
    {
        Left.setPower(1);
        Right.setPower(-1);
    }

    public void Out()
    {
        Left.setPower(-0.5);
        Right.setPower(0.5);

    }

    public void Null()
    {
        Left.setPower(0);
        Right.setPower(0);
    }

    public static double format( double In, double UpperBound)
    {

        if(In > UpperBound)
        {
            return (UpperBound);
        }
        return(0);
    }


    public void Gamepad(double LT, double RT)
    {
        if(LT>0.5)
        {
            Suck();
        }
        else if( RT>0.5)
        {
            Out();
        }
        else
        {
            Null();
        }
    }
}
