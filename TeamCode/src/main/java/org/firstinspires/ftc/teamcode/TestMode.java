package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;
@Autonomous(name="Just a test", group="Dev")
public class TestMode extends LinearOpMode
{


    public void runOpMode()
    {
        AutoMech grace = new AutoMech("lF","rF","lB","rB",4,hardwareMap,telemetry);
        waitForStart();
        grace.move(-1,0,24);
        //grab
        grace.move(1,0,12);
        grace.move(0,1,48);
        //release
        grace.move(0,1,24);
        //grab
        grace.move(1,0,6);
        //release
        grace.move(0,-1,48);

    }


}