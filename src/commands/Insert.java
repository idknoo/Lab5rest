package commands;

import organization.Organization;
import collection.CollectionWorker;
import message.Message;

public class Insert implements Command {
    private final Organization organization;

    public Insert(Organization organization) {
        this.organization = organization;
    }

    @Override
    public Message execute(CollectionWorker collectionWorker) {
        return collectionWorker.insert(organization);
    }
}
