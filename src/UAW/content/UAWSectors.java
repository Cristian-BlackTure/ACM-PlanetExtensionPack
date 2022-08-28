package UAW.content;

import mindustry.ctype.*;
import mindustry.type.*;

import UAW.planets.*;
import mindustry.content.Planets.*;
import static UAW.content.UAWPlanets.*;

public class UAWSectors{
    public static SectorPreset
    trynaStart;

    public static void load(){

        trynaStart = new SectorPreset("trynaStart", tyra, 69){{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 15;
            difficulty = 1;
        }};
    }
}
