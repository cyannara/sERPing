package com.beauty1nside;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
//STOMP 기반 웹소켓을 활성화.
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
  
  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    // 메시지 브로커 설정
    config.enableSimpleBroker("/topic");  // 클라이언트에게 메시지를 전달할 경로 (구독 경로), 구독할 채널 (/topic/chat)을 설정.
    config.setApplicationDestinationPrefixes("/app"); // 클라이언트가 보낼 메시지의 prefix, 클라이언트가 서버에 메시지를 보낼 때 사용.
  }
  
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    // 클라이언트가 웹소켓 서버에 연결할 엔드포인트 설정
    registry.addEndpoint("/ws") // 클라이언트가 /ws를 통해 웹소켓에 연결.
      .setAllowedOrigins("*") // CORS 허용
      .withSockJS(); // SockJS 사용 가능하도록 설정
  }
}
