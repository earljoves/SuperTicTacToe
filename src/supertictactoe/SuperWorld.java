package supertictactoe;

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
	int activeGame;

	public SuperWorld() {
		super(new BoundedGrid<Piece>(11, 11));

		games = new ArrayList<Game>();
		isPlayerOne = true;
		grid = getGrid();
		activeGame = 9; // move anywhere

		setMessage("Welcome to SuperTicTacToe!\nPlayer 1: Click anywhere to begin.");
		setupGrid();
		refreshGame();
	}

	public boolean locationClicked(Location loc) {
		int gameNumber = getGameNumber(loc);
		int index = getIndex(games.get(gameNumber), loc);

		refreshGame();

		Game currentGame = games.get(index);
		return true;
	}

	public void step() {
		deletePiecesFromGrid();
		setupGrid();
		refreshGame();
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
			game.setGameColor(Color.WHITE);
			game.setPiecesColor(Color.WHITE);

			ArrayList<Piece> pieces = game.getPiecesArray();
			int index = 0;
			for (int row = game.START_LOCATION_ROW; row <= game.START_LOCATION_ROW + 2; row++) {
				for (int col = game.START_LOCATION_COL; col <= game.START_LOCATION_COL + 2; col++) {
					add(new Location(row, col), pieces.get(index++));
				}
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
		return false;
	}

	public static void main(String[] args) {
		new SuperWorld().show();
	}
}