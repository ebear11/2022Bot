package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class PhneumaticsSubsystem extends SubsystemBase{

    private final DoubleSolenoid solenoid= new DoubleSolenoid(PneumaticsModuleType.REVPH,0,1);
 
    public void release() {
        solenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void pull() {
        solenoid.set(DoubleSolenoid.Value.kReverse);
    }
}
