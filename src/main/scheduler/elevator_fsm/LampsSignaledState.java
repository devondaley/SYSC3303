package src.main.scheduler.elevator_fsm;

class LampsSignaledState extends State {

	public LampsSignaledState(StateMachine stateMachine) {
		super(stateMachine);
	}
	
	public State next() {
		this.stateMachine.schedulerSubsystem.sendOpenDoorMessage(
				this.stateMachine.elevatorID);
		
		return new DoorOpenedState(this.stateMachine);
	}

}
