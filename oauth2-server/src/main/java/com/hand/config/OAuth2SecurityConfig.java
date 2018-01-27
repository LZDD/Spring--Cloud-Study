package com.hand.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configuration.ClientDetailsServiceConfiguration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

/**
 * @author Created by fei.tang@hand-china.com on 2018/1/17.
 * @description 内容交易平台
 */
@Configuration
public class OAuth2SecurityConfig extends AuthorizationServerConfigurerAdapter{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DataSource dataSource;
    //声明TokenStore实现
    @Bean
    public TokenStore tokenStore(){
        return new JdbcTokenStore(dataSource);
    }

    //声明ClientDetails实现
    @Bean
    public ClientDetailsService clientDetails(){
        return new JdbcClientDetailsService(dataSource);
    }


    //配置框架应用上述实现
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endPoints){
        endPoints.authenticationManager(authenticationManager);
        endPoints.tokenStore(tokenStore());

        //配置TokenServices参数
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endPoints.getTokenStore());
        tokenServices.setSupportRefreshToken(false);
        tokenServices.setClientDetailsService(endPoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endPoints.getTokenEnhancer());
        //30天
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30));
        endPoints.tokenServices(tokenServices);
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //存储到mysql数据库
        clients.withClientDetails(clientDetails());

/*        clients.inMemory()  //使用in-memory存储
                .withClient("client") //client_id
                .secret("secret")  //client_secret
                .authorizedGrantTypes("authorization_code") //改clien允许的授权类型
                .scopes("app");  //允许的范围*/
    }
}
