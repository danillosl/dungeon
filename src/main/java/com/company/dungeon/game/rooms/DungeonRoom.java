package com.company.dungeon.game.rooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.company.dungeon.game.actions.Action;

public class DungeonRoom implements Room {
	private static final long serialVersionUID = 1L;
	private String description;
	private String name;

	private List<Action> actions;

	public DungeonRoom(String name, String description, List<Action> actions) {
		super();
		this.description = description;
		this.actions = new ArrayList<>(actions);
		this.name = name;
	}

	@Override
	public List<Action> getActions() {
		return Collections.unmodifiableList(this.actions);
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void removeAction(Action action) {
		this.actions.remove(action);

	}

}
