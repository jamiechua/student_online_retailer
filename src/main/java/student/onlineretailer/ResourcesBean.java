package student.onlineretailer;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Profile("development")
public class ResourcesBean {

    @Override
    public String toString() {
        return "Hello from demo.additionaltechniques.ResourcesBeanDev";
    }

}
