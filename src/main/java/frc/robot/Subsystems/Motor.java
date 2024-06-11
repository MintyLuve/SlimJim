// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DumbConstants;
import frc.robot.Constants.PIDConstants;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants.ObjectConstants;

public class Motor extends SubsystemBase {
  /** Creates a new Motor. */

  //defining variables
  SparkPIDController pController;
  CANSparkMax motor;
  public RelativeEncoder sparkEncoder;
  public Encoder encoder;
  DigitalInput dInput;

  public Motor() {
    //init variables
    motor = new CANSparkMax(Constants.ObjectConstants.MOTOR_PORT, MotorType.kBrushless);
    pController = motor.getPIDController();
    sparkEncoder = motor.getEncoder();
    encoder = new Encoder(PIDConstants.ENCODER_SOURCE_A, PIDConstants.ENCODER_SOURCE_B, false, Encoder.EncodingType.k2X);
    dInput = new DigitalInput(ObjectConstants.DIGITAL_INPUT_PORT);

    // sets pid constants
    pController.setP(PIDConstants.PID_P);
    pController.setI(PIDConstants.PID_I);
    pController.setD(PIDConstants.PID_D);

    // sets it to stay within 360
    pController.setPositionPIDWrappingEnabled(true);
    pController.setPositionPIDWrappingMaxInput(DumbConstants.FULL_POSITION_FORWARD);
    pController.setPositionPIDWrappingMinInput(DumbConstants.FULL_POSITION_REVERSE);
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
    pController.setReference(pos, CANSparkMax.ControlType.kPosition);
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
