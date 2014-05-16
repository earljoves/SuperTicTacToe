package supertictactoe;

import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class Game {
	private ArrayList<Piece> pieces;
	private Location startLocation;

	int gameNumber;

	public int START_LOCATION_ROW;
	public int START_LOCATION_COL;

	public Game(Location location) {
		pieces = new ArrayList<Piece>();
		setStartLocation(location);
		setGameNumber();

		START_LOCATION_ROW = startLocation.getRow();
		START_LOCATION_COL = startLocation.getCol();

		fillWithPieces();
	}

	public boolean isGameOver() {
		Piece pieceOne = null;
		Piece pieceTwo = null;
		Piece pieceThree = null;

		// check columns
		for (int i = 0; i <= 2; i++) {
			pieceOne = pieces.get(i);
			pieceTwo = pieces.get(i + 3);
			pieceThree = pieces.get(i + 6);
			if (!(pieceOne.isBlank() || pieceTwo.isBlank() || pieceThree
					.isBlank())) {
				if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
					pieceOne.setColor(Color.CYAN);
					pieceTwo.setColor(Color.CYAN);
					pieceThree.setColor(Color.CYAN);
					return true;
				}
				if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
					pieceOne.setColor(Color.PINK);
					pieceTwo.setColor(Color.PINK);
					pieceThree.setColor(Color.PINK);
					return true;
				}
			}
		}

		// check rows
		for (int i = 0; i <= 2; i++) {
			pieceOne = pieces.get(i);
			pieceTwo = pieces.get(i + 1);
			pieceThree = pieces.get(i + 2);
			if (!(pieceOne.isBlank() || pieceTwo.isBlank() || pieceThree
					.isBlank())) {
				if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
					pieceOne.setColor(Color.CYAN);
					pieceTwo.setColor(Color.CYAN);
					pieceThree.setColor(Color.CYAN);
					return true;
				}
				if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
					pieceOne.setColor(Color.PINK);
					pieceTwo.setColor(Color.PINK);
					pieceThree.setColor(Color.PINK);
					return true;
				}
			}
		}

		// check diagonals
		int i = 0;
		pieceOne = pieces.get(i);
		i += 4;
		pieceTwo = pieces.get(i);
		i += 4;
		pieceThree = pieces.get(i);
		if (!(pieceOne.isBlank() || pieceTwo.isBlank() || pieceThree.isBlank())) {
			if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
				pieceOne.setColor(Color.CYAN);
				pieceTwo.setColor(Color.CYAN);
				pieceThree.setColor(Color.CYAN);
				return true;
			}
			if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
				pieceOne.setColor(Color.PINK);
				pieceTwo.setColor(Color.PINK);
				pieceThree.setColor(Color.PINK);
				return true;
			}
		}

		i = 2;
		pieceOne = pieces.get(i);
		i += 2;
		pieceTwo = pieces.get(i);
		i += 2;
		pieceThree = pieces.get(i);
		if (!(pieceOne.isBlank() || pieceTwo.isBlank() || pieceThree.isBlank())) {
			if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
				pieceOne.setColor(Color.CYAN);
				pieceTwo.setColor(Color.CYAN);
				pieceThree.setColor(Color.CYAN);
				return true;
			}
			if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
				pieceOne.setColor(Color.PINK);
				pieceTwo.setColor(Color.PINK);
				pieceThree.setColor(Color.PINK);
				return true;
			}
		}
		return false;
	}

	public void fillWithPieces() {
		for (int i = 0; i <= 8; i++) {
			addPiece(i, new Piece(""));
		}
	}

	public void addPiece(int index, Piece piece) {
		pieces.add(index, piece);
	}

	public void setGameNumber() {
		int row = startLocation.getRow();
		int col = startLocation.getCol();
		if (row >= 0 && row <= 2) {
			if (col >= 0 && col <= 2) {
				gameNumber = 0;
			} else if (col >= 4 && col <= 6) {
				gameNumber = 1;
			} else if (col >= 8 && col <= 10) {
				gameNumber = 2;
			}
		} else if (row >= 4 && row <= 6) {
			if (col >= 0 && col <= 2) {
				gameNumber = 3;
			} else if (col >= 4 && col <= 6) {
				gameNumber = 4;
			} else if (col >= 8 && col <= 10) {
				gameNumber = 5;
			}
		} else if (row >= 8 && row <= 10) {
			if (col >= 0 && col <= 2) {
				gameNumber = 6;
			} else if (col >= 4 && col <= 6) {
				gameNumber = 7;
			} else if (col >= 8 && col <= 10) {
				gameNumber = 8;
			}
		}
	}

	public void setGameNumber(int number) {
		gameNumber = number;
	}

	public void setStartLocation(Location location) {
		startLocation = location;
	}

	public int getGameNumber() {
		return gameNumber;
	}

	public Location getStartLocation() {
		return startLocation;
	}

	public ArrayList<Piece> getPiecesArray() {
		return pieces;
	}

	public String toString() {
		return pieces.toString();
	}
}