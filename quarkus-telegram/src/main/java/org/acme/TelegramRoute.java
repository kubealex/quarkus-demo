package org.acme;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class TelegramRoute extends RouteBuilder {
        @Override
        public void configure() throws Exception {
                from("telegram:bots?authorizationToken=" + System.getenv("BOT_TOKEN"))
                                .log("Incoming message ${body}").bean(TelegramBean.class)
                                .to("telegram:bots?authorizationToken="
                                                + System.getenv("BOT_TOKEN"));
        }
}
