package org.zcy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.zcy.crawler.SpiderManager;
import org.zcy.repository.CrawlTemplateResource;
import org.zcy.repository.DataStorageResource;
import org.zcy.repository.TaskResource;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TaskResource taskResource, CrawlTemplateResource crawlTemplateResource, DataStorageResource dataStorageResource) {
		return (args) -> {
			new SpiderManager(taskResource, crawlTemplateResource, dataStorageResource).run();
		};
	}

}
