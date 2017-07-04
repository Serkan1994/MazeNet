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
        
        int[] pp = getPlayerPosition(bt);
        int[] tp = getTreasurePosition(bt,tt);
        
        
        System.out.println("Player ID: " + this.playerID);
        System.out.println("Player position: " + pp[0] + "|" + pp[1]);
        System.out.println("Treasure Position: " + tp[0] + "|" + tp[1]);
        
        
        bt.
        
        return null;
    }
//    
//    public CardType getPlayerCardType(BoardType bt) {
//        for (BoardType.Row row : bt.getRow()) {
//            for (CardType ct : row.getCol()) {
//                if (ct.getPin().getPlayerID().contains(playerID)){
//                	return ct;
//                }
//            }
//        }    	
//    }
    
    public int[] getPlayerPosition(BoardType bt) {
    	for(int i = 0; i < 7; i++) {
    		for(int j = 0; j < 7; j++) {
    			if(bt.getRow().get(i).getCol().get(j).getPin().getPlayerID().contains((Integer)playerID)) {
    				return new int[] {i,j};
    			}
    		}
    	}	
    	// should never occur.
    	return new int[] {-1,-1};
    }

    public int[] getTreasurePosition(BoardType bt, TreasureType tt) {
    	for(int i = 0; i < 7; i++) {
    		for(int j = 0; j < 7; j++) {
    			if(tt.equals(bt.getRow().get(i).getCol().get(j).getTreasure())) {
    				return new int[] {i,j};
    			}
    		}
    	}	
    	// should never occur.
    	return new int[] {-1,-1};
    }  
    
    public int getDistance(int[] pp, int[] tp) {
    	return Math.abs(pp[0] - tp[0]) + Math.abs(pp[1] - tp[1]);
    }
    
    
}
        




