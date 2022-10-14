package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
// TalonFX for our motor and ControlMode to use a percent for our motors
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.Constants;
//import com.ctre.phoenix.motorcontrol.can.TalonFX;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ShootingSubsystem extends SubsystemBase {
  
  private TalonFX shooter = new TalonFX(7);
  private TalonFX shooterIntake = new TalonFX(10);
  public boolean shortDistance = false;
  // gets state of short mode
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
    }
    // shooter intake motor is turned off if it is set to off
    else {
    shooter.set(ControlMode.PercentOutput, 0);
    shooterIntake.set(ControlMode.PercentOutput, 0);
    }
  }
  public void setShooterIntake(boolean isOn){
    if (isOn){
      shooterIntake.set(ControlMode.PercentOutput,getDistance());
    }
    // shooter intake motor is turned off if it is set to off
    else {
    shooterIntake.set(ControlMode.PercentOutput, 0);
    }
  }
  // returns velocity
  public double getVelocity(){
    double vel = shooter.getSelectedSensorVelocity();
    return vel;
  }
}
