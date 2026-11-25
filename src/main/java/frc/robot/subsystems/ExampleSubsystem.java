// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.hardware.TalonFX;


public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  public TalonFX motor;

  public ExampleSubsystem() {
    Shuffleboard.getTab(getName()).addFloat("test float", () -> {
      float a = 6.45f;
      float b = 3.24f;
      return a/b;
    });
    motor = new TalonFX(14);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.

    // run(func) = execute while button pressed
    // runEnd(func, func) = while button pressed + 2 when ended
    // runOnce(func) = once when button pressed
    // startEnd(func,func) = run 1 when pressed, 2 when end
    // startRun(func,func) = run 1 when pressed, 2 while held
    return startEnd(
        () -> {
          /* one-time action goes here */
          motor.set(0.2);
        },
        () -> {
          motor.set(0);
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
    //motor.set(0.1);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
