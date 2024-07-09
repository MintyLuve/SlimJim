package frc.robot;

public class Constants {
    public static class ControllerConstants{
        public static final int DRIVER_PORT = 0;
        public static final int OPERATOR_PORT = 1;
        public static final double SENSITIVITY = 0.05;
    }

    public static class ObjectConstants{
        public static final int MOTOR_PORT_1 = 7;
        public static final int MOTOR_PORT_2 = 8;
    }

    public static class PIDConstants{
        public static final int VELOCITY_LOW = 10;
        public static final int VELOCITY_HIGH = 100;


        public static final double kS = 0.07;
        public static final double kV = 0;
        public static final double kP = 0.095;
        public static final double kI = 0.002;
        public static final double kD = 0.002;

    }
    
}
