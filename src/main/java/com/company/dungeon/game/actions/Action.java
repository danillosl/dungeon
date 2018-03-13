package com.company.dungeon.game.actions;

import java.io.Serializable;

import com.company.dungeon.game.Game;

public interface Action  extends Serializable{

	void execute(Game game);
	String getDescription();
	ActionType getActionType();

}
