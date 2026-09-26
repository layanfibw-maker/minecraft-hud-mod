# Lunar HUD Mod - Drag & Drop Edition

A Minecraft 1.8 Forge HUD mod inspired by Lunar Client with **drag-and-drop positioning**!

## Features

✨ **HUD Elements:**
- FPS counter (Green: 60+, Yellow: 30-60, Red: <30)
- Armor durability display
- Movement speed display
- Coordinates (X, Y, Z)
- Direction & rotation angle
- Server ping display (Green: <50ms, Yellow: <100ms, Red: 100+ms)

🎮 **Interactive Positioning:**
- Click and drag any HUD element to reposition
- Real-time drag feedback with colored outlines
- Reset all positions to default
- Save positions automatically

🎛️ **Full Customization:**
- Toggle each HUD element on/off individually
- Edit positions with visual editor
- Color-coded HUD elements for easy identification
- Text shadow support for better readability

## Installation

1. Download Forge for Minecraft 1.8 (11.14.4.1563+)
2. Install Forge
3. Download the mod JAR file
4. Place it in your `mods` folder
5. Launch Minecraft with the Forge profile

## Controls

- **H Key** - Open HUD Settings menu
- **In Editor** - Click and drag HUD elements to move them
- **ESC** - Close menu or editor

## How to Use

1. Press **H** to open the HUD Settings
2. Click **"Edit Positions"** to enter the visual editor
3. **Click and drag** any HUD element (outlined in cyan)
4. Release to drop the element in new position
5. Click **"Save"** to save changes
6. Toggle elements on/off in the settings menu

## Customization

Edit `src/main/java/com/hudmod/hud/HUDManager.java` to customize default positions:

```java
elements.add(new FPSElement(5, 5));       // Change (5, 5) to your preferred X, Y
elements.add(new ArmorElement(5, 20));
elements.add(new SpeedElement(5, 35));
// ... etc
```

## Building from Source

```bash
./gradlew build
```

The mod JAR will be in `build/libs/hudmod-1.0.0.jar`

## Color Scheme

- **FPS**: Green (60+), Yellow (30-60), Red (<30)
- **Speed**: Green
- **Coordinates**: Cyan
- **Direction**: Magenta
- **Ping**: Green (<50ms), Yellow (50-100ms), Red (100+ms)
- **Armor**: Yellow

## Requirements

- Minecraft 1.8
- Forge 1.8 (11.14.4.1563 or compatible)
- Java 7+

## Features Roadmap

- [ ] Configuration file support (JSON/YAML)
- [ ] Custom colors for each element
- [ ] Horizontal/vertical alignment options
- [ ] Transparency/opacity settings
- [ ] Font size customization
- [ ] More HUD elements (Time, Biome, Health, Mana, etc.)

## License

MIT License

## Credits

Inspired by Lunar Client's beautiful HUD design.
