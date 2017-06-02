package tw.edu.ncu.cc.activity.server.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import tw.edu.ncu.cc.oauth.resource.filter.AccessTokenDecisionFilter

@EnableWebSecurity
public class SecurityConfig {

    @Order( 1 )
    @Configuration
    public static class OauthGuard extends WebSecurityConfigurerAdapter {

        @Autowired
        def AccessTokenDecisionFilter accessTokenDecisionFilter

        @Override
        protected void configure( HttpSecurity http ) throws Exception {
            http.requestMatchers()
                    .antMatchers( HttpMethod.GET, "/v*/**" )
                    .antMatchers( HttpMethod.POST, "/v*/**" )
                    .antMatchers( HttpMethod.PUT, "/v*/**" )
                    .antMatchers( HttpMethod.DELETE, "/v*/**" )
                    .and()
                    .addFilterAfter( accessTokenDecisionFilter, UsernamePasswordAuthenticationFilter.class )
                    .csrf().disable()

            // http.antMatcher( "/v*/**" )
            //         .addFilterAfter( accessTokenDecisionFilter, UsernamePasswordAuthenticationFilter.class )
            //         .csrf().disable()
        }
    }

    @Order( 2 )
    @Configuration
    public static class ManagementAPI extends WebSecurityConfigurerAdapter {

        @Autowired
        def AccessTokenDecisionFilter accessTokenDecisionFilter

        @Value( '${custom.management.security.access}' )
        def String managementAccess

        @Override
        protected void configure( HttpSecurity http ) throws Exception {
            http.requestMatchers()
                    .antMatchers( HttpMethod.GET, "/management/**" )
                    .antMatchers( HttpMethod.POST, "/management/**" )
                    .antMatchers( HttpMethod.PUT, "/management/**" )
                    .antMatchers( HttpMethod.DELETE, "/management/**" )
                    .and()
                    .authorizeRequests()
                        .anyRequest().access( managementAccess )

            // http.antMatcher( "/management/**" )
            //         .authorizeRequests()
            //             .anyRequest().access( managementAccess )
        }

    }

}
