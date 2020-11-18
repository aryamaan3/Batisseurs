package joueurs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import joueurs.Bourse;

public class TestBourse {

    @Test
    public void TestGetEcus(){
        Bourse BourseTest = new Bourse(1);
        int bourse = BourseTest.getEcus();
        assertEquals(10,bourse);
    }

}
