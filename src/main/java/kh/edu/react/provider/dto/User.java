package kh.edu.react.provider.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // id 값 자동증가 사용하지 않음.
    private String userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userRole;
}
