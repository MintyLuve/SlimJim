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

  Slot0Configs slot0Configs;

  double kS;
  double kP;
  double kV;
  double kD;
  double kI;

  public Motor() {
    motor_1 = new TalonFX(ObjectConstants.MOTOR_PORT_1, "rio");
    //motor_2 = new TalonFX(ObjectConstants.MOTOR_PORT_2, "rio");
    
    motor_1.setInverted(true);
    //motor_2.setInverted(false);

    /* 54 */
    kS = 0.105401;
    kV = 0.105401;
    kP = 0.25401;
    kI = 0.05401;
    kD = 0.0015401;
    /* 01!!!! */


    slot0Configs = new Slot0Configs();
    slot0Configs.kS = kS;
    slot0Configs.kV = kV;
    slot0Configs.kP = kP;
    slot0Configs.kI = kI;
    slot0Configs.kD = kD;

    motor_1.getConfigurator().apply(slot0Configs);
    //motor_2.getConfigurator().apply(slot0Configs);

    /* Tuning from smart dashboard!! */
    SmartDashboard.putNumber("S Gain", kS);
    SmartDashboard.putNumber("V Gain", kV);
    SmartDashboard.putNumber("P Gain", kP);
    SmartDashboard.putNumber("I Gain", kI);
    SmartDashboard.putNumber("D Gain", kD);

  }
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    String vStr = motor_1.getVelocity().toString();
    SmartDashboard.putString("Velocity", vStr);

    /* Tuning from smart dashboard!! */
    double s = SmartDashboard.getNumber("S Gain", 0);
    double v = SmartDashboard.getNumber("V Gain", 0);
    double p = SmartDashboard.getNumber("P Gain", 0);
    double i = SmartDashboard.getNumber("I Gain", 0);
    double d = SmartDashboard.getNumber("D Gain", 0);
    
    if((s != kS)) { slot0Configs.kS = s; }
    if((v != kV)) { slot0Configs.kV = v; }
    if((p != kP)) { slot0Configs.kP = p; }
    if((i != kI)) { slot0Configs.kI = i; }
    if((d != kD)) { slot0Configs.kD = d; }

    motor_1.getConfigurator().apply(slot0Configs);

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
