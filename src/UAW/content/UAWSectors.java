package UAW.content;

import mindustry.ctype.*;
import mindustry.type.*;

import static UAW.planets.*;
import static mindustry.content.Planets.*;

public class UAWSectors{
    public static SectorPreset
    trynaStart;

    @Override
    public static void load(){

        trynaStart = new SectorPreset("trynaStart", tryna, 69){{
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 15;
            difficulty = 1;
        }};
    }
}
