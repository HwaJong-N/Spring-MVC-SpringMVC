package ghkwhd.springMVC.basic.request;

import ghkwhd.springMVC.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}", username);
        log.info("age={}", age);

        response.getWriter().write("ok");
    }

    @RequestMapping("request-param-v2")
    public String requestparamV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") int memberAge) {

        log.info("username={}", memberName);
        log.info("age={}", memberAge);

        return "ok";
    }

    @RequestMapping("request-param-v3")
    public String requestparamV3(@RequestParam() String username,
                                 @RequestParam() int age) {

        log.info("username={}", username);
        log.info("age={}", age);

        return "ok";
    }

    @RequestMapping("request-param-v4")
    public String requestparamV4(String username, int age) {

        log.info("username={}", username);
        log.info("age={}", age);

        return "ok";
    }

    @RequestMapping("request-param-required")
    public String requestparamRequired(@RequestParam(required = false) String username,
                                       @RequestParam(required = false) int age) {
        log.info("username={}", username);
        log.info("age={}", age);

        return "ok";
    }

    @RequestMapping("request-param-default")
    public String requestparamDefault(@RequestParam(required = false, defaultValue = "Jong") String username,
                                       @RequestParam(required = false, defaultValue = "24") int age) {
        log.info("username={}", username);
        log.info("age={}", age);

        return "ok";
    }

    @RequestMapping("request-param-map")
    public String requestparamMap(@RequestParam Map<String, Object> paramMap ) {
        log.info("username={}", paramMap.get("username"));
        log.info("age={}", paramMap.get("age"));

        return "ok";
    }

    @RequestMapping("request-param-multivalueMap")
    public String requestparamMultiValueMap(@RequestParam MultiValueMap<String, Object> paramMap ) {
        log.info("username={}", paramMap.get("username"));
        log.info("age={}", paramMap.get("age"));

        return "ok";
    }

    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData hellodata) {

        log.info("helloData = {}", hellodata);
        return "ok";
    }

}
