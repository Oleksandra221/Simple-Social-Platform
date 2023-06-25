package com.uep.wap.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.DefaultContentTypeResolver;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.List;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    // registers /chat STOMP endpoint. This endpoint is used by the client to connect
    // to the STOMP server. It also enables the SockJS fallback options,
    // so that alternative messaging options may be used if WebSockets are not available.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        System.out.println("registerStompEndpoints");
        registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
    }
    // configures a simple in-memory message broker with one destination for
    // sending and receiving messages, this destination is prefixed with /user,
    // it also designates the /app prefix for messages that are bound for methods
    // annotated with @MessageMapping
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        System.out.println("configureMessageBroker");
        registry.setApplicationDestinationPrefixes("/app").enableSimpleBroker("/user");
    }

    //configures a JSON message converter,
    // which is used by Spring to convert chat messages from/to JSON.
    @Override
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
        System.out.println("configureMessageConverters");
        DefaultContentTypeResolver resolver = new DefaultContentTypeResolver();
        resolver.setDefaultMimeType(MimeTypeUtils.APPLICATION_JSON);
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        converter.setContentTypeResolver(resolver);
        messageConverters.add(converter);
        return false;
    }
}
