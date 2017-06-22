import java.util.List;

import generated.AwaitMoveMessageType;
import generated.BoardType;
import generated.MoveMessageType;
import generated.TreasureType;
import generated.TreasuresToGoType;

public class simpleAI {
	
	public simpleAI() {}
	
	public MoveMessageType getNextMove(AwaitMoveMessageType ammt) {
		BoardType bt = ammt.getBoard();
		List<TreasuresToGoType> ttgt = ammt.getTreasuresToGo();
		List<TreasureType> ftt = ammt.getFoundTreasures();
		TreasureType tt = ammt.getTreasure();
	}
}
