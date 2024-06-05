// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.PIDConstants;

public class Motor extends SubsystemBase {
  /** Creates a new Motor. */

  SparkPIDController pController;
  CANSparkMax motor;
  public Encoder encoder;
  public Motor() {
    motor = new CANSparkMax(Constants.ObjectConstants.MOTOR_PORT, MotorType.kBrushless);
    pController = motor.getPIDController();
    encoder = new Encoder(PIDConstants.ENCODER_SOURCE_A, PIDConstants.ENCODER_SOURCE_B);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop(){
    motor.set(0);
  }
  public void move(double speed){
    motor.set(speed);
  }
  public void setToPID(){
    pController.setReference(0.5, ControlType.kPosition);
    //pController.setOutputRange(0, 0.8);
    //motor.set(pController.getOutputMax());
  }
}
