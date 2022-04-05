package qa.guru.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import qa.guru.owner.config.FruitsConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitsTest {

    @Test
    public void testArray() {
        System.setProperty("array", "apple,orange,banana");

        FruitsConfig config = ConfigFactory
                .create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsArray()).containsExactly("apple", "orange", "banana");


    }


}