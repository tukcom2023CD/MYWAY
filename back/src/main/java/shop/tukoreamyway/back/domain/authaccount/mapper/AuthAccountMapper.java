package shop.tukoreamyway.back.domain.authaccount.mapper;

import org.springframework.stereotype.Component;
import shop.tukoreamyway.back.domain.authaccount.entity.AuthAccount;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthAccountMapper {
  public Map<String, Object> mapToAttributeMap(AuthAccount user) {
    Map<String, Object> attributes = new HashMap<>();
    attributes.put("id", user.getId());
    attributes.put("accountId", user.getAccountId());

    return attributes;
  }
}
