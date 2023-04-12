package commands;

import application.CollectionManager;
import data.SpaceMarine;

import java.util.LinkedList;

public class CountLessThanHealthCommand extends Command {

    public CountLessThanHealthCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public String execute(int health) {
        LinkedList<SpaceMarine> collection = collectionManager.getCollection();
        int sum = 0;
        for (SpaceMarine spaceMarine : collection) {
            int k = spaceMarine.getHealth();
            if(k < health){
                sum += 1;
            }
        }
        return "The number of elements whose health field value is less than the given one: " + sum;
    }

}
