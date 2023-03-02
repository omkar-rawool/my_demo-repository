package com.crossasyst.imageupload.service;

import com.crossasyst.imageupload.entity.ImageEntity;
import com.crossasyst.imageupload.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public void save(MultipartFile multipartFile) throws IOException {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setName(multipartFile.getOriginalFilename());
        imageEntity.setSize(multipartFile.getSize());
        imageEntity.setData(multipartFile.getBytes());
        imageRepository.save(imageEntity);
    }

    public Optional<ImageEntity> getImage(Long id) {
        return imageRepository.findById(id);
    }
}
