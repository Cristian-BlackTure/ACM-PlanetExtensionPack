package UAW.content;

import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.content.*;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.*;
import mindustry.type.*;
import UAW.planets.*;

public class UAWPlanets{
	public static Planet vekt;
    
	public static void load() {
		vekt = new Planet("vekt", Planets.sun, 3, 1) {{
			generator = new GalemitePlanetGenerator();
			meshLoader = () -> new HexMesh(this, 6);
			startSector = 30;
			alwaysUnlocked = true;
		}};
	}
}
