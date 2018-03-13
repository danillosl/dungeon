package com.company.dungeon.game.actions.templates;

import com.company.dungeon.game.Game;
import com.company.dungeon.game.actions.ActionType;
import com.company.dungeon.game.rooms.Room;

public class EndGameAction extends ChangeRoomAction {

	private static final long serialVersionUID = 1L;

	public EndGameAction(String description, ActionType actionType, Room room) {
		super(description, actionType, room);
	}
	
	@Override
	public void execute(Game game) {
		super.execute(game);
		game.endGame();
	}


}
