package supertictactoe.rewrite;

import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class Game {
	private ArrayList<Piece> pieces;
	private Location startLocation;
	private Color gameColor;

	public int START_LOCATION_ROW;
	public int START_LOCATION_COL;

	public Game(Location location) {
		pieces = new ArrayList<Piece>();
		setStartLocation(location);

		START_LOCATION_ROW = startLocation.getRow();
		START_LOCATION_COL = startLocation.getCol();

		fillWithPieces();
	}

	public boolean isGameOver() {
		Piece pieceOne = null;
		Piece pieceTwo = null;
		Piece pieceThree = null;

		// check columns
		// 0 | 1 | 2
		// ---------
		// 3 | 4 | 5
		// ---------
		// 6 | 7 | 8
		for (int i = 0; i <= 2; i++) {
			pieceOne = pieces.get(i);
			pieceTwo = pieces.get(i + 3);
			pieceThree = pieces.get(i + 6);
			if (!(pieceOne.isBlank() || pieceTwo.isBlank() || pieceThree
					.isBlank())) {
				if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
					return true;
				}
				if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
					return true;
				}
			}
		}

		// check rows
		for (int i = 0; i <= 6; i += 3) {
			pieceOne = pieces.get(i);
			pieceTwo = pieces.get(i + 1);
			pieceThree = pieces.get(i + 2);
			if (!(pieceOne.isBlank() || pieceTwo.isBlank() || pieceThree
					.isBlank())) {
				if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
					return true;
				}
				if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
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
				return true;
			}
			if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
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
				return true;
			}
			if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
				return true;
			}
		}
		return false;
	}

	public boolean isXWin() {
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
					return true;
				}
			}
		}

		// check rows
		for (int i = 0; i <= 6; i += 3) {
			pieceOne = pieces.get(i);
			pieceTwo = pieces.get(i + 1);
			pieceThree = pieces.get(i + 2);
			if (!(pieceOne.isBlank() || pieceTwo.isBlank() || pieceThree
					.isBlank())) {
				if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
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
				return true;
			}
		}
		return false;
	}

	public boolean isOWin() {
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
				if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
					return true;
				}
			}
		}

		// check rows
		for (int i = 0; i <= 6; i += 3) {
			pieceOne = pieces.get(i);
			pieceTwo = pieces.get(i + 1);
			pieceThree = pieces.get(i + 2);
			if (!(pieceOne.isBlank() || pieceTwo.isBlank() || pieceThree
					.isBlank())) {
				if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
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
			if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
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
			if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
				return true;
			}
		}
		return false;
	}

	public boolean isIndexFull(int index) {
		if (pieces.get(index).isX() || pieces.get(index).isO())
			return true;
		return false;
	}

	public void fillWithPieces() {
		pieces.clear();
		for (int i = 0; i <= 8; i++) {
			pieces.add(i, new Piece(""));
		}
	}

	public void addPiece(int index, Piece piece) {
		pieces.set(index, piece);
	}

	public void setColor(Color color) {
		gameColor = color;
		for (Piece piece : pieces) {
			piece.setColor(gameColor);
		}
	}

	public void setStartLocation(Location location) {
		startLocation = location;
	}

	public Location getStartLocation() {
		return startLocation;
	}

	public ArrayList<Piece> getPiecesArray() {
		return pieces;
	}

	public Color getGameColor() {
		return gameColor;
	}

	public String toString() {
		return pieces.toString();
	}
}