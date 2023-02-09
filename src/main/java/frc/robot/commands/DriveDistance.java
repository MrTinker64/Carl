// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveDistance extends CommandBase {
  private final DriveSubsystem m_drive;
  private final double m_distance;
  private final double m_speed;
  private double kP = 1.0;
  private static double error;

  /**
   * Creates a new DriveDistance.
   *
   * @param inches The number of inches the robot will drive
   * @param drive  The drive subsystem on which this command will run
   */
  public DriveDistance(double inches, DriveSubsystem drive) {
    m_distance = inches;
    m_speed = kP * error;
    m_drive = drive;
    addRequirements(m_drive);
  }

  @Override
  public void initialize() {
    m_drive.resetEncoders();
    m_drive.tankDrive(m_speed, m_speed);
  }

  @Override
  public void execute() {
    error = m_distance - m_drive.getAverageEncoderDistance();
    m_drive.tankDrive(m_speed, m_speed);
  }

  // Sets speed to 0 when ended
  @Override
  public void end(boolean interrupted) {
      m_drive.tankDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return Math.abs(m_drive.getAverageEncoderDistance()) >= m_distance;
  }
}
