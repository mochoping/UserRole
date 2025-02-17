package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.User;
import kh.edu.react.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        return userMapper.getUserById(userId);
    }
    /*
    Map<Key, Value>         = Java에서 Key-Value 쌍을 저장하는 자료 구조
    Map<String, Object>     = String 타입의 key를 사용하고, Object 타입의 value를 저장할 수 있기 때문에
                              다양한 데이터 타입을 한번에 저장할 때 유용
                              value 값에 object 로 작성하는 것은
                              어떤 타입이든 저장가능 (개발자가 만든 객체나 User 포함 int String List 등)
                              데이터를 가져올 때 에러를 최소화
    Map<String, String>     = 문자열 - 문자열만 저장 가능
                              예시 ) 인사말 - 안녕하세요 같은 형태만 가능
    Map<String, Integer>    = 문자열 - 숫자
                              예시 ) 제약을 걸어서 특정 사항등을 체크하는 용도로도 사용 가능
    Map<Integer, Integer>   = 숫자 - 숫자


     */
    @Override
    public Map<String, Object> loginUser(String userId, String userPassword) {
        User loggedInUser = userMapper.loginUser(userId, userPassword);
        Map<String, Object> result = new HashMap<String, Object>();
        // map을 이용한 데이터 전달 형식
        if (loggedInUser != null) {
            result.put("status", "success");
            result.put("user", loggedInUser);
            result.put("redirect", "/");
        } else {
            result.put("status", "fail");
            result.put("message", "아이디 또는 비밀번호가 올바르지 않습니다.");
        }

        return result;
    }
}
