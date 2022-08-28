package UAW.content;

import mindustry.ctype.*;
import mindustry.type.*;
import UAW.planets;
import mindustry.content.Planets.*;

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
