package src.main.scheduler;

class DoorClosedState extends State {

	public DoorClosedState(StateMachine stateMachine) {
		super(stateMachine);
	}
	// Note changed to floorQueue.isEmpty(), doesn't change functionality.
	@Override
	public State defaultEvent() {
		if (this.stateMachine.floorQueue.isEmpty()) {
			return new WaitingState(this.stateMachine);
		} else {
			return new GotNextFloorState(this.stateMachine);
		}
	}
}
