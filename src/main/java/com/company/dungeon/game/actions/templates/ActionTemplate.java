package com.company.dungeon.game.actions.templates;

import com.company.dungeon.game.Game;
import com.company.dungeon.game.actions.Action;
import com.company.dungeon.game.actions.ActionType;

public abstract class ActionTemplate implements Action, Comparable<ActionTemplate> {

	private static final long serialVersionUID = 1L;
	private String description;
	private ActionType actionType;

	public ActionTemplate(String description, ActionType actionType) {
		super();
		this.description = description;
		this.actionType = actionType;

	}

	@Override
	public abstract void execute(Game game);

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public ActionType getActionType() {
		return this.actionType;
	}

	@Override
	public int compareTo(ActionTemplate other) {
		return Integer.compare(this.description.length(), other.description.length());
	}

}
