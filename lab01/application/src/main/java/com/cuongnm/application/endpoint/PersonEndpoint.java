package com.cuongnm.application.endpoint;

import com.cuongnm.application.domain.Person;
import com.cuongnm.application.error.ExceptionHandler;
import com.cuongnm.application.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
@Validated
public class PersonEndpoint extends ExceptionHandler {

	static final int DEFAULT_PAGE_SIZE = 20;
	static final String HEADER_TOKEN = "token";
	static final String HEADER_USER_ID = "userId";

	private final PersonService personService;

	public PersonEndpoint(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(path = "/v1/persons", method = RequestMethod.GET)
	@Operation(
			summary = "Get all persons",
			description = "Returns first N persons specified by the size parameter with page offset specified by page parameter.")
    public List<Person> getAll(
    		@Parameter(description = "The size of the page to be returned") @RequestParam(required = false) Integer size,
    		@Parameter(description = "Zero-based page index") @RequestParam(required = false) Integer page) {

		List<Person> persons = new ArrayList<>();

		Person p1 = new Person("cuong", "nguyen minh 1");

		persons.add(p1);
		return persons;
    }

    @RequestMapping(path = "/v1/person/{id}", method = RequestMethod.GET)
	@Operation(
			summary = "Get person by id",
			description = "Returns person for id specified.")
	@ApiResponses(value = {@ApiResponse(responseCode = "404", description = "Person not found") })
    public ResponseEntity<Person> get(@Parameter(description = "Person id") @PathVariable("id") Long id) {
		
		Person person = personService.findOne(id);
        return (person == null ? ResponseEntity.status(HttpStatus.NOT_FOUND) : ResponseEntity.ok()).body(person);
    }

    @RequestMapping(path = "/v1/person", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(
    		summary = "Create new or update existing person",
    		description = "Creates new or updates existing person. Returns created/updated person with id.")
    public ResponseEntity<Person> add(
    		@Valid @RequestBody Person person,
    		@Valid @Size(max = 40, min = 8, message = "user id size 8-40") @RequestHeader(name = HEADER_USER_ID) String userId,
    		@Valid @Size(max = 40, min = 2, message = "token size 2-40") @RequestHeader(name = HEADER_TOKEN, required = false) String token) {
    	
    	person = personService.save(person);
    	return ResponseEntity.ok().body(person);
    }
    
    @InitBinder("person")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new PersonValidator());
    }
}