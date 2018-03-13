package com.company.dungeon.game.entities;

import java.io.Serializable;

import com.company.dungeon.game.actions.ActionBag;

public interface Entity extends ActionBag, Fighter, Serializable{
	
boolean isAlive();

void gainXP(int experience);

int getTotalLife();

int getCurrentLife();

int getDefense();

int getAttack();

String getName();

int getLevel();

String getPicture();

int getExperienceToLevelUp();

}
