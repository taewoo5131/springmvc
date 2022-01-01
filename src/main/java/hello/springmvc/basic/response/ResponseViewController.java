package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello").addObject("data","hello!!!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data" , "hello String!");
        return "response/hello";
    }

    // 명시성이 떨어지므로 권장 X
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data" , "hello String!");
    }
}
