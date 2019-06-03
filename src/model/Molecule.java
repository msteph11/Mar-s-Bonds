package model;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.input.KeyEvent;
import java.util.ArrayList;

/**
 * Represents a molecule
 * @author Maria Stephenson
 */
public class Molecule extends Sphere{
    private final static int radius = 20;

    private Hybridization hybridization;
    private ArrayList<Bond> bonds;
    private PhongMaterial material;
    private boolean selected;

    /**
     * Constructor: gives molecule default hybridization (sp3), a default color (red),
     * and an empty list of bonds
     * When mouse hovers over molecule it is selected, otherwise it isn't
     */
    public Molecule() {
        super(radius);
        hybridization = Hybridization.SP3;
        bonds = new ArrayList<>();
        selected = false;
        material = new PhongMaterial(new Color(0, 1, 1,1).darker());
        setMaterial(material);
        addEventHandlers();
    }

    /**
     * Getter
     * @return Molecule's hybridization
     */
    public Hybridization getHybridization() {
        return hybridization;
    }

    /**
     * Getter
     * @return Molecule's bonds
     */
    public ArrayList<Bond> getBonds() {
        return bonds;
    }

    /**
     * Getter
     * @return Molecule's color
     */
    public Color getColor() {
        return material.getDiffuseColor();
    }

    /**
     * Adds two mouse event handlers to detect when mouse enters molecule,
     * and when mouse exits. Molecule is selected when mouse enters, and is not
     * selected after mouse leaves.
     *
     * When a molecule is selected, its color is brighter.
     */
    private void addEventHandlers() {
        addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            selected = true;
            material.setDiffuseColor(material.getDiffuseColor().brighter());
            setMaterial(material);
        });
        addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            selected = false;
            material.setDiffuseColor(material.getDiffuseColor().darker());
            setMaterial(material);
        });
    }
}
