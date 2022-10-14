// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
/** An example command that uses an example subsystem. */
public class DriveForward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem m_driveSubsystem;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveForward(DriveSubsystem subsystem) {
    m_driveSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }
@Override
  public void initialize() {
    m_driveSubsystem.setLeftFrontPos();
    System.out.println("Left front pos" + m_driveSubsystem.getLeftFrontPos());
  }
  

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   System.out.println("Drive Forward " + " Front Left Motor Pos: " + m_driveSubsystem.getLeftFrontPos());
    m_driveSubsystem.driveBot(-.3,.3);
  }
  @Override
  public boolean isFinished() {
    
      if (m_driveSubsystem.getLeftFrontPos() < Constants.autoDistance){
        System.out.println("Drive Forward end");
        return true;
      }
      else {return false;}
    }
    public void end(boolean interrupted){
      System.out.println("forward stop");
      m_driveSubsystem.driveBot(0, 0);
    }
  // Called once the command ends or is interrupted.
}
