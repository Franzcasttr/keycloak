package com.food.keycloak.cloudinary.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.food.keycloak.cloudinary.CloudinaryService;
import com.food.keycloak.cloudinary.dto.CloudinaryDto;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {

    @Resource
    private Cloudinary cloudinary;
    @Override
    public CloudinaryDto uploadFile(MultipartFile file, String folderName) {

        try{
            HashMap<Object, Object> options = new HashMap<>();
            options.put("folder", folderName);
            Map uploadedFile = cloudinary.uploader().upload(file.getBytes(), options);
            String publicId = (String) uploadedFile.get("public_id");
            String securedURL = cloudinary.url().secure(true).generate(publicId);
            return mapToDto(securedURL,publicId);

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public void deleteFile(String id) {
        try{

             cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
//            Map deletedFile = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private CloudinaryDto mapToDto(String secured_url, String public_id){
        CloudinaryDto cloudinaryDto = new CloudinaryDto();
        cloudinaryDto.setSecured_url(secured_url);
        cloudinaryDto.setPublic_id(public_id);
        return cloudinaryDto;
    }
}
