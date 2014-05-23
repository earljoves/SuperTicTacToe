package supertictactoe.rewrite;

import java.awt.Color;

public class Piece {
	private String value;
	private Color color;

	public Piece() {
		this("");
	}

	public Piece(String value) {
		setValue(value);
	}

	public boolean isX() {
		if (value.equals("X"))
			return true;
		return false;
	}

	public boolean isO() {
		if (value.equals("O"))
			return true;
		return false;
	}

	public boolean isBlank() {
		if (value.equals(""))
			return true;
		return false;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public String toString() {
		return getValue();
	}
}