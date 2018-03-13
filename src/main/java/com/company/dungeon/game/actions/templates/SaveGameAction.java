package com.company.dungeon.game.actions.templates;

import com.company.dungeon.game.Game;
import com.company.dungeon.game.actions.ActionType;
import com.company.dungeon.save.Save;
import com.company.dungeon.save.SaveRepositoryImpl;
import com.company.dungeon.utilities.ScannerUtil;

public class SaveGameAction extends ActionTemplate {

	private static final long serialVersionUID = 1L;

	public SaveGameAction(String description, ActionType actionType) {
		super(description, actionType);
	}

	@Override
	public void execute(Game game) {

		String saveName = ScannerUtil.printMessageAndGetInput("type the name of the save: ");
		SaveRepositoryImpl.getSaveRespository().persist(new Save(saveName, game));

	}

}
