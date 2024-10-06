package kr.co.sh.labor_api.users.dto;

public record UserRegisterRequest(String email, String password, String roleType) {

}
