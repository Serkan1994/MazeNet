package AI;

import java.util.List;

import generated.*;
import util.XMLHandler;

import static util.XMLHandler.*;

public class SimpleAI implements AI {

    int playerID;

    public SimpleAI(int id) {
        this.playerID=id;
    }

    public MoveMessageType getNextMove(AwaitMoveMessageType ammt) {
        BoardType bt = ammt.getBoard();
        List<TreasuresToGoType> ttgt = ammt.getTreasuresToGo();
        List<TreasureType> ftt = ammt.getFoundTreasures();
        TreasureType tt = ammt.getTreasure();


//        MoveMessageType mmt = getInstance().createMoveMessage();
//        for (BoardType.Row row : bt.getRow()) {
//            for (CardType ct : row.getCol()) {
//                if (ct.getPin().getPlayerID().contains(playerID)){
                    
//                }
//            }
//        }
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
