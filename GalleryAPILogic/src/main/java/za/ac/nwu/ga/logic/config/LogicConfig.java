package za.ac.nwu.ga.logic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ga.translator.config.TranslatorConfig;
//import com.azure.storage.blob.*;
//import com.azure.storage.blob.models.*;
//import java.io.*;

@Import({TranslatorConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.ga.logic.flow"
})
public class LogicConfig
{

}
