// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ObjectConstants;

public class Motor extends SubsystemBase {
  /** Creates a new Motor. */

  CANSparkMax canMotor;
  TalonFX talonMotor;

  public Motor() {
    canMotor = new CANSparkMax(Constants.ObjectConstants.CAN_MOTOR_PORT, MotorType.kBrushless);
    talonMotor = new TalonFX(ObjectConstants.TALON_MOTOR_PORT, "rio");

    talonMotor.setInverted(true);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop(){
    canMotor.set(0);
    talonMotor.set(0);
  }
  public void move(double speed){
    canMotor.set(speed);
    talonMotor.set(speed);
  }
}
