package AI;

import generated.AwaitMoveMessageType;
import generated.MoveMessageType;


public interface AI {
	public MoveMessageType getNextMove(AwaitMoveMessageType ammt);
	
	
}
