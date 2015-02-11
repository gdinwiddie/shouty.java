package shouty;

import cucumber.api.PendingException;
import cucumber.api.java.no.Gitt;
import cucumber.api.java.no.Når;
import cucumber.api.java.no.Så;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RopSteps {

    private Person sonja;
    private Person harald;
    private String sonjasBeskjed;

    @Gitt("^at Sonja er på Slottet$")
    public void at_Sonja_er_på_Slottet() throws Throwable {
        sonja = new Person();
        double[] slottet = {59.917043, 10.727377};
        sonja.erPå(slottet);
    }

    @Gitt("^Harald er på Munch-muséet$")
    public void harald_er_på_Munch_muséet() throws Throwable {
        harald = new Person();
        double[] munchMuseet = {59.916951, 10.77498};
        harald.erPå(munchMuseet);
    }

    @Når("^Sonja roper \"(.*?)\"$")
    public void sonja_roper(String beskjed) throws Throwable {
        sonja.roper(beskjed);
        sonjasBeskjed = beskjed;
    }

    @Så("^hører ikke Harald meldingen$")
    public void hører_ikke_Harald_meldingen() throws Throwable {
        boolean hørt = harald.mottatteMeldinger().contains(sonjasBeskjed);
        assertFalse("Forventet at Harald ikke hørte beskjeden", hørt);
    }
}