package com.apiSergio.SergioCrud.services;

import com.apiSergio.SergioCrud.models.UserModel;
import com.apiSergio.SergioCrud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsersSortedByName() {
        ArrayList<UserModel> users = (ArrayList<UserModel>) userRepository.findAll();
        users.sort(Comparator.comparing(UserModel::getFirtsName));
        return users;
    }

    public List<UserModel> getUsersUnique() {
        List<UserModel> userList = (List<UserModel>) userRepository.findAll();
        // Usar un Map para asegurarnos de que solo mantenemos un UserModel por cada email único.
        // En caso de usuarios con emails duplicados, se mantendrá el primero que se encuentre.
        Map<String, UserModel> emailToUserMap = new HashMap<>();
        for (UserModel user : userList) {
            if (!emailToUserMap.containsKey(user.getEmail())) {
                emailToUserMap.put(user.getEmail(), user);
            }
        }
        return new ArrayList<>(emailToUserMap.values());
    }

    public List<UserModel> getUsersByEmail(String email) {
        return userRepository.findAll().stream()
                .filter(user -> email.equals(user.getEmail()))
                .collect(Collectors.toList());
    }

    public Set<UserModel> getUsersSet() {
        List<UserModel> userList = (List<UserModel>) userRepository.findAll();
        Map<String, UserModel> emailToUserMap = new HashMap<>();
        for (UserModel user : userList) {
            if (!emailToUserMap.containsKey(user.getEmail())) {
                emailToUserMap.put(user.getEmail(), user);
            }
        }
        return new HashSet<>(emailToUserMap.values());
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    //el metodo optional, devuelve o el valor o null, dependiendo del caso
    public Optional<UserModel> getById(Long id) {
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel request, Long id) {
        UserModel user = userRepository.findById(id).get();
        user.setFirtsName(request.getFirtsName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());

        return user;
    }

    public Boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
