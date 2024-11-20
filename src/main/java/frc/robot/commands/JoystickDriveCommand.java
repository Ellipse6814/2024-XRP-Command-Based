// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.XRPDrivetrain;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class JoystickDriveCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final XRPDrivetrain m_driveSubsystem;
  private final Supplier<Double> xAxisSupplier;
  private final Supplier<Double> yAxisSupplier;
  private final double speed;

  public JoystickDriveCommand(XRPDrivetrain subsystem, Supplier<Double> x, Supplier<Double> y, double speed) {
    m_driveSubsystem = subsystem;
    this.xAxisSupplier = x;
    this.yAxisSupplier = y;
    this.speed = speed;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double xAxis = xAxisSupplier.get();
    double yAxis = yAxisSupplier.get();

    m_driveSubsystem.setLeftSpeed((yAxis + xAxis) * speed);
    m_driveSubsystem.setRightSpeed((yAxis - xAxis) * speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
