package pl.coderslab.charity.service;


import pl.coderslab.charity.entity.User;

public interface UserService {


    public User findUserByEmail(String email);
    public void saveUser(User user);





}
