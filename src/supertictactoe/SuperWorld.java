package supertictactoe;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.awt.Color;
import java.util.ArrayList;

public class SuperWorld extends World<Piece> {
	boolean isPlayerOne;
	Grid<Piece> grid;
	ArrayList<Game> games;

	public SuperWorld() {
		super(new BoundedGrid<Piece>(11, 11));
		games = new ArrayList<Game>();
		grid = getGrid();
		setupGrid();
		isPlayerOne = true;
	}

	public boolean locationClicked(Location loc) {
		int gameNumber = getGameNumber(loc);

		if (!isEntireGameOver()) {
			if (!isIndividualGameOver(gameNumber)) {
				if (isValidLocation(loc)) {
					if (isPlayerOne) {
						add(loc, new Piece("X"));
						isPlayerOne = false;
					} else {
						add(loc, new Piece("O"));
						isPlayerOne = true;
					}

					if (isPlayerOne)
						setMessage("Player 1: Click a valid location to make a move.");
					else
						setMessage("Player 2: Click a valid location to make a move.");
				}
			}
		}
		return true;
	}

	public void step() {
		for (int row = 0; row < grid.getNumRows(); row++) {
			for (int col = 0; col < grid.getNumCols(); col++) {
				Location currentLocation = new Location(row, col);
				if (grid.isValid(currentLocation))
					grid.remove(currentLocation);
			}
		}
		setMessage("Welcome to TicTacToe.\nPlayer 1: Click any location to start.");
		setupGrid();
		isPlayerOne = true;
	}

	public boolean isValidLocation(Location loc) {
		if (grid.get(loc) instanceof Piece)
			return false;
		return true;
	}

	// TODO: functionality is broken, but program still works
	public boolean isEntireGameOver() {
		setGamesArray();
		for (Game game : games) {
			if (!game.isGameOver())
				return false;
		}
		return true;
	}

	public boolean isIndividualGameOver(int gameNumber) {
		setGamesArray();
		Game currentGame = games.get(gameNumber);
		if (currentGame.isGameOver())
			return true;
		return false;
	}

	public void setGamesArray() {
		// game 1 (0, 0)
		// game 2 (0, 4)
		// game 3 (0, 8)
		// game 4 (4, 0)
		// game 5 (4, 4)
		// game 6 (4, 8)
		// game 7 (8, 0)
		// game 8 (8, 4)
		// game 9 (8, 8)
		int index = 0;
		for (int row = 0; row <= 8; row += 4) {
			for (int col = 0; col <= 8; col += 4) {
				Location startLocation = new Location(row, col);
				Game game = new Game();
				game.setPiecesArray(startLocation, grid);
				games.add(index++, game);
			}
		}
	}

	public int getGameNumber(Location loc) {
		int gameNumber = 0;
		// calculate the game number
		int row = loc.getRow();
		int col = loc.getCol();
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
		return gameNumber;
	}

	public void setWinner(Piece pieceOne, Piece pieceTwo, Piece pieceThree) {
		if (!(pieceOne == null || pieceTwo == null || pieceThree == null)) {
			if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
				setMessage("Player 1 wins! Click STEP to restart.");
				pieceOne.setColor(Color.BLUE);
				pieceTwo.setColor(Color.BLUE);
				pieceThree.setColor(Color.BLUE);
			}
			if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
				setMessage("Player 2 wins! Click STEP to restart.");
				pieceOne.setColor(Color.RED);
				pieceTwo.setColor(Color.RED);
				pieceThree.setColor(Color.RED);
			}
		}
	}

	public void setupGrid() {
		for (int i = 0; i < grid.getNumCols(); i++) {
			Piece p = new Piece("");
			p.setColor(Color.black);
			add(new Location(i, 3), p);
			add(new Location(i, 7), p);
			add(new Location(3, i), p);
			add(new Location(7, i), p);
		}
	}

	public static void main(String[] args) {
		new SuperWorld().show();
	}
}
