package com.company.dungeon.game.factory;

import com.company.dungeon.game.actions.ActionType;
import com.company.dungeon.game.actions.templates.AttackEnemyAction;
import com.company.dungeon.game.entities.Entity;
import com.company.dungeon.game.entities.EntityBuilder;

public final class EntityFactory {

	private EntityFactory() {
		throw new IllegalStateException("Factory class");
	}

	public static Entity getEntity(String entityName) {
		switch (entityName) {

		case "dragon":
			
			return new EntityBuilder().withName(entityName)
			.withPicture("            .==.        .==.\n" + 
					"           //`^\\\\      //^`\\\\\n" + 
					"          // ^ ^\\(\\__/)/^ ^^\\\\\n" + 
					"         //^ ^^ ^/6  6\\ ^^ ^ \\\\\n" + 
					"        //^ ^^ ^/( .. )\\^ ^ ^ \\\\\n" + 
					"       // ^^ ^/\\| v\"\"v |/\\^ ^ ^\\\\\n" + 
					"      // ^^/\\/ /  `~~`  \\ \\/\\^ ^\\\\\n" + 
					"      \\\\^ /  _/  /IIII\\  \\_  \\^ //\n" + 
					"       \\\\/  /(  (IIIIII)  )\\  \\//\n" + 
					"        ^  /  \\  \\IIII/  /  \\  ^\n" + 
					"    jgs    \\  ((((`\"\"`))))  /\n" + 
					"         .--'  /\\_______/\\  `--.\n" + 
					"        ((((--'           '--))))")
			.withTotalLife(100)
			.withDefense(90)
			.withAttack(120)
			.withExperienceToLevelUp(300)
			.withLevel(1)
			.build();
			
		default:
			return new EntityBuilder().withName(entityName)
//					.withPicture("                   _.--.    .--._\n" + 
//							"                 .\"  .\"      \".  \".\n" + 
//							"                ;  .\"    /\\    \".  ;\n" + 
//							"                ;  '._,-/  \\-,_.`  ;\n" + 
//							"                \\  ,`  / /\\ \\  `,  /\n" + 
//							"                 \\/    \\/  \\/    \\/\n" + 
//							"                 ,=_    \\/\\/    _=,\n" + 
//							"                 |  \"_   \\/   _\"  |\n" + 
//							"                 |_   '\"-..-\"'   _|\n" + 
//							"                 | \"-.        .-\" |\n" + 
//							"                 |    \"\\    /\"    |\n" + 
//							"                 |      |  |      |\n" + 
//							"         ___     |      |  |      |     ___\n" + 
//							"     _,-\",  \",   '_     |  |     _'   ,\"  ,\"-,_\n" + 
//							"   _(  \\  \\   \\\"=--\"-.  |  |  .-\"--=\"/   /  /  )_\n" + 
//							" ,\"  \\  \\  \\   \\      \"-'--'-\"      /   /  /  /  \".\n" + 
//							"!     \\  \\  \\   \\                  /   /  /  /     !\n" + 
//							":      \\  \\  \\   \\                /   /  /  /      ")
					.withTotalLife(200)
					.withDefense(100)
					.withAttack(150)
					.withLevel(1)
					.withAction(new AttackEnemyAction("Attak enemy",ActionType.BATTLE))
					.build();

		}
	}

}
