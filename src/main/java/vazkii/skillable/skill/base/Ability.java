package vazkii.skillable.skill.base;

public class Ability extends Unlockable {

	public Ability(String name, int x, int y, int cost) {
		super(name, x, y, cost);
	}
	
	@Override
	public boolean hasSpikes() {
		return true;
	}

}