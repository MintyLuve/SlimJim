// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ObjectConstants;

public class Compressy extends SubsystemBase {
  /** Creates a new Solenoid. */
  Compressor compressor;
  public Compressy() {
    compressor = new Compressor(ObjectConstants.PCM_PORT, PneumaticsModuleType.CTREPCM);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // enable, disable, get
  public void enable() {
    compressor.enableDigital();
  }
  public void disable() {
    compressor.disable();
  }
  public boolean isOn(){
    return compressor.isEnabled();
  }

}
