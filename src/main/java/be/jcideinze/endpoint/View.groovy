package be.jcideinze.endpoint

import be.jcideinze.App
import freemarker.cache.ClassTemplateLoader
import freemarker.template.Configuration
import spark.ModelAndView
import spark.Spark
import spark.template.freemarker.FreeMarkerEngine

import static spark.Spark.get

public class View {

    void routes() {

        get("/index", { req, res ->
            FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
            Configuration freeMarkerConfiguration = new Configuration();
            freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(App.class, "/"));
            freeMarkerEngine.setConfiguration(freeMarkerConfiguration);
            Map<String, Object> attributes = new HashMap<>();
            freeMarkerEngine.render(new ModelAndView(attributes, "index.ftl"));
        })

    }
}
