package collection;

import commands.ReadOrganizationOperation;
import message.Message;
import organization.Organization;

public interface CollectionWorker {

    Message help();

    Message clear();

    Message info();

    Message maxByName();

    Message printFieldDescending();

    Message removeAllByCount(int employeesCount);

    Message removeGreatKey(Integer id);

    Message removeKey(Integer id);

    Message removeLowerKey(Integer id);

    Message replaceIfLowe(Organization organization);

    Message save();

    Message show();

    Message updateId(ReadOrganizationOperation readOrganizationOperation, Integer id);


    Message insert(Organization organization);


}
