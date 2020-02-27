package com.daovantam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider") // bật tính năng của JpaAuditing
public class JpaAuditingConfig {
    @Bean
    public AuditorAware<String> auditorProvider(){
        return new AuditorAwareImpl();
    }

    public static class AuditorAwareImpl implements AuditorAware<String>{

        @Override
        public String getCurrentAuditor() {

            // hàm này sẽ có nv là get username để insert createby, modifieddate

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();//cách lấy username
            if (authentication == null){
                //kiểm tra không có dữ liệu hoặc chưa có đăng nhập
                return null;
            }
            return authentication.getName();
        }
    }
}
