// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class DefaultArm extends CommandBase {
    private final ArmSubsystem m_arm;
    private final Trigger m_x;
    private final Trigger m_a;

    /**
     * Creates a new DefaultDrive.
     *
     * @param subsystem The drive subsystem this command wil run on.
     */
    public DefaultArm(ArmSubsystem subsystem, Trigger x, Trigger a) {
        m_arm = subsystem;
        m_x = x;
        m_a = a;
        addRequirements(m_arm);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (m_x.getAsBoolean()) {
            m_arm.cubeInConeOut();
        } else if (m_a.getAsBoolean()) {
            m_arm.coneInCubeOut();  
        } else {
            m_arm.holdPiece();
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}