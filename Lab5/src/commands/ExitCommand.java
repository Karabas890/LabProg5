package commands;

import application.CollectionManager;

public class ExitCommand extends Command {

    public ExitCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public String execute() {
        System.out.println("Finishing a program... Thanks for using!");
        System.exit(0);
        return "Program finished!\n";
    }

}
