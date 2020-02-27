package com.daovantam.service.impl;

import com.daovantam.constant.SystemConstant;
import com.daovantam.dto.MyUser;
import com.daovantam.entity.RoleEntity;
import com.daovantam.entity.UserEntity;
import com.daovantam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
//    private UserDetailsService userDetailsService;

    // xử lý khi authentication success thì sẽ put tất cả các dữ liệu người dùng vào trong session
    // để duy trì phiên đăng nhập người dùng
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //tham số username ở đây sẽ là dữ liệu submit khi người dùng nhập vào bên trang login
        UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
        if (userEntity == null){
            // xử lý nếu user không tồn tại
            throw new UsernameNotFoundException("User not found");// khi fail sẽ thực hiện authentication-failure-url="/dang-nhap?incorrectAccount"
        }

        // put thông tin vào security duy trì thông tin khi user login vào hệ thống
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(RoleEntity role: userEntity.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
        MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(),
                true, true,true,true, authorities);
        myUser.setFullName(userEntity.getFullName());

        return myUser;
    }
}
