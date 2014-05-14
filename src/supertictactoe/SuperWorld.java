package supertictactoe;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.awt.Color;

public class SuperWorld extends World<Piece> {
	boolean isPlayerOne;
	Grid<Piece> grid;

	public SuperWorld() {
		super(new BoundedGrid<Piece>(11, 11));
		isPlayerOne = true;
		grid = getGrid();
		populateWithRocks();
	}

	public boolean isValidLocation(Location loc) {
		if (grid.get(loc) instanceof Piece)
			return false;
		return true;
	}

	public boolean locationClicked(Location loc) {
		if (!checkGameOver()) {
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

				checkGameOver();
			}
		}
		return true;
	}

	public void step() {
		isPlayerOne = true;
		for (int row = 0; row < grid.getNumRows(); row++) {
			for (int col = 0; col < grid.getNumCols(); col++) {
				Location currentLocation = new Location(row, col);
				if (grid.isValid(currentLocation))
					grid.remove(currentLocation);
			}
		}
		setMessage("Welcome to TicTacToe.\nPlayer 1: Click any location to start.");
		populateWithRocks();
	}

	public boolean checkGameOver() {
		Piece pieceOne = null;
		Piece pieceTwo = null;
		Piece pieceThree = null;
		boolean gameOver = false;

		// check columns
		checkColumns(pieceOne, pieceTwo, pieceThree, gameOver);
		if (gameOver)
			return true;

		// check rows
		checkRows(pieceOne, pieceTwo, pieceThree, gameOver);
		if (gameOver)
			return true;

		// check diagonals
		// check major diagonal
		int index = 0;
		pieceOne = grid.get(new Location(index, index++));
		pieceTwo = grid.get(new Location(index, index++));
		pieceThree = grid.get(new Location(index, index));
		if (!(pieceOne == null || pieceTwo == null || pieceThree == null)) {
			if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
				setMessage("Player 1 wins! Click STEP to restart.");
				pieceOne.setColor(Color.GREEN);
				pieceTwo.setColor(Color.GREEN);
				pieceThree.setColor(Color.GREEN);
				return true;
			}
			if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
				setMessage("Player 2 wins! Click STEP to restart.");
				pieceOne.setColor(Color.GREEN);
				pieceTwo.setColor(Color.GREEN);
				pieceThree.setColor(Color.GREEN);
				return true;
			}
		}

		// check minor diagonal
		// TODO: broken
		index = 0;
		int size = grid.getNumCols();
		pieceOne = grid.get(new Location((size - index - 1),
				(size - index++ - 1)));
		pieceTwo = grid.get(new Location((size - index - 1),
				(size - index++ - 1)));
		pieceThree = grid.get(new Location((size - index - 1),
				(size - index - 1)));
		if (!(pieceOne == null || pieceTwo == null || pieceThree == null)) {
			if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
				setMessage("Player 1 wins! Click STEP to restart.");
				return true;
			}
			if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
				setMessage("Player 2 wins! Click STEP to restart.");
				return true;
			}
		}

		// check if cat's game
		// TODO: implement functionality

		return false;
	}

	public void checkColumns(Piece pieceOne, Piece pieceTwo, Piece pieceThree,
			boolean gameOver) {
		int row1 = 0;
		for (int col1 = 0; col1 < grid.getNumCols(); col1++) {
			// game 1
			pieceOne = grid.get(new Location(row1++, col1));
			pieceTwo = grid.get(new Location(row1++, col1));
			pieceThree = grid.get(new Location(row1++, col1));
			setWinner(pieceOne, pieceTwo, pieceThree, gameOver);

			row1++;

			// game 2
			pieceOne = grid.get(new Location(row1++, col1));
			pieceTwo = grid.get(new Location(row1++, col1));
			pieceThree = grid.get(new Location(row1++, col1));
			setWinner(pieceOne, pieceTwo, pieceThree, gameOver);
			row1++;

			// game 3
			pieceOne = grid.get(new Location(row1++, col1));
			pieceTwo = grid.get(new Location(row1++, col1));
			pieceThree = grid.get(new Location(row1, col1));
			setWinner(pieceOne, pieceTwo, pieceThree, gameOver);

			row1 = 0;
		}
	}

	public void checkRows(Piece pieceOne, Piece pieceTwo, Piece pieceThree,
			boolean gameOver) {
		int col2 = 0;
		for (int row2 = 0; row2 < grid.getNumRows(); row2++) {
			pieceOne = grid.get(new Location(row2, col2++));
			pieceTwo = grid.get(new Location(row2, col2++));
			pieceThree = grid.get(new Location(row2, col2++));
			setWinner(pieceOne, pieceTwo, pieceThree, gameOver);

			col2++;

			pieceOne = grid.get(new Location(row2, col2++));
			pieceTwo = grid.get(new Location(row2, col2++));
			pieceThree = grid.get(new Location(row2, col2++));
			setWinner(pieceOne, pieceTwo, pieceThree, gameOver);

			col2++;

			pieceOne = grid.get(new Location(row2, col2++));
			pieceTwo = grid.get(new Location(row2, col2++));
			pieceThree = grid.get(new Location(row2, col2));
			setWinner(pieceOne, pieceTwo, pieceThree, gameOver);

			col2 = 0;
		}
		gameOver = false;
	}

	public void setWinner(Piece pieceOne, Piece pieceTwo, Piece pieceThree,
			boolean gameOver) {
		if (!(pieceOne == null || pieceTwo == null || pieceThree == null)) {
			if (pieceOne.isX() && pieceTwo.isX() && pieceThree.isX()) {
				setMessage("Player 1 wins! Click STEP to restart.");
				pieceOne.setColor(Color.BLUE);
				pieceTwo.setColor(Color.BLUE);
				pieceThree.setColor(Color.BLUE);
				gameOver = true;
			}
			if (pieceOne.isO() && pieceTwo.isO() && pieceThree.isO()) {
				setMessage("Player 2 wins! Click STEP to restart.");
				pieceOne.setColor(Color.RED);
				pieceTwo.setColor(Color.RED);
				pieceThree.setColor(Color.RED);
				gameOver = true;
			}
		}
	}

	public void populateWithRocks() {
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
		new UltimateWorld().show();
	}

}
