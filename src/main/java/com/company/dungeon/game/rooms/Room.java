package com.company.dungeon.game.rooms;

import com.company.dungeon.game.actions.ActionBag;

public interface Room extends ActionBag {

	String getDescription();

	String getName();

}
