import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class aa {

    @ResponseBody
    @RequestMapping("/sss")
    public String sss()
    {
        return  "ssss";
    }
}
