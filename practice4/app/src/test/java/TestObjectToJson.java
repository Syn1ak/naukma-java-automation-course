import org.example.ObjectToJsonConvertor;
import org.example.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestObjectToJson {

    @Test
    public void givenObjectSerializedThenTrueReturned()  {
        Person person = new Person("soufiane", "cheouati", "34");
        ObjectToJsonConvertor serializer = new ObjectToJsonConvertor();
        String jsonString = serializer.convertToJson(person);
        assertEquals(
                "{\"personAge\":\"34\",\"firstName\":\"Soufiane\",\"lastName\":\"Cheouati\"}",
                jsonString);
    }
}
