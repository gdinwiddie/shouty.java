package shouty;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;

public class ShoutSteps {
    Shouty system;

    @Before
    public void setup() {
        system = new Shouty();
        system.addPerson("Linda");
        system.addPerson("Shawn");
    }

    @Given("^(\\w+) is (too far|close enough) from (\\w+)$")
    public void person1_is_some_distance_from_person2(String name1, String distance, String name2) throws Throwable {
        int meters;
        if ("too far".equals(distance)) {
            meters = 1111;
        } else if ("close enough".equals(distance)) {
            meters = 999;
        } else {
            meters = Integer.MAX_VALUE;
        }
        system.movePerson(name1, meters, name2);
    }

    @When("^(\\w+) shouts \"(.*?)\"$")
    public void person_shouts(String name, String message) throws Throwable {
        system.getPerson(name).shout(message);
    }

    @When("^(?:\\w+) is quiet$")
    public void shawn_is_quiet() throws Throwable {
    }

    @Then("^(\\w+) should hear nothing$")
    public void person_should_hear_nothing(String name) throws Throwable {
        assertThat(system.getPerson(name).messagesHeard(), is(empty()));
    }

    @Then("^(\\w+) should hear \"(.*?)\"$")
    public void linda_should_hear(String name, String message) throws Throwable {
        assertThat(system.getPerson(name).messagesHeard(), contains(message));
    }
}
