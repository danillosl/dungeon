package com.company.dungeon.game.factory;

import java.util.ArrayList;
import java.util.List;

import com.company.dungeon.game.Game;
import com.company.dungeon.game.actions.Action;
import com.company.dungeon.game.entities.Entity;
import com.company.dungeon.game.rooms.Room;

public class GameBuilder {

	private Room room;
	private Entity player;
	private List<Action> actions = new ArrayList<>();

	public GameBuilder withPlayer(Entity player) {
		this.player = player;
		return this;
	}

	public GameBuilder withRoom(Room currentRoom) {
		this.room = currentRoom;
		return this;
	}

	public GameBuilder withAction(Action action) {
		this.actions.add(action);
		return this;
	}

	public GameBuilder addAllAction(List<Action> actions) {
		this.actions.addAll(actions);
		return this;
	}

	public Game build() {

		return new Game(this.player, this.room, this.actions);
	}

}
