package kr.co.sboard.service;

import kr.co.sboard.dao.UserDAO;
import kr.co.sboard.dto.UserCheckDTO;
import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserDAO dao;
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public UserDTO get(String userid){
        return null;
    }

    public List<UserDTO> getAll(){
        return null;
    }

    public int getCount(UserCheckDTO dto) {
        return switch(dto.getType()) {
            case "userid" -> repository.countByUserid(dto.getValue());
            case "nick" -> repository.countByNick(dto.getValue());
            case "email" -> {
                int count = repository.countByEmail(dto.getValue());

                if(count == 0) {
                    // 인증코드 이메일 전송

                }

                yield count;
            }
            case "hp" -> repository.countByHp(dto.getValue());
            default -> 0;
        };
    }

    public void register(UserDTO dto){
        // 비밀번호 암호화
        String encoded = passwordEncoder.encode(dto.getPass());
        dto.setPass(encoded);

        // Mybatis
        dao.insert(dto);
    }

    public void modify(UserDTO dto){

    }

    public void remove(String userid){

    }

}