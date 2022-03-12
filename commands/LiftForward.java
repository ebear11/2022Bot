package frc.robot.commands;

import frc.robot.subsystems.PhneumaticsSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
/** An example command that uses an example subsystem. */
public class LiftForward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final PhneumaticsSubsystem m_PhneumaticsSubsystem;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public LiftForward(PhneumaticsSubsystem subsystem) {
    m_PhneumaticsSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_PhneumaticsSubsystem.release();
  }
  @Override
  public boolean isFinished(){
    return true;
  }
  // Called once the command ends or is interrupted.
}
