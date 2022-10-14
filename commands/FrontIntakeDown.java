package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FrontIntakeSubsystem;
/** An example command that uses an example subsystem. */
public class FrontIntakeDown extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final FrontIntakeSubsystem m_frontIntakeSubsystem;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public FrontIntakeDown(FrontIntakeSubsystem subsystem) {
    m_frontIntakeSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {m_frontIntakeSubsystem.setFrontIntakePos();}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Intake down " + "Intake Pos: " + m_frontIntakeSubsystem.getFrontIntakePos());
    m_frontIntakeSubsystem.moveIntake("down");
  }
  @Override
 public boolean isFinished() {
     if (m_frontIntakeSubsystem.getFrontIntakePos() > Constants.frontIntakePosStop){
       return true;
     }
     else {return false;}
   }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted){
    System.out.println("Intake stop");
      m_frontIntakeSubsystem.moveIntake("stop");
  }

}
