// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
  private final edu.wpi.first.networktables.GenericEntry statusEntry;
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    // Create or select a Shuffleboard tab named "Overdrive"
    edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab tab = 
        edu.wpi.first.wpilibj.shuffleboard.Shuffleboard.getTab("Overdrive");

    // Create a text widget on the tab for live status updates
    statusEntry = tab.add("Subsystem State", "INITIALIZING...")
        .withSize(3, 1)
        .withPosition(0, 0)
        .getEntry();

    try {
      Thread.sleep(400);
      statusEntry.setString("[STAGE 1] Bypassing physical reality... CONFIRMED.");
      
      Thread.sleep(400);
      statusEntry.setString("[STAGE 2] Convincing Java that math is fun... CONFIRMED.");
      
      Thread.sleep(400);
      statusEntry.setString("[STAGE 3] Zero gears harmed... CONFIRMED.");
      
      Thread.sleep(400);
      statusEntry.setString("[SUCCESS] Systems Online.");

      // Triggers a classic host laptop system beep
      java.awt.Toolkit.getDefaultToolkit().beep();

    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
