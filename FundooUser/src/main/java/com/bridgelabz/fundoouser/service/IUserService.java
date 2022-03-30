

package com.bridgelabz.fundoouser.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.validation.Valid;

import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.fundoouser.dto.LoginDTO;
import com.bridgelabz.fundoouser.dto.UserDTO;
import com.bridgelabz.fundoouser.model.User;
import com.google.zxing.WriterException;

public interface IUserService {
    User registerUser(UserDTO dto);

    List<User> getUsers();

    User getById(String token);

    User updateById(String token, UserDTO dto);

    Object deleteById(String token);

    User getByIdAPI(Integer userId);

    User getByEmail(String email);

	User loginUser( LoginDTO dto);

	User changePassword(UserDTO dto);

	User verifyUser(String email);

	List<User> sendEmails();

	InputStream load();

	String uploadFile(MultipartFile file);

	byte[] downloadFile(String fileName);

	String deleteFile(String fileName);

	void generateQRCodeImage(String token, int i, int j, String qR_CODE_IMAGE_PATH) throws WriterException, IOException;

}
