package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * {"username":"taewoo" , "age" : 25}
 * Content-type : application/json
 */
@Slf4j
@Controller
public class RequestBodyJsonController {
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("request-body-json-v1")
    public void requestbodyJsonV1(HttpServletRequest request , HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String message = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody >> {} " , message);
        HelloData helloData = objectMapper.readValue(message, HelloData.class);
        log.info("userName >> {} , age = {} " , helloData.getUsername() , helloData.getAge());
    }

    @ResponseBody
    @PostMapping("request-body-json-v2")
    public String requestbodyJsonV2(@RequestBody String message) throws IOException {
        log.info("messageBody >> {} " , message);
        HelloData helloData = objectMapper.readValue(message, HelloData.class);
        log.info("userName >> {} , age = {} " , helloData.getUsername() , helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @PostMapping("request-body-json-v3")
    public HelloData requestbodyJsonV3(@RequestBody HelloData helloData) throws IOException {
        log.info("userName >> {} , age = {} " , helloData.getUsername() , helloData.getAge());
        return helloData;
    }
}
