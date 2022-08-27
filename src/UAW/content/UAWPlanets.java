package UAW.content;

import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.content.*;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.*;
import mindustry.type.*;

public class UAWPlanets implements ContentList {
	public static Planet vekt;

	@Override
	public void load() {
		vekt = new Planet("vekt", Planets.sun, 3, 1) {{
			generator = new ErekirPlanetGenerator();
			meshLoader = () -> new HexMesh(this, 6);
			atmosphereColor = Color.valueOf("3c1b8f");
			atmosphereRadIn = 0.02f;
			atmosphereRadOut = 0.3f;
			startSector = 15;
			alwaysUnlocked = true;
		}};
	}
}