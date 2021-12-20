package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j          // lombok이 지원해줌
@RestController // RestController 는 return하는 String이 view 이름이 아닌 문자열 그대로를 반환한다.
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/log-test")
    public String logTest() {
        String name = "taewoo!";
        log.info("name = " , name);
        log.trace("trace log = {}" , name);
        log.debug("debug log = {}" , name);

        /**
         *  이렇게 쓰면 안됨 , 만약 로그 레벨이 warn이나 error일때 info의 log는 찍을 필요가 없는데
         *  '+' 연산자때문에 자바가 일단 연산을 실행한다 그렇게되면 쓸데없는 메모리낭비가 일어나기때문에
         *  로그를 찍을때는 '+'가 아닌 ',' 콤마로 찍는다.
         */
//        log.info("info log : " + name);

        log.info("info log = {} " , name);
        log.warn("warn log = {}" , name);
        log.error("error log = {}" , name);
        return "success";
    }
}
