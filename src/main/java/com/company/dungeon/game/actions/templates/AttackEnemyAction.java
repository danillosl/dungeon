package com.company.dungeon.game.actions.templates;

import com.company.dungeon.game.Game;
import com.company.dungeon.game.actions.ActionType;

public class AttackEnemyAction extends ActionTemplate {

	private static final long serialVersionUID = 1L;

	public AttackEnemyAction(String description, ActionType actionType) {
		super(description, actionType);
	}

	@Override
	public void execute(Game game) {
		game.executeBatleTurn();
	}

}
