package supertictactoe.rewrite;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.awt.Color;
import java.util.ArrayList;

public class SuperWorld extends World<Piece> {
	ArrayList<Game> games;
	boolean isPlayerOne;
	Grid<Piece> grid;
	int currentGame;

	public SuperWorld() {
		super(new BoundedGrid<Piece>(11, 11));

		games = new ArrayList<Game>();
		isPlayerOne = true;
		grid = getGrid();
		currentGame = 9; // move anywhere

		setMessage("Welcome to SuperTicTacToe!\nPlayer 1: Click anywhere to begin.");
		setupGrid();
		refreshGame();
	}

	public boolean locationClicked(Location loc) {
		int gameNumber = getGameNumber(loc);
		int index = getIndex(games.get(gameNumber), loc);

		Game activeGame = games.get(gameNumber);
		Game nextGame = games.get(index);

		if (isPlayerOne)
			setMessage("Player 2: Click in the green square to move.");
		else
			setMessage("Player 1: Click in the green square to move.");

		for (Game game : games) {
			game.setColor(Color.WHITE);
		}

		refreshGame();

		if (!isEntireGameOver()) {
			if (currentGame == gameNumber) {
				if (!activeGame.isGameOver()) {
					if (!activeGame.isIndexFull(index)) {
						if (isPlayerOne) {
							activeGame.addPiece(index, new Piece("X"));
							isPlayerOne = false;
						} else {
							activeGame.addPiece(index, new Piece("O"));
							isPlayerOne = true;
						}
						if (nextGame.isGameOver())
							currentGame = 9;
						else
							currentGame = index;
					}
				}
			}
			if (currentGame == 9) {
				if (!activeGame.isGameOver()) {
					if (!activeGame.isIndexFull(index)) {
						if (isPlayerOne) {
							activeGame.addPiece(index, new Piece("X"));
							isPlayerOne = false;
						} else {
							activeGame.addPiece(index, new Piece("O"));
							isPlayerOne = true;
						}
						if (nextGame.isGameOver())
							currentGame = 9;
						else
							currentGame = index;
					}
				}
			}
		}

		if (currentGame == 9) {
			for (Game game : games)
				game.setColor(new Color(169, 247, 164));
		} else
			nextGame.setColor(new Color(169, 247, 164));

		refreshGame();
		return true;
	}

	public void step() {
		deletePiecesFromGrid();
		resetArrays();
		refreshGame();
		currentGame = 9;
		setMessage("Welcome to SuperTicTacToe!\nPlayer 1: Click anywhere to begin.");
		isPlayerOne = true;
	}

	public void setupGrid() {
		// setup individual games
		ArrayList<Location> startLocations = new ArrayList<Location>();
		for (int row = 0; row <= 8; row += 4) {
			for (int col = 0; col <= 8; col += 4) {
				startLocations.add(new Location(row, col));
			}
		}

		for (Location location : startLocations) {
			games.add(new Game(location));
		}

		// setup gridlines
		for (int i = 0; i < grid.getNumCols(); i++) {
			Piece p = new Piece();
			p.setColor(Color.BLACK);
			add(new Location(i, 3), p);
			add(new Location(i, 7), p);
			add(new Location(3, i), p);
			add(new Location(7, i), p);
		}
	}

	public void refreshGame() {
		// delete pieces
		deletePiecesFromGrid();

		// add pieces
		for (Game game : games) {
			ArrayList<Piece> pieces = game.getPiecesArray();
			int index = 0;
			for (int row = game.START_LOCATION_ROW; row <= game.START_LOCATION_ROW + 2; row++) {
				for (int col = game.START_LOCATION_COL; col <= game.START_LOCATION_COL + 2; col++) {
					add(new Location(row, col), pieces.get(index++));
				}
			}

			if (game.isXWin()) {
				game.setColor(new Color(245, 136, 201));
			}
			if (game.isOWin()) {
				game.setColor(new Color(110, 157, 218));
			}
		}
	}

	public void deletePiecesFromGrid() {
		ArrayList<Location> occupiedLocations = grid.getOccupiedLocations();
		for (Location location : occupiedLocations) {
			if (!(grid.get(location).isBlank()))
				grid.remove(location);
		}
	}

	public void resetArrays() {
		for (Game game : games) {
			game.fillWithPieces();
		}
	}

	public int getGameNumber(Location startLocation) {
		int row = startLocation.getRow();
		int col = startLocation.getCol();
		if (row >= 0 && row <= 2) {
			if (col >= 0 && col <= 2) {
				return 0;
			} else if (col >= 4 && col <= 6) {
				return 1;
			} else if (col >= 8 && col <= 10) {
				return 2;
			}
		} else if (row >= 4 && row <= 6) {
			if (col >= 0 && col <= 2) {
				return 3;
			} else if (col >= 4 && col <= 6) {
				return 4;
			} else if (col >= 8 && col <= 10) {
				return 5;
			}
		} else if (row >= 8 && row <= 10) {
			if (col >= 0 && col <= 2) {
				return 6;
			} else if (col >= 4 && col <= 6) {
				return 7;
			} else if (col >= 8 && col <= 10) {
				return 8;
			}
		}
		return -1;
	}

	public int getIndex(Game game, Location location) {
		int startRow = game.START_LOCATION_ROW;
		int startCol = game.START_LOCATION_COL;
		int row = location.getRow();
		int col = location.getCol();

		if (row == startRow) {
			if (col == startCol)
				return 0;
			if (col == startCol + 1)
				return 1;
			if (col == startCol + 2)
				return 2;
		}
		if (row == (startRow + 1)) {
			if (col == startCol)
				return 3;
			if (col == startCol + 1)
				return 4;
			if (col == startCol + 2)
				return 5;
		}
		if (row == (startRow + 2)) {
			if (col == startCol)
				return 6;
			if (col == startCol + 1)
				return 7;
			if (col == startCol + 2)
				return 8;
		}

		return -1;
	}

	public boolean isEntireGameOver() {
		for (Game game : games) {
			if (!game.isGameOver())
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new SuperWorld().show();
	}
}