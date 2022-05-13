package UAW.world.blocks.defense.turrets;

import UAW.graphics.UAWPal;
import UAW.world.meta.UAWStatValues;
import mindustry.graphics.*;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.draw.DrawTurret;
import mindustry.world.meta.Stat;

import static UAW.Vars.modName;
import static mindustry.Vars.tilesize;

/**
 * Modified version of the vanilla item turret
 * <p>
 * Displays minimum range when selected
 * </p>
 */
public class UAWItemTurret extends ItemTurret {
	public UAWItemTurret(String name) {
		super(name);
		squareSprite = false;
	}

	@Override
	public void init() {
		super.init();
		if (!squareSprite) {
			drawer = new DrawTurret(modName + "armored-");
		}
	}

	@Override
	public void setStats() {
		super.setStats();
		stats.remove(Stat.ammo);
		stats.add(Stat.ammo, UAWStatValues.ammo(ammoTypes));
	}

	@Override
	public void drawPlace(int x, int y, int rotation, boolean valid) {
		super.drawPlace(x, y, rotation, valid);
		Drawf.dashCircle(x * tilesize + offset, y * tilesize + offset, range, Pal.placing);
		if (minRange > 0) {
			Drawf.dashCircle(x * tilesize + offset, y * tilesize + offset, minRange, UAWPal.darkPyraBloom);
		}
	}

	public class UAWItemTurretBuild extends ItemTurretBuild {

		@Override
		public void drawSelect() {
			super.drawSelect();
			if (minRange > 0) {
				Drawf.dashCircle(x, y, minRange, UAWPal.darkPyraBloom);
			}
		}
	}
}
