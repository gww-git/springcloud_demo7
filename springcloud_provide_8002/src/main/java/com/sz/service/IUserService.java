package com.sz.service;

import com.sz.admin.User;

import java.util.List;

public interface IUserService{

    public List<User> ByUserAll();

    public  User ByUserId(int id);

}
