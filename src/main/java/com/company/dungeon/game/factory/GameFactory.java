package com.company.dungeon.game.factory;

import com.company.dungeon.game.Game;
import com.company.dungeon.game.actions.ActionType;
import com.company.dungeon.game.actions.templates.EndGameAction;
import com.company.dungeon.game.actions.templates.SaveGameAction;
import com.company.dungeon.game.entities.Entity;

public final class GameFactory {

	private GameFactory() {
		throw new IllegalStateException("Factory class");
	}

	public static Game getGame(String gameName, Entity entity) {
		switch (gameName) {

		case "generic_game":
			return new GameBuilder()
					.withPlayer(entity)
					.withAction(new SaveGameAction("Save game", ActionType.ROOM))
					.withAction(new EndGameAction("End game", ActionType.ROOM, RoomFactory.getRoom("end_room")))
					.withRoom(RoomFactory.getRoom("first_room")).build();

		default:
			throw new IllegalStateException(String.format("No game with the name of %s", gameName));
		}
	}

}
