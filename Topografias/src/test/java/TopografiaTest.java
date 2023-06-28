import org.junit.jupiter.api.Test;
import topografias.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TopografiaTest {

    @Test
    void topografiaTest(){
        Topografia mixta1 = new Mixta(new Topografia[]{new Tierra(), new Agua(), new Tierra(), new Tierra()});
        Topografia mixta1_clone = new Mixta(new Topografia[]{new Tierra(), new Agua(), new Tierra(), new Tierra()});
        Topografia mixta2 = new Mixta(new Topografia[]{new Tierra(), new Tierra(), new Tierra(), new Tierra()});

        assertTrue(mixta1.equals(mixta1_clone));
        assertTrue(!mixta1.equals(mixta2));
        assertTrue(new Tierra().equals(new Tierra()));
        assertTrue(new Agua().equals(new Agua()));
        assertTrue(!mixta2.equals(new Tierra()));
        assertTrue(!(new Tierra()).equals(mixta2));
    }
    @Test
    void pantanoTest(){
        Topografia mixta1 = new Mixta(new Topografia[]{new Pantano(), new Pantano(), new Tierra(), new Tierra()});
        Topografia mixta1_clone = new Mixta(new Topografia[]{new Pantano(), new Pantano(), new Tierra(), new Tierra()});
        Topografia pantanoMixta = new Mixta(new Topografia[]{new Pantano(), new Pantano(), new Pantano(), new Pantano()});
        Topografia pantano = new Pantano();


        assertTrue(mixta1.equals(mixta1_clone));
        assertTrue(!pantano.equals(pantanoMixta));
        assertTrue(!pantanoMixta.equals(new Pantano()));
        assertTrue(new Pantano().equals(new Pantano()));
    }
}
