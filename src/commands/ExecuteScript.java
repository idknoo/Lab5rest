package commands;

import collection.CollectionWorker;
import message.Message;

public class ExecuteScript implements Command {
    private final Command[] commands;

    public ExecuteScript(Command[] commands) {
        this.commands=commands;
    }


    @Override
    public Message execute(CollectionWorker collectionWorker) {
        return null;
    }

    public Command[] getCommands() {
        return commands;
    }
}
