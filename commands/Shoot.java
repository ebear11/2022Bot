package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ShootingSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
/** An example command that uses an example subsystem. */
public class Shoot extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShootingSubsystem m_shootingSubsystem;
  Timer timer;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Shoot(ShootingSubsystem subsystem) {
    m_shootingSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    this.timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_shootingSubsystem.setShooter(true);
    this.timer.reset();
    this.timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }
  @Override
  public boolean isFinished() {
    if (this.timer.get() > 1.5){
      m_shootingSubsystem.setShooterIntake(true);
      System.out.println("Shooting Finished");
      return true;
    }
    else {return false;}
  }
  @Override
  public void end(boolean interrupted){
    this.timer.reset();
  }
  // Called once the command ends or is interrupted.
}