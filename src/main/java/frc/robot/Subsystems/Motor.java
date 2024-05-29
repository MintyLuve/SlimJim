// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Motor extends SubsystemBase {
  /** Creates a new Motor. */

  CANSparkMax motor;
  public Motor() {
    motor = new CANSparkMax(Constants.ObjectConstants.MOTOR_PORT, MotorType.kBrushless);

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
}
