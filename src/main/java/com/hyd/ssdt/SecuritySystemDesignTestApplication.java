package com.hyd.ssdt;

import com.hyd.hybatis.HybatisConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(HybatisConfigurator.class)
public class SecuritySystemDesignTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(SecuritySystemDesignTestApplication.class, args);
  }

}
