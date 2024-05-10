package com.food.keycloak.cloudinary;

import com.food.keycloak.cloudinary.dto.CloudinaryDto;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    public CloudinaryDto uploadFile(MultipartFile file, String folderName);

    public void deleteFile(String id);
}
