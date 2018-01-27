package com.hfcsbc;

import com.hfcsbc.domain.SysAuthority;
import com.hfcsbc.domain.SysRole;
import com.hfcsbc.domain.SysUser;
import com.hfcsbc.repository.SysAuthotityRepository;
import com.hfcsbc.repository.SysRoleRepository;
import com.hfcsbc.repository.SysUserRepository;
import com.hfcsbc.repository.support.WiselyRepositoryImpl;
import com.hfcsbc.security.SecurityUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableDiscoveryClient
//开启日志记录，获取授权用户信息,当插入或更新时，自动将更新的用户和时间插入到表中
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
//启动程序时，自动创建表
@EnableJpaRepositories(repositoryBaseClass = WiselyRepositoryImpl.class)
public class AuthServerApplication {

	@Bean(name = "auditorAware")
	public AuditorAware<String> auditorAware() {
		return ()-> SecurityUtils.getCurrentUserUsername();
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

}
