package com.growthgenius.sessionstore;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/v1")
public class LoginV1Controller {

    // /login?name=seunggu
    // /myName => "seunggu"
    private final Map<String, String> sessionMap = new ConcurrentHashMap<>();

    @GetMapping("/login")
    public String login(HttpSession session, String name) {
        sessionMap.put(session.getId(), name);
        return "saved.";
    }

    @GetMapping("/my-name")
    public String myName(HttpSession session) {
        return sessionMap.get(session.getId());
    }

}
