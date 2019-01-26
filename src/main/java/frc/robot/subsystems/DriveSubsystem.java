/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveManual;;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // instantiate new motor controller objects
  public Spark leftMaster = new Spark(RobotMap.leftMasterPort);
  public Spark leftSlave = new Spark(RobotMap.leftSlavePort);
  public Spark rightMaster = new Spark(RobotMap.rightMasterPort);
  public Spark rightSlave = new Spark(RobotMap.rightSlavePort);
  
  //Alternative to 'point slave to masters,' basicly does the same thing ;)
  SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(leftMaster, leftSlave);
  SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(rightMaster, rightSlave);
  // instantiate a new DifferentialDrive object and assign motor controllers to differential drive
  public DifferentialDrive drive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

  // create constructor function
  public DriveSubsystem() {

  // point slaves to masters
    //leftSlave.follow(leftMaster);
    //rightSlave.follow(rightMaster); these 2 not work :( look up for Clue
  }
  
// add manualDrive() method
  public void manualDrive(double move, double turn) {
    drive.arcadeDrive(move, turn);


  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new DriveManual());
  }
}
