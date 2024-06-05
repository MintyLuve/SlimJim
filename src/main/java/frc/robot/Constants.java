package frc.robot;

public class Constants {
    public static class ControllerConstants{
        public static final int DRIVER_PORT = 0;
        public static final int OPERATOR_PORT = 1;
        public static final double SENSITIVITY = 0.05;
    }

    public static class ObjectConstants{
        public static final int MOTOR_PORT = 2;
        public static final int SOLENOID_CAN_PORT = 1;
        public static final int SOLENOID_PORT_FORWARD = 0;
        public static final int SOLENOID_PORT_REVERSE = 1;
    }

    public static class PIDConstants {
        public static final double PID_P = 0.01;
        public static final double PID_I = 0;
        public static final double PID_D = 0;
        public static final int ENCODER_SOURCE_A = 3;
        public static final int ENCODER_SOURCE_B = 4;

    }
    
}
