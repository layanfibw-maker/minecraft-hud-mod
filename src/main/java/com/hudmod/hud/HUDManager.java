package com.hudmod.hud;

import com.hudmod.hud.elements.*;

import java.util.ArrayList;
import java.util.List;

public class HUDManager {

    private static final HUDManager INSTANCE = new HUDManager();
    private List<HUDElement> elements;

    private HUDManager() {
        this.elements = new ArrayList<HUDElement>();
        initElements();
    }

    public static HUDManager getInstance() {
        return INSTANCE;
    }

    public void initElements() {
        elements.add(new FPSElement(5, 5));
        elements.add(new ArmorElement(5, 20));
        elements.add(new SpeedElement(5, 35));
        elements.add(new CoordinatesElement(5, 50));
        elements.add(new DirectionElement(5, 65));
        elements.add(new PingElement(5, 80));
    }

    public List<HUDElement> getElements() {
        return elements;
    }

    public HUDElement getElementByName(String name) {
        for (HUDElement element : elements) {
            if (element.name.equals(name)) {
                return element;
            }
        }
        return null;
    }

    public HUDElement getElementAt(int x, int y) {
        for (HUDElement element : elements) {
            if (element.isMouseOver(x, y)) {
                return element;
            }
        }
        return null;
    }

    public void savePositions() {
    }

    public void loadPositions() {
    }
}
