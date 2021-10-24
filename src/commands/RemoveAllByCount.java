package commands;

import collection.CollectionWorker;
import message.Message;

public class RemoveAllByCount implements Command {
    private final int employeesCount;

    public RemoveAllByCount(int employeesCount) {
        this.employeesCount = employeesCount;
    }

    @Override
    public Message execute(CollectionWorker collectionWorker) {
        return collectionWorker.removeAllByCount(employeesCount);
    }
}

