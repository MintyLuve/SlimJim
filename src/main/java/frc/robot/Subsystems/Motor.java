// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DumbConstants;
import frc.robot.Constants.PIDConstants;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants.ObjectConstants;

public class Motor extends SubsystemBase {
  /** Creates a new Motor. */

  //defining variables
  SparkClosedLoopController pController;
  SparkMax motor;
  public RelativeEncoder sparkEncoder;
  public Encoder encoder;
  DigitalInput dInput;
  public SparkMaxConfig config;

  public Motor() {
    //init variables
    motor = new SparkMax(Constants.ObjectConstants.MOTOR_PORT, MotorType.kBrushless);
    pController = motor.getClosedLoopController();
    sparkEncoder = motor.getEncoder();
    encoder = new Encoder(PIDConstants.ENCODER_SOURCE_A, PIDConstants.ENCODER_SOURCE_B, false, Encoder.EncodingType.k2X);
    dInput = new DigitalInput(ObjectConstants.DIGITAL_INPUT_PORT);
    //Configure all of the commands in the PID/ closed loop controller
    config.closedLoop
      // sets pid constants
      .p(PIDConstants.PID_P)
      .i(PIDConstants.PID_I)
      .d(PIDConstants.PID_D)
      // sets it to stay within 360
      .positionWrappingEnabled(true)
      .positionWrappingMaxInput(DumbConstants.FULL_POSITION_FORWARD)
      .positionWrappingMinInput(DumbConstants.FULL_POSITION_REVERSE);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //makes the motor stop
  public void stop(){
    motor.set(0);
  }
  //runs the motor at a specific speed
  public void move(double speed){
    motor.set(speed);
  }
  //sets the motor to a specific position
  public void setToPID(double pos){
    pController.setReference(pos, SparkMax.ControlType.kPosition);
  }
  //gets the red encoder's rotation
  public double getQRotation(){
    return -1 * encoder.getDistance()/ PIDConstants.ENCODER_FULL_ROTAION_PULSES;
  }
  // gets the limit switch state
    public boolean getLimiterState(){
    return dInput.get();
  }
}
