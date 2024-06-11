// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Controls;
import frc.robot.Subsystems.Motor;

public class XboxMove extends Command {
  /** Creates a new XboxMove. */
  Motor motor;
  public XboxMove(Motor m_motor) {
    motor = m_motor;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(motor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double sens = Constants.ControllerConstants.SENSITIVITY;
    double throttle = Controls.xbox_operator.getRightTriggerAxis();
    double reverse = Controls.xbox_operator.getLeftTriggerAxis();
    
    if(motor.getLimiterState() == false){
      if (reverse > sens && throttle <= sens){
        motor.move(-reverse);
      }
      else if (throttle > sens && reverse <= sens){
        motor.move(throttle);
      }
      else{
        motor.stop();
      }
    }
    else{
      motor.stop();
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
