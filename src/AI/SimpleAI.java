package AI;

import java.util.List;

import Server.Board;
import Server.Position;
import generated.AwaitMoveMessageType;
import generated.BoardType;
import generated.MoveMessageType;
import generated.PositionType;
import generated.TreasureType;
import jdk.internal.dynalink.support.BottomGuardingDynamicLinker;
import util.XMLHandler;

public class SimpleAI implements AI {

	int[][] possibleShiftPositions = { { 1, 0 }, { 3, 0 }, { 5, 0 }, { 1, 6 }, { 3, 6 }, { 5, 6 }, { 0, 1 }, { 0, 3 },
			{ 0, 5 }, { 6, 1 }, { 6, 3 }, { 6, 5 } };

	int playerID;

	public SimpleAI(int id) {
		this.playerID = id;
	}

	public MoveMessageType getNextMove(AwaitMoveMessageType ammt) {
		BoardType bt = ammt.getBoard();

		Board board = new Board(bt);
		
		//int[] tp = getTreasurePosition(bt, ammt.getTreasure());
		//Position treasurePosition = new Position(tp[0], tp[1]);

		double minDistance = Integer.MAX_VALUE;
		PositionType bestPos = new Position();
		PositionType bestShiftPos = new Position(1,0);

		MoveMessageType moveMessage = XMLHandler.getInstance().createMoveMessage();

		moveMessage.setShiftCard(bt.getShiftCard());

		PositionType pt = new PositionType();

		// int rndVal = (int) (Math.random()*12);
		for (int[] shiftPos : possibleShiftPositions) {

			pt.setRow(shiftPos[0]);
			pt.setCol(shiftPos[1]);
			
			if(board.getForbidden() != null && pt.getRow() == board.getForbidden().getRow() && pt.getCol() == board.getForbidden().getCol()) {
				System.out.println("forbidden position");
				continue;
			}
			
			moveMessage.setShiftPosition(pt);
			Board dummyBoard = board.fakeShift(moveMessage);
		
			int[] pp = getPlayerPosition(dummyBoard);
			int[] tp = getTreasurePosition(dummyBoard, ammt.getTreasure());
			Position treasurePos = new Position(tp[0], tp[1]);
			List<Position> positions = dummyBoard.getAllReachablePositions(new Position(pp[0], pp[1]));
			positions.add(new Position(pp[0], pp[1]));
			for (Position pos : positions) {
				if (getEuclidDistance(pos, treasurePos) < minDistance) {
					System.out.println("new best position found: ");
					System.out.println();
					minDistance = getEuclidDistance(pos, treasurePos);
					bestPos.setRow(pos.getRow());
					bestPos.setCol(pos.getCol());

					bestShiftPos.setRow(pt.getRow());
					bestShiftPos.setCol(pt.getCol());
					
					
					System.out.println("Best shift pos: " + bestShiftPos.getRow() + "," + bestShiftPos.getCol());
					System.out.println("Best position: " + bestPos.getRow() + "," + bestPos.getCol());
					if (minDistance == 0) {
						break;
					}
				}
			}
		}
		
		moveMessage.setShiftPosition(bestShiftPos);
		moveMessage.setNewPinPos(bestPos);
		
		System.out.println("Best shift pos: " + bestShiftPos.getRow() + "," + bestShiftPos.getCol());
		System.out.println("Best position: " + bestPos.getRow() + "," + bestPos.getCol());

		return moveMessage;

		// List<TreasuresToGoType> ttgt = ammt.getTreasuresToGo();
		// List<TreasureType> ftt = ammt.getFoundTreasures();
		// TreasureType tt = ammt.getTreasure();
		//
		// int[] pp = getPlayerPosition(bt);
		// int[] tp = getTreasurePosition(bt,tt);

		// System.out.println("Player ID: " + this.playerID);
		// System.out.println("Player position: " + pp[0] + "|" + pp[1]);
		// System.out.println("Treasure Position: " + tp[0] + "|" + tp[1]);
		//
	}

	//
	// public CardType getPlayerCardType(BoardType bt) {
	// for (BoardType.Row row : bt.getRow()) {
	// for (CardType ct : row.getCol()) {
	// if (ct.getPin().getPlayerID().contains(playerID)){
	// return ct;
	// }
	// }
	// }
	// }
	public int getManhattanDistance(Position p1, Position p2) {
		return Math.abs(p1.getRow() - p2.getRow()) + Math.abs(p1.getCol() - p2.getCol());
	}
	
	public double getEuclidDistance(Position p1, Position p2) {
		return Math.sqrt(Math.pow(p1.getRow()-p2.getRow(), 2) + Math.pow(p1.getCol()-p2.getCol(), 2));
	}

	public int[] getPlayerPosition(BoardType bt) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (bt.getRow().get(i).getCol().get(j).getPin().getPlayerID().contains((Integer) playerID)) {
					return new int[] { i, j };
				}
			}
		}
		// should never occur.
		return new int[] { -1, -1 };
	}

	public int[] getTreasurePosition(BoardType bt, TreasureType tt) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (tt.equals(bt.getRow().get(i).getCol().get(j).getTreasure())) {
					return new int[] { i, j };
				}
			}
		}
		// should never occur.
		return new int[] { -1, -1 };
	}

	public int getDistance(int[] pp, int[] tp) {
		return Math.abs(pp[0] - tp[0]) + Math.abs(pp[1] - tp[1]);
	}

}
