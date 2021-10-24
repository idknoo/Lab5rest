package commands;

import collection.CollectionWorker;
import message.Message;

public class CommandError implements Command {

    private String message;

    public CommandError(String message){
        this.message = message;
    }

    @Override
    public Message execute(CollectionWorker collectionManager) {
        return new Message(message);
    }
}
