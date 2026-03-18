// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSystem extends SubsystemBase {
  /** Creates a new MotorSystem. */

  //defining variables
  SparkMax motor;
  public SparkMaxConfig config;

  public MotorSystem() {
    motor = new SparkMax(7, MotorType.kBrushless);
    config = new SparkMaxConfig();

    motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Command moveMotor(double speed){
    return run(()->{
        motor.set(speed);
    });
  }

}
