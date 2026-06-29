package kr.co.sboard.security;

import kr.co.sboard.entity.User;
import kr.co.sboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /*
        - UserDetailsService 호출하는 AuthenticationProvider에서 username(사용자아이디)을 전달
        - AuthenticationProvider에서 실제 사용자 아이디, 비밀번호 인증을 수행
        - 인증 성공 후 loadUserByUsername메서드의 매개변수 username 으로 인증된 사용자 아이디 전달
    */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 사용자 조회 후 시큐리티 인증 객체(UserDetails) 반환
        Optional<User> optUser = userRepository.findById(username);

        if (optUser.isPresent()){
            MyUserDetails details = MyUserDetails.builder()
                .user(optUser.get())
                .build();

            return details;
        }

        return null;
    }
}