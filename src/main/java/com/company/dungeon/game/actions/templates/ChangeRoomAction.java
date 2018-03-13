package com.company.dungeon.game.actions.templates;

import com.company.dungeon.game.Game;
import com.company.dungeon.game.actions.ActionType;
import com.company.dungeon.game.rooms.Room;

public class ChangeRoomAction extends ActionTemplate {

	private static final long serialVersionUID = 1L;
	protected final Room room;

	public ChangeRoomAction(String description, ActionType actionType, Room room) {
		super(description, actionType);
		this.room = room;

	}

	@Override
	public void execute(Game game) {
		game.changeRoom(room);
	}

}
