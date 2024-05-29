package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.Trigger;
public class Controls {
  public static final String DriveConstants = null;
  /* The driver's controller */
  public static XboxController xbox_driver = new XboxController(Constants.ControllerConstants.DRIVER_PORT);
  public static XboxController xbox_operator = new XboxController(Constants.ControllerConstants.OPERATOR_PORT);
  public static CommandXboxController driver = new CommandXboxController(Constants.ControllerConstants.DRIVER_PORT); // Creates a CommandXboxController on port 1.
  public static CommandXboxController operator = new CommandXboxController(Constants.ControllerConstants.OPERATOR_PORT); // Creates a CommandXboxController on port 1.
}