// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ObjectConstants;

public class Motor extends SubsystemBase {
  /** Creates a new Motor. */

  CANSparkMax motor_1;
  CANSparkMax motor_2;

  public Motor() {
    motor_1 = new CANSparkMax(ObjectConstants.MOTOR_PORT_1, MotorType.kBrushless);
    motor_2 = new CANSparkMax(ObjectConstants.MOTOR_PORT_2, MotorType.kBrushless);

    motor_1.setInverted(false);

  }
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop(){
    motor_1.set(0);
    motor_2.set(0);
  }
  public void move(double speed){
    motor_1.set(speed);
    motor_2.set(speed);
  }
}
