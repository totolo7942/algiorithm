package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class ObjectMapperExample<T> {

    public static void main(String[] args) throws JsonProcessingException {
        Gson gson = new Gson();
        A a1 = new A();
        a1.setV1("test");
        final String json = gson.toJson(a1);

        MashllerUtils util = new MashllerUtils();
        System.out.println( util.unMashellerObject( json , A.class).toString());
    }

}

final class MashllerUtils {
    MashllerUtils(){} //package-private rule

    public <T> T unMashellerObject(final String v, Class<T> clazz) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue( v, clazz);
    }
}

class A {
    A() {}
    private String v1;

    public void setV1(String v1) {
        this.v1 = v1;
    }

    @Override
    public String toString() {
        return "A{" +
                "v1='" + v1 + '\'' +
                '}';
    }
}
