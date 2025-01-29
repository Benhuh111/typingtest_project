package com.example.typing_test_project;

import com.example.typing_test_project.models.User;
import com.example.typing_test_project.repositories.UserRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ManagingUsersSteps {

    @Autowired
    private UserRepository userRepository;

    private User user;
    private Optional<User> retrievedUser;

    @Given("A user with name {string} and email {string}")
    public void aUserWithNameAndEmail(String name, String email) {
        user = new User();
        user.setName(name);
        user.setEmail(email);
    }

    @When("We create the user")
    public void weCreateTheUser() {
        userRepository.save(user);
    }

    @Then("The user is saved with the specified name and email")
    public void theUserIsSavedWithTheSpecifiedNameAndEmail() {
        Optional<User> savedUser = userRepository.findById(user.getId());
        assertTrue(savedUser.isPresent());
        assertEquals(user.getName(), savedUser.get().getName());
        assertEquals(user.getEmail(), savedUser.get().getEmail());
    }

    @Given("A user with ID {int} exists")
    public void aUserWithIDExists(int id) {
        user = new User();
        user.setId((long) id);
        user.setName("Existing User");
        user.setEmail("existing.user@example.com");
        userRepository.save(user);
    }

    @When("We retrieve the user by ID {int}")
    public void weRetrieveTheUserByID(int id) {
        retrievedUser = userRepository.findById((long) id);
    }

    @Then("The retrieved user has ID {int}")
    public void theRetrievedUserHasID(int id) {
        assertTrue(retrievedUser.isPresent());
        assertEquals(id, retrievedUser.get().getId());
    }

    @Given("A user with email {string} exists")
    public void aUserWithEmailExists(String email) {
        user = new User();
        user.setName("Existing User");
        user.setEmail(email);
        userRepository.save(user);
    }

    @When("We retrieve the user by email {string}")
    public void weRetrieveTheUserByEmail(String email) {
        retrievedUser = userRepository.findByEmail(email);
    }

    @Then("The retrieved user has email {string}")
    public void theRetrievedUserHasEmail(String email) {
        assertTrue(retrievedUser.isPresent());
        assertEquals(email, retrievedUser.get().getEmail());
    }
}
