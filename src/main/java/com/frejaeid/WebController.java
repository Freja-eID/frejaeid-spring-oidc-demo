package com.frejaeid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/protected")
    public String protectedResource(@AuthenticationPrincipal OidcUser oidcUser, Model model) {
        String usersEmail = oidcUser.getClaims().get("email").toString();
        model.addAttribute("email", usersEmail);
        return "protected_resource.html";
    }

}
