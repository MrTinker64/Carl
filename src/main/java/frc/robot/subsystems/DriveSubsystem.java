// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants.DriveConstants;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class DriveSubsystem extends SubsystemBase {
  // Define motors
  VictorSPX m_frontRight = new VictorSPX(0);
  VictorSPX m_rearRight = new VictorSPX(1);
  VictorSPX m_frontLeft = new VictorSPX(2);
  VictorSPX m_rearLeft = new VictorSPX(3);

  // The motors on the right side of the drive.
  private final MotorControllerGroup m_rightMotors = 
    new MotorControllerGroup(m_frontRight, m_rearRight);

  // The motors on the left side of the drive.
  private final MotorControllerGroup m_leftMotors =
    new MotorControllerGroup(m_frontLeft, m_rearLeft);

  // The robot's drive
  private final DifferentialDrive m_drive = new DifferentialDrive(m_rightMotors, m_leftMotors);

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {}

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param left  the commanded left motor movement
   * @param right the commanded right motor movement
   */
  public void tankDrive(double left, double right) {
    m_drive.tankDrive(left, right);
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a
   * digital sensor).
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
