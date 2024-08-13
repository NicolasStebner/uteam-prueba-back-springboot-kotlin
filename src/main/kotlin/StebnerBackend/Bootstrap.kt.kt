package StebnerBackend

import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Component

@Component
class Boostrap(
) : InitializingBean
{
    override fun afterPropertiesSet() {
    }
}
