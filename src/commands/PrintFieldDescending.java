package commands;

import collection.CollectionWorker;
import message.Message;

public class PrintFieldDescending implements Command{
    public PrintFieldDescending() {
    }

    @Override
    public Message execute(CollectionWorker collectionWorker) {
        return collectionWorker.printFieldDescending();
    }


}
