package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request , HttpServletResponse response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username > {}" , username);
        log.info("age > {}" , age);
        try {
            PrintWriter writer = response.getWriter();
            writer.println("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @ResponseBody   // @RestController 처럼 문자열을 반환함
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String userName,
            @RequestParam("age") int memberAge
    ) {
        log.info("username > {}" , userName);
        log.info("age > {}" , memberAge);
        return "ok";
    }

    @ResponseBody   // @RestController 처럼 문자열을 반환함
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ) {
        log.info("username > {}" , username);
        log.info("age > {}" , age);
        return "ok";
    }

    @ResponseBody   // @RestController 처럼 문자열을 반환함
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
            String username,
            int age
    ) {
        log.info("username > {}" , username);
        log.info("age > {}" , age);
        return "ok";
    }

    @ResponseBody   // @RestController 처럼 문자열을 반환함
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age // int에는 null이 안들어감
    ) {
        log.info("username > {}" , username);
        log.info("age > {}" , age);
        return "ok";
    }

    @ResponseBody   // @RestController 처럼 문자열을 반환함
    @RequestMapping("/request-param-degault")
    public String requestParamDefault(
            @RequestParam(defaultValue = "guest") String username,
            @RequestParam(required = false , defaultValue = "-1") int age
    ) {
        log.info("username > {}" , username);
        log.info("age > {}" , age);
        return "ok";
    }

    @ResponseBody   // @RestController 처럼 문자열을 반환함
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String , Object> paramMap) {
        log.info("username > {}" , paramMap.get("username"));
        log.info("age > {}" , paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username > {}" , helloData.getUsername());
        log.info("age > {}" , helloData.getAge());
        return "ok!";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username > {}" , helloData.getUsername());
        log.info("age > {}" , helloData.getAge());
        return "ok!";
    }
}
