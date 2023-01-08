package shop.tukoreamyway.back.domain.authaccount.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class AuthController {
  @GetMapping("members")
  public String getMembers(Principal principal) {
    return principal.getName();
  }
}
