package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        Map<String, String> result = new HashMap<>();

        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParam("id");

            var number = 0;
            for (var company: COMPANIES) {

                if (company.get("id").equals(id)) {
                number ++;
                result.putAll(company);
                    }
                }

            if (number == 0) {
                    throw new NotFoundResponse("Company not found");
            }

            ctx.json(result);

        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
