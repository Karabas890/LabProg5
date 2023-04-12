package commands;

import application.CollectionManager;
import data.SpaceMarine;
import data.Weapon;

import java.util.Collections;
import java.util.LinkedList;

public class PrintFieldDescendingWeaponTypeCommand extends Command {

    public PrintFieldDescendingWeaponTypeCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public String execute() {
        LinkedList<SpaceMarine> collection = collectionManager.getCollection();
        LinkedList<Weapon> weaponTypes = new LinkedList<>();
        for (SpaceMarine spaceMarine : collection) {
            weaponTypes.add(spaceMarine.getWeaponType());
        }
        Collections.sort(weaponTypes);
        StringBuilder stringBuilder = new StringBuilder();
        for (Weapon weapon : weaponTypes) {
            stringBuilder.append(weapon).append("\n");
        }
        return stringBuilder.toString();
    }

}
