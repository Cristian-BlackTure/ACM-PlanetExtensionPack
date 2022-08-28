package UAW.content;

import mindustry.ctype.*;
import mindustry.type.*;

import mindustry.content.Planets.*;
import UAW.content.UAWPlanets;

public class UAWSectors{
    public SectorPreset
    trynaStart;

    public void load(){

        trynaStart = new SectorPreset("trynaStart", tryna, 69){{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 15;
            difficulty = 1;
        }};
    }
}
