package com.daovantam.util;

import com.daovantam.dto.MyUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class SecurityUtils {

    public  static MyUser getPrincipal(){
//        khi có dữ liệu rồi, để có thể duy trì dữ liệu đó khi đăng nhập thì sử dụng đối tượng Principal
        MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return myUser;
    }

    @SuppressWarnings("unchecked")
    public static List<String> getAuthorities(){
        List<String> results = new ArrayList<>();
        //lấy được list authorities sau khi add ở bên CustomUserDetailsService
        List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
        return results;
    }
}
