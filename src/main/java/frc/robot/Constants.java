package frc.robot;

public class Constants {
    public static class ControllerConstants{
        public static final int DRIVER_PORT = 0;
        public static final int OPERATOR_PORT = 1;
        public static final double SENSITIVITY = 0.05;
    }

    public static class ObjectConstants{
        public static final int MOTOR_PORT = 2;
        public static final int PCM_PORT = 1;
        public static final int SOLENOID_PORT_FORWARD = 0;
        public static final int SOLENOID_PORT_REVERSE = 1;
        public static final int DIGITAL_INPUT_PORT = 0;
    }

    public static class PIDConstants {
        public static final double PID_P = 0.5;
        public static final double PID_I = 0;
        public static final double PID_D = 0;
        public static final int ENCODER_SOURCE_A = 3;
        public static final int ENCODER_SOURCE_B = 4;
        public static final int ENCODER_FULL_ROTAION_PULSES = 130;

    }

    public static class LEDConstants {
        public static final int LED_COUNT = 20;
        public static final int LED_PORT = 1;
    }

    public static class DumbConstants {
        public static final double FULL_POSITION_FORWARD = 1;
        public static final double FULL_POSITION_REVERSE = -1;
        public static final double HALF_POSITION_FORWARD = 0.5;
        public static final double HALF_POSITION_REVERSE = -0.5;
    }
    
}
