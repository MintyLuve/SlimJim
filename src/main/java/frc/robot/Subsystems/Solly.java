// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ObjectConstants;

public class Solly extends SubsystemBase {
  /** Creates a new Solenoid. */
  DoubleSolenoid dSolenoid;
  public Solly() {
    dSolenoid = new DoubleSolenoid(ObjectConstants.PCM_PORT, PneumaticsModuleType.CTREPCM, 
                      ObjectConstants.SOLENOID_PORT_FORWARD, ObjectConstants.SOLENOID_PORT_REVERSE);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // extend, retract, getstate
  public void extend() {
    dSolenoid.set(Value.kForward);
  }
  public void retract() {
    dSolenoid.set(Value.kReverse);
  }
  public Value getState(){
    return dSolenoid.get();
  }

}
