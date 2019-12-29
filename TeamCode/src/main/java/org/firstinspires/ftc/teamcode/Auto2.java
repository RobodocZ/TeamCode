package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;
@Autonomous(name="Park Under Bridge (BLUE TEAM RIGHT) (DEV)", group="Dev")
public class Auto2 extends LinearOpMode
{


    public void runOpMode()
    {
        AutoMech grace = new AutoMech("lF","rF","lB","rB",4,hardwareMap,telemetry);
        waitForStart();
        grace.move(0,1,48);
        grace.move(1,0,24);
    }


}
