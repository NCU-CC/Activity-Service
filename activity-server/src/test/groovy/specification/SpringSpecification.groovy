package specification

import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ActiveProfiles( "dev" )
@ContextConfiguration( "classpath:applicationContext.xml" )
public abstract class SpringSpecification extends Specification {

}
