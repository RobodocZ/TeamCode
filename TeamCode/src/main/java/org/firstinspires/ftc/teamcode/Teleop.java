package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;
@TeleOp(name="Teleop (dev)", group="Dev")
public class Teleop extends LinearOpMode
{


    public void runOpMode()
    {
        Robot grace = new Robot("lF","rF","lB","rB","InL","InR",hardwareMap);
        waitForStart();
        while(opModeIsActive())
        {
            grace.Gamepad(gamepad1.left_stick_x,gamepad1.left_stick_y,gamepad1.right_stick_x,gamepad1.left_trigger,gamepad1.right_trigger);
        }
    }
}
