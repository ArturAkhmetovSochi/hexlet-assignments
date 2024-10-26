package exercise;

import io.javalin.Javalin;

import java.util.List;

import static exercise.Data.getDomains;
import static exercise.Data.getPhones;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        List<String> phones = getPhones();
        List<String> domains = getDomains();
        app.get("/phones", ctx -> ctx.json(phones));
        app.get("/domains", ctx -> ctx.json(domains));

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
