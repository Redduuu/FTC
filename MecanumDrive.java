package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Nu mai vreau programare", group="Linear Opmode")
@Disabled
public abstract class MecanumDrive extends LinearOpMode {
    private final ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
       DcMotor left = hardwareMap.get(DcMotor.class, "left front");
        DcMotor right = hardwareMap.get(DcMotor.class, "right front");
        DcMotor leftb = hardwareMap.get(DcMotor.class, "left back");
        DcMotor rightb = hardwareMap.get(DcMotor.class, "right back");

        left.setDirection(DcMotor.Direction.REVERSE);
        leftb.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftb.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightb.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        while (opModeIsActive()){
            
            double vertical = -gamepad1.left_stick_y;
            double horizontal = gamepad1.left_stick_x;
            double turn  =  gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(vertical) + Math.abs(horizontal) + Math.abs(turn), 1);

            left.setPower(vertical + horizontal + turn / denominator);
            leftb.setPower(vertical - horizontal + turn / denominator);
            right.setPower(vertical - horizontal - turn / denominator);
            rightb.setPower(vertical + horizontal - turn / denominator);


        }
    }


    }

