package AI;
import java.util.List;

import generated.AwaitMoveMessageType;
import generated.BoardType;
import generated.MoveMessageType;
import generated.PositionType;
import generated.TreasureType;
import generated.TreasuresToGoType;
import util.XMLHandler;

public class SimpleAI implements AI {
	
	public SimpleAI() {}
	
	public MoveMessageType getNextMove(AwaitMoveMessageType ammt) {
		BoardType bt = ammt.getBoard();
		List<TreasuresToGoType> ttgt = ammt.getTreasuresToGo();
		List<TreasureType> ftt = ammt.getFoundTreasures();
		TreasureType tt = ammt.getTreasure();
		
		MoveMessageType mmt = XMLHandler.getInstance().createMoveMessage();
		PositionType pt = XMLHandler.getInstance().createPosition();
		mmt.setShiftCard(bt.getShiftCard());
		pt.setCol(1);
		pt.setRow(1);
		mmt.setShiftPosition(pt);
		pt.setCol(0);
		pt.setRow(1);
		mmt.setNewPinPos(pt);
		return mmt;
		
		
		
		
		
	}
}
