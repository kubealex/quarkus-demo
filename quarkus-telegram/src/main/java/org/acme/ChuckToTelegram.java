package org.acme;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class ChuckToTelegram extends RouteBuilder {
        @Override
        public void configure() throws Exception {
                from("kamelet:chuck-norris-source")
                                .to("telegram:bots?authorizationToken="+ System.getenv("BOT_TOKEN" )+ "&chatId=22358354");
        }
}
