package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class PhneumaticsSubsystem extends SubsystemBase{

    private final DoubleSolenoid solenoid= new DoubleSolenoid(17, PneumaticsModuleType.REVPH,0,1);
 
    public void release() {
        System.out.println("forward");
        solenoid.set(Value.kForward);
    }
    public void pull() {
        System.out.println("backards");
        solenoid.set(Value.kReverse);
    }
}
