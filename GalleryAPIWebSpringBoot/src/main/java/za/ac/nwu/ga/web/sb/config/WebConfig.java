package za.ac.nwu.ga.web.sb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ga.logic.config.LogicConfig;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.ga.web.sb.controller",
        "za.ac.nwu.ga.web.sb.exception"
})
public class WebConfig
{
}
