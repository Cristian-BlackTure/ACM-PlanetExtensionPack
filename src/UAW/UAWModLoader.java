package UAW;

import UAW.audiovisual.Sfx;
import UAW.content.*;
import UAW.content.blocks.*;
import arc.Events;
import mindustry.game.EventType.FileTreeInitEvent;
import mindustry.mod.Mod;
import UAW.content.planet.*;


public class UAWModLoader extends Mod {
	public UAWModLoader() {
		Events.on(FileTreeInitEvent.class, e -> Sfx.load());
	}

	public void UAWBlockContent() {
		UAWBlocksPower.load();
		UAWBlocksDefense.load();
		UAWBlocksLogistic.load();
		UAWBlocksProduction.load();
		UAWBlocksUnits.load();
	}

	@Override
	public void loadContent() {
		UAWStatusEffects.load();
		UAWBullets.load();
		UAWUnitTypes.load();
		UAWItems.load();
		UAWLiquids.load();
		UAWBlockContent();

	}

	@Override
	public void loadPlanetContent() {
		UAWPlanets();

	}
}
