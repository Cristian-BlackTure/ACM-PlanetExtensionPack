

const abcde = new JavaAdapter(Planet, {}, "abcde", Planets.sun, 4, 1);
abcde.generator = new ErekirPlanetGenerator();
abcde.mesh = new HexMesh(abcde, 5);
  abcde.orbitRadius = 100;
    abcde.orbitTime = 1500;
    abcde.rotateTime = 30;
    abcde.bloom = false;
    abcde.accessible = true;
    abcde.startSector = 1;
    abcde.hasAtmosphere = true;
    abcde.atmosphereColor = Color.valueOf("63353e");
    abcde.atmosphereRadIn = 0.0;
    abcde.atmosphereRadOut = 10.0;
    abcde.alwaysUnlocked = true;
    abcde.localizedName = "Planet-BL";

var h = new SectorPreset("a1", abcde, 1);
h.difficulty = 1; 
h.alwaysUnlocked = true;
h.captureWave = 12; 
h.localizedName = "A1";
