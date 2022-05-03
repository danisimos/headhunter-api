package ru.itis.headhunter.repositories;

public interface JwtTokenBlackListRepository {
    boolean exists(String token);
    void save(String token);
}
