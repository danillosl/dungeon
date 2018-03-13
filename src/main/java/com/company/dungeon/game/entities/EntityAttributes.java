package com.company.dungeon.game.entities;

import java.io.Serializable;

public class EntityAttributes implements Serializable {

	private static final long serialVersionUID = 1L;
	private int totalLife;
	private int currentLife;
	private int defense;
	private int attack;
	private int level;
	private int currentExperience;
	private int experienceToLevelUp;

	public EntityAttributes() {
		this(400, 100, 150,0);
	}

	public EntityAttributes(int totalLife, int defense, int attack, int level) {
		this(totalLife, defense, attack, level, 200);
	}
	
	public EntityAttributes(int totalLife, int defense, int attack, int level, int experienceToLevelUp) {
		super();
		this.totalLife = totalLife;
		this.currentLife = this.totalLife;
		this.defense = defense;
		this.attack = attack;
		this.level = level;
		this.experienceToLevelUp = experienceToLevelUp;
	}

	public void takeDamage(int damage) {
		if (damage <= 0) {
			return;
		}
		this.currentLife = (this.currentLife - damage) < 0 ? 0 : this.currentLife - damage;
	}

	public void gainXP(int experience) {
		if (this.currentExperience + experience < experienceToLevelUp) {
			this.currentExperience += experience;
		} else {
			this.currentExperience = this.currentExperience + experience - experienceToLevelUp;
			this.levelUp();
		}

	}

	private void levelUp() {
		this.experienceToLevelUp = (int) (this.experienceToLevelUp + this.experienceToLevelUp * 0.10);
		this.totalLife = (int) (this.totalLife + this.totalLife * 0.10);
		this.defense = (int) (this.defense + this.defense * 0.10);
		this.attack = (int) (this.attack + this.attack * 0.10);
		this.currentLife = this.totalLife;
		level++;

	}

	public int getTotalLife() {
		return totalLife;
	}

	public int getCurrentLife() {
		return currentLife;
	}

	public int getDefense() {
		return defense;
	}

	public int getAttack() {
		return attack;
	}

	public int getLevel() {
		return this.level;
	}

	public int getExperienceToLevelUp() {
		return experienceToLevelUp;
	}

	public boolean isAlive() {

		return this.currentLife > 0;
	}

	@Override
	public String toString() {
		return String.format("level : %s, life : %s/%s, defense : %s, attack : %s, experience : %s/%s", this.level,
				this.currentLife, this.totalLife, this.defense, this.attack, this.currentExperience,
				this.experienceToLevelUp);
	}

}
