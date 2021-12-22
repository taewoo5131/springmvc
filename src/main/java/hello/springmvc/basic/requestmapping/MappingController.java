package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MappingController {

    // mapping 2개도 가능
//    @RequestMapping({"/hello-basic","/hello-go"})
    @RequestMapping(value = "/hello-basic",method = RequestMethod.GET)
    public String helloBasic() {
        log.info("hello-basic");
        return "hello";
    }

    @GetMapping("/mapping-get")
    public String mappingGet() {
        log.info("mappingGet");
        return "ok";
    }

    /**
     * url?userId=taewoo 이렇게 쓰는 방식은 쿼리 파라미터 방식
     * url/taewoo 경로변수 방식
     * - 최근 REST API에서는 경로변수방식을 더 선호한다.
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String ID) {
//    public String mappingPath(@PathVariable String userId) {      변수명과 경로변수명이 같을경우 PathVariable에 변수명 생략 가능
        log.info("mappingPath userID ? > {}",ID);
        return "ok2";
    }


    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok3";
    }

    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"taewoo=IsBackendDev","data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "taewoo=IsBackendDev")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok4";
    }

    /**
     *특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value = "/mapping-header", headers = "taewoo=isNotFrontendDev")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok5";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
//    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE) // 같은 의미
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok6";
    }

    /**
     * Accept 헤더 기반 Media Type * produces = "text/html"
     * produces = "!text/html" * produces = "text/*"
     * produces = "*\/*"
     */
//    @PostMapping(value = "/mapping-produce", produces = "text/html")
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE) // 같은 의미
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok7";
    }

    @PostMapping(value = "/test/{test}" )
    public String mappingProducesTest(@PathVariable("test") String test) {
        log.info("test >> {}" , test);
        return "ok8";
    }
}
