package shouty;

import org.junit.Before;
import org.junit.Test;

import static java.lang.Integer.MAX_VALUE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.isA;

public class ShoutyTest {

    private Shouty shouty;

    @Before
    public void setUp() {
        shouty = new Shouty();
    }

    @Test
    public void anUnknownPersonShouldBeFarAway() {
        final Person nobody = shouty.getPerson("nobody");
        assertThat(nobody, isA(Person.class));
        assertThat(nobody.getLocation(), equalTo(MAX_VALUE));
    }

    @Test
    public void aPreviouslyUnknownPersonShouldBeRemembered() {
        Person newPerson = shouty.getPerson("newPerson");
        newPerson.setLocation(25);
        assertThat(shouty.getPerson("newPerson").getLocation(), equalTo(25));
    }
}
