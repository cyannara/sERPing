package com.beauty1nside.login;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class passwordTest {
  @Test
  public void test() {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    String result = encoder.encode("hashed_pw");
    log.info("result: {}", result);
    assertThat(encoder.matches("1234", result));
  }
}
