package UAW.content;

import arc.func.*;
import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.graphics.g3d.*;
import mindustry.graphics.g3d.PlanetGrid.*;
import mindustry.maps.planet.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import mindustry.content.*;
import mindustry.content.Blocks;
import UAW.planets.*;
import UAW.content.TyraTechTree.*;
import UAW.content.*;
import UAW.content.ACMBlock.*;

public class UAWItems {
	public static Item placeholder,
		cryogel, anthracite, compositeAlloy, dieselCore;

	public static void load() {
		cryogel = new Item("item-cryogel", Color.valueOf("87ceeb")) {{
			flammability = -10f;
                        alwaysUnlocked = true;
			explosiveness = 0f;
		}};
		anthracite = new Item("item-anthracite", Color.valueOf("272727")) {{
			flammability = 1.8f;
			explosiveness = 0.25f;
			hardness = 4;
		}};
		compositeAlloy = new Item("item-composite-alloy", UAWPal.compAlloyMid) {{
			cost = 2.5f;
		}};

        UAWItems.addAll(
        cryogel
        );

	}
}
