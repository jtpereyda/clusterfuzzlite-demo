import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.api.FuzzerSecurityIssueMedium;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.parser.ObjectMapperFactory;



public class SwaggerParserFuzzer {
    public static void fuzzerTestOneInput(FuzzedDataProvider dataProvider) {
        String data;
        ObjectMapper o = ObjectMapperFactory.createJson();

        data = dataProvider.consumeString(1000);

        try {
            o.readTree(data);
        } catch (JsonProcessingException e) {
//            throw new FuzzerSecurityIssueMedium("JsonProcessingException detected");
        }
    }
}
