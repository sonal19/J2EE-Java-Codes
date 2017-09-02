package net.viralpatel.spring.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import com.mongodb.MongoClient;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.viralpatel.spring")
@Import(MongoConfiguration.class)
public class AppConfig extends WebMvcConfigurerAdapter {
	/*@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}*/

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	 @Bean
	    @Description("Thymeleaf template resolver serving HTML 5")
	    public ServletContextTemplateResolver templateResolver() {
	        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
	        templateResolver.setPrefix("/WEB-INF/templates/");
	        templateResolver.setSuffix(".html");
	        templateResolver.setTemplateMode("HTML5");
	        
	        return templateResolver;
	    }
	    
	    @Bean
	    @Description("Thymeleaf template engine with Spring integration")
	    public SpringTemplateEngine templateEngine() {
	        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	        templateEngine.setTemplateResolver(templateResolver());
	        
	        return templateEngine;
	    }
	    
	    @Bean
	    @Description("Thymeleaf view resolver")
	    public ThymeleafViewResolver viewResolver() {
	        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	        viewResolver.setTemplateEngine(templateEngine());
	        
	        return viewResolver;
	    }
	    
	    @Bean
	    @Description("Spring message resolver")
	    public ResourceBundleMessageSource messageSource() {  
	        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();  
	        messageSource.setBasename("i18n/messages");  
	        
	        return messageSource;  
	    }
	    
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	    }

}