package com.company.dungeon;

import java.util.Collections;
import java.util.StringJoiner;

import com.company.dungeon.game.Game;
import com.company.dungeon.game.GameState;
import com.company.dungeon.game.actions.Action;

public class GamePrinter {

	private Game game;

	public GamePrinter(Game game) {
		this.game = game;
	}

	public void print() {

		StringJoiner joiner = new StringJoiner("\n");
		joiner.add("\033[H\033[2J");
		joiner.add(String.join("", Collections.nCopies(70, "=")));
		joiner.add(this.game.getRoomName());
		joiner.add(this.game.getRoomDescription());

		joiner.add(this.game.getPlayerDescription());

		int index = 0;
		for (Action action : this.game.getCurrentActions()) {
			joiner.add(String.format("%d : %s", index++, action.getDescription()));
		}

		if (!this.game.getState().equals(GameState.END)) {
			joiner.add(game.getGameMessage());
			game.clearGameMessage();
			joiner.add("type the number of the action you want to take: ");
		}
		System.out.print(joiner);
	}
}
