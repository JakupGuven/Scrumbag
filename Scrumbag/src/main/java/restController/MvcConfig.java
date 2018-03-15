package restController;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("usermenu");
        registry.addViewController("/").setViewName("usermenu");
        registry.addViewController("/usermenu").setViewName("usermenu");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/admin").setViewName("admin");

    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/","/resources/static/").setCachePeriod(3600).resourceChain(true).addResolver(new PathResourceResolver());
    }


}