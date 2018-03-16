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
        
        
        registry.addViewController("/activitylist").setViewName("activityList");
        registry.addViewController("/activitylistremove").setViewName("activityListRemove");
        registry.addViewController("/addgrouptoproject").setViewName("addGroupToProject");
        registry.addViewController("/addtoproject").setViewName("addToProject");
        registry.addViewController("/deletefromproject").setViewName("deleteFromProject");
        registry.addViewController("/editactivity").setViewName("editActivity");
        registry.addViewController("/newactivity").setViewName("newActivity");
        registry.addViewController("/newuser").setViewName("newUser");
        registry.addViewController("/projectcreate").setViewName("projectCreate");
        registry.addViewController("/projectremove").setViewName("projectRemove");
        registry.addViewController("/removegrouptoproject").setViewName("removeGroupToProject");
        registry.addViewController("/removeuser").setViewName("removeUser");
        registry.addViewController("/sprintmenu").setViewName("sprintMenu");
        registry.addViewController("/sprints").setViewName("sprints");
        registry.addViewController("/sprintmenustatic").setViewName("sprintMenuStatic");

        

    }


}