package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
// TalonFX for our motor and ControlMode to use a percent for our motors
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.Constants;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
//import com.ctre.phoenix.motorcontrol.can.TalonFX;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ShootingSubsystem extends SubsystemBase {
  
  private TalonFX shooter = new TalonFX(7);
  private TalonFX shooterIntake = new TalonFX(10);
  public boolean shortDistance = false;
  public double getDistance(){
    if (shortDistance){
      return Constants.shortShooterSpeed;
    }
    else{
      return Constants.normalShooterSpeed;
    }
  }

  public void setShooter(boolean isOn){
    if (isOn){
    shooter.set(ControlMode.PercentOutput,getDistance());
    System.out.println(shooter.getSelectedSensorVelocity());
      if (shooter.getSelectedSensorVelocity() < Constants.velocityThreshold){
        shooterIntake.set(ControlMode.PercentOutput, Constants.shooterIntakeSpeed);
      }
      else if (shortDistance && shooter.getSelectedSensorVelocity() < Constants.shortVelocityThreshold){
        shooterIntake.set(ControlMode.PercentOutput, Constants.shooterIntakeSpeed);
      }
      else{
        shooterIntake.set(ControlMode.PercentOutput, 0);
      }
    }
    else{
    shooter.set(ControlMode.PercentOutput, 0);
    shooterIntake.set(ControlMode.PercentOutput, 0);
    }
  }
  public double getVelocity(){
    double vel = shooter.getSelectedSensorVelocity();
    return vel;
  }
}
