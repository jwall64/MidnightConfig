import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dev.jwall64.mdcfg.TypeReference;

import java.util.List;

public class TestTypeReference {

    @Test
    public void test() {

        TypeReference<List<String>> string = new TypeReference<>() { };
        Assertions.assertEquals("java.util.List<java.lang.String>", string.getType().toString());
    }

}
