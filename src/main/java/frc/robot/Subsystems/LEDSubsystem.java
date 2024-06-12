// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LEDConstants;

public class LEDSubsystem extends SubsystemBase {
  AddressableLED ledStrip;
  AddressableLEDBuffer stripBuffer;
  final int LED_COUNT = LEDConstants.LED_COUNT;

  int m_rainbowFirstPixelHue = 1;

  int diff = 80;
  int full = 255;
    int empty = 0;

  int r = full;
  int g = empty;
  int b = empty;

  /** Creates a new LEDLights. */
  public LEDSubsystem(AddressableLED m_ledStrip, AddressableLEDBuffer m_stripBuffer) {
    ledStrip = m_ledStrip;
    stripBuffer = m_stripBuffer;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void setBlank(){
    for (int i = 0; i<LED_COUNT; i++){
      stripBuffer.setRGB(i, 0, 0, 0);
    }
  }
  public void setGreen(){
    for (int i = 0; i<LED_COUNT; i++){
      stripBuffer.setRGB(i, 0, 255, 0);
    }
  }

  public void setRainbowChanging(){
    for (var i = 0; i < stripBuffer.getLength(); i++) {
      final var hue = (m_rainbowFirstPixelHue + (i * 180 / stripBuffer.getLength())) % 180;
      stripBuffer.setHSV(i, hue, 255, 128);

    }
    m_rainbowFirstPixelHue += 3;
    m_rainbowFirstPixelHue %= 180;
  }

  public void setRainbowSolid(){
    for (int i = 0; i<LED_COUNT; i++){

      // limiting numbers to 0 - 255
      if (r>full){r=full;}
      if (g>full){g=full;}
      if (b>full){b=full;}
      if (r<empty){r=empty;}
      if (g<empty){g=empty;}
      if (b<empty){b=empty;}
      
      stripBuffer.setRGB(i, r, g, b);

      // red is 255, green is less than 255, b is 0
      if (r == full && g < full && b == empty){ g+= diff; }
      // red is greater than 0, green is 255, b is 0
      else if (r > empty && g==full && b == empty){ r -= diff; }
      //red is 0, green is 255, b is less than 255
      else if (r == empty && g == full && b < full){ b += diff; }
      //red is 0, green is greater than 0, b is 255
      else if (r==empty && g > empty && b==full){ g -= diff; }
      //red is less than 255, green is 0, blue is 255
      else if (r < full && g == empty && b == full){ r += diff; }
      // red is 255, green is 0, blue is greater than 0
      else if (r == full && g==empty && b > empty){ b -= diff; }
      Commands.waitSeconds(10);
    }
    Commands.waitSeconds(10);

  }

  public void setData(){
    ledStrip.setData(stripBuffer);
  }

}
