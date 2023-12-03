package sn.ys.productcatalog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductcatalogApplicationTests {

    @Test
    void contextLoads() {
        int a = 5;
        assertEquals(5, a, "a should equal 5");
    }

}
