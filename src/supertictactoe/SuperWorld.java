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
	int gameNumber;

	public SuperWorld() {
		super(new BoundedGrid<Piece>(11, 11));

		games = new ArrayList<Game>();
		isPlayerOne = true;
		grid = getGrid();
		gameNumber = 0;

		setupGrid();
		setMessage("Welcome to TicTacToe.\nPlayer 1: Click any location to start.");

		games.add(0, new Game(new Location(0, 0)));
		refreshGame();
	}

	public boolean locationClicked(Location loc) {
		return true;
	}

	public void step() {

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

		for (Game game : games) {
			System.out.println(game.getGameNumber());
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
		for (Game game : games) {
			for (Piece piece : game.getPiecesArray()) {

			}
		}
	}

	public static void main(String[] args) {
		new SuperWorld().show();
	}
}