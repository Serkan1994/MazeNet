package AI;

import generated.AwaitMoveMessageType;
import generated.MoveMessageType;
import generated.PositionType;
import util.XMLHandler;

public class RandomAI implements AI {

	@Override
	public MoveMessageType getNextMove(AwaitMoveMessageType ammt) {
		MoveMessageType mmt = XMLHandler.getInstance().createMoveMessage();
		PositionType ptShift = XMLHandler.getInstance().createPosition();
	 	PositionType ptPin = XMLHandler.getInstance().createPosition();
		mmt.setShiftCard(bt.getShiftCard());
		ptShift.setCol(1);
		ptShift.setRow(0);
		mmt.setShiftPosition(ptShift);
		ptPin.setCol(0);
		ptPin.setRow(0);
		mmt.setNewPinPos(ptPin);
		return mmt;
	}

	// MoveMessageType mmt = XMLHandler.getInstance().createMoveMessage();

}
