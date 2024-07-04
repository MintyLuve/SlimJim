// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ObjectConstants;
import frc.robot.Constants.PIDConstants;

public class Motor extends SubsystemBase {
  /** Creates a new Motor. */

  TalonFX motor_1;
  //TalonFX motor_2;

  public Motor() {
    motor_1 = new TalonFX(ObjectConstants.MOTOR_PORT_1, "rio");
    //motor_2 = new TalonFX(ObjectConstants.MOTOR_PORT_2, "rio");
    
    motor_1.setInverted(true);
    //motor_2.setInverted(false);

    var slot0Configs = new Slot0Configs();
    slot0Configs.kS = PIDConstants.kS;
    slot0Configs.kV = PIDConstants.kV;
    slot0Configs.kP = PIDConstants.kP;
    slot0Configs.kI = PIDConstants.kI;
    slot0Configs.kD = PIDConstants.kD;

    motor_1.getConfigurator().apply(slot0Configs);
    //motor_2.getConfigurator().apply(slot0Configs);

  }
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    String v = motor_1.getVelocity().toString();
    SmartDashboard.putString("Velocity", v);
  }

  public void stop(){
    motor_1.set(0);
    //motor_2.set(0);
  }

  public void move(double speed){
    motor_1.set(speed);
    //motor_2.set(speed);
  }
  
  public void setVelocity(double velocity){
    // create a velocity closed-loop request, voltage output, slot 0 configs
    final VelocityVoltage m_request = new VelocityVoltage(0).withSlot(0);

    // set velocity to varibale velocity rps, add 0.5 V to overcome gravity
    motor_1.setControl(m_request.withVelocity(velocity).withFeedForward(0.5));
  }
}
