package com.example.pera_sport_app.Auth.service.serviceImpl;


import com.example.pera_sport_app.Auth.dto.LoginRequest;
import com.example.pera_sport_app.Auth.dto.LoginResponseDto;
import com.example.pera_sport_app.Auth.service.AuthService;
import com.example.pera_sport_app.Entity.AuthUser;
import com.example.pera_sport_app.player.dto.ResponseDto;
import com.example.pera_sport_app.repository.AuthRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;


    @Override
    public LoginResponseDto login(LoginRequest loginRequest){
        try{
            AuthUser authUser = authRepository.findByUserName(loginRequest.getUserName());
            if(authUser.getPassword().equals(loginRequest.getPassword())){
                return new LoginResponseDto("01","Login Successful", authUser.getTeamName());
            }else{
                return new LoginResponseDto("02","Invalid Username or Password", "");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new LoginResponseDto("00","System Error","");
        }
    }
}
