package com.company.dungeon.game.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.company.dungeon.game.actions.Action;
import com.company.dungeon.utilities.Strings;

public class EntityTemplate implements Entity {

	private static final long serialVersionUID = 1L;

	private String name;
	private EntityAttributes attributes;
	private String picture;
	protected List<Action> actions = new ArrayList<>();

	public EntityTemplate(String name, String picture, EntityAttributes atributes) {
		this.attributes = atributes;
		this.name = name;
		this.picture = picture;
	}

	public EntityTemplate(String name, String picture, EntityAttributes atributes, List<Action> actions) {
		this.attributes = atributes;
		this.name = name;
		this.picture = picture;
		this.actions.addAll(actions);
	}

	@Override
	public List<Action> getActions() {
		return Collections.unmodifiableList(actions);
	}

	@Override
	public boolean isAlive() {
		return attributes.isAlive();
	}

	@Override
	public void takeDamage(int damage) {
		attributes.takeDamage(damage);
	}

	@Override
	public void gainXP(int experience) {
		attributes.gainXP(experience);
	}

	@Override
	public int getTotalLife() {
		return attributes.getTotalLife();
	}

	@Override
	public int getCurrentLife() {
		return attributes.getCurrentLife();
	}

	@Override
	public int getDefense() {
		return attributes.getDefense();
	}

	@Override
	public int getAttack() {
		return attributes.getAttack();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getLevel() {
		return attributes.getLevel();
	}

	@Override
	public void removeAction(Action action) {
		this.actions.remove(action);
	}

	@Override
	public String getPicture() {
		return this.picture;
	}
	
	@Override
	public int getExperienceToLevelUp() {
		return this.attributes.getExperienceToLevelUp();
	}

	@Override
	public String toString() {
		return String.format("%s %nname : %s, %s", Strings.isNullOrEmpty(picture) ? "" : picture, this.name,
				this.attributes.toString());
	}

}
