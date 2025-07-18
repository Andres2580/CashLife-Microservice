package com.cashlife.users_microservice.usersmicroservices.userContext.interfaces.rest.acl;

import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.commands.CreatePersonCommand;
import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.queries.GetPersonByEmailQuery;
import com.cashlife.users_microservice.usersmicroservices.userContext.domain.model.valueobjects.EmailAddress;
import com.cashlife.users_microservice.usersmicroservices.userContext.domain.services.PersonCommandService;
import com.cashlife.users_microservice.usersmicroservices.userContext.domain.services.PersonQueryService;
import org.springframework.stereotype.Service;

@Service
public class PersonsContextFacade {
    private final PersonCommandService personCommandService;
    private final PersonQueryService personQueryService;

    public PersonsContextFacade(PersonCommandService personCommandService, PersonQueryService personQueryService) {
        this.personCommandService = personCommandService;
        this.personQueryService = personQueryService;
    }

    public Long createPerson(String firstName, String lastName, String email, String street, String number) {
        var createPersonCommand = new CreatePersonCommand(firstName, lastName, email, street, number);
        var person = personCommandService.handle(createPersonCommand);
        if (person.isEmpty()) return 0L;
        return person.get().getId();
    }

    public Long fetchPersonIdByEmail(String email) {
        var getPersonByEmailQuery = new GetPersonByEmailQuery(new EmailAddress(email));
        var person = personQueryService.handle(getPersonByEmailQuery);
        if (person.isEmpty()) return 0L;
        return person.get().getId();
    }
}
