package com.company.dungeon.game.actions;

import java.io.Serializable;
import java.util.List;

public interface ActionBag extends Serializable{

	List<Action> getActions();
	void removeAction(Action action);

}
