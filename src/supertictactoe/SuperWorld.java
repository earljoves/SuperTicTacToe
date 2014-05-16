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

	public SuperWorld() {
		super(new BoundedGrid<Piece>(11, 11));

		games = new ArrayList<Game>();
		isPlayerOne = true;
		grid = getGrid();

		setupGrid();
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
		}
	}

	public void deletePiecesFromGrid() {
		ArrayList<Location> occupiedLocations = grid.getOccupiedLocations();
		for (Location location : occupiedLocations) {
			if (!(grid.get(location).isBlank()))
				grid.remove(location);
		}
	}

	public static void main(String[] args) {
		new SuperWorld().show();
	}
}