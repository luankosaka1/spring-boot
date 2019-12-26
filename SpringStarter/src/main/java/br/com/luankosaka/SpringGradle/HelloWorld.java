package br.com.luankosaka.SpringGradle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestController
@RequestMapping("/")
public class HelloWorld {

    @PostMapping("/post")
    public String sayHelloPost(@RequestBody Map<String, Object> payload) {
        return payload.get("name").toString();
    }

    @GetMapping
    public String sayHello() {
        return "Hello from Spring boot";
    }

    @GetMapping("/subpath")
    public String subpath(@RequestParam(value = "name", required = true) String name) {
        return "Acess subpath with " + name;
    }

    @GetMapping("/subpath2")
    public String subpath2(final WebRequest webRequest) {
        String name = webRequest.getParameter("name");
        return "Acess subpath with " + name;
    }

    @GetMapping("/{dynamic}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public String dynamic(@PathVariable("dynamic") String name) {
        return "Olá, " + name;
    }
}
