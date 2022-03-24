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
      // sets speed of motor based on short mode 
    shooter.set(ControlMode.PercentOutput,getDistance());
    System.out.println(shooter.getSelectedSensorVelocity());
    // if shooter is below threshold the shooterintake motor does not go until the threshhold has been met 
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
    // shooter intake motor is turned off if it is set to off
    else {
    shooter.set(ControlMode.PercentOutput, 0);
    shooterIntake.set(ControlMode.PercentOutput, 0);
    }
  }
  // returns velocity
  public double getVelocity(){
    double vel = shooter.getSelectedSensorVelocity();
    return vel;
  }
}
