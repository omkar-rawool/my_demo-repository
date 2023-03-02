package com.crossasyst.imageupload.service;

import com.crossasyst.imageupload.entity.ImageEntity;
import com.crossasyst.imageupload.mapper.ImageMapper;
import com.crossasyst.imageupload.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    private final ImageMapper mapper;

    public void save(MultipartFile multipartFile) throws IOException {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setName(multipartFile.getOriginalFilename());
        imageEntity.setSize(multipartFile.getSize());
        imageEntity.setData(multipartFile.getBytes());
        imageRepository.save(imageEntity);
    }


    public Optional<ImageEntity> getImage(Long id) {


        ImageEntity imageEntity = imageRepository.findById(id).get();
        if (Objects.isNull(imageEntity)) {
            throw new RuntimeException();
        } else {

            return imageRepository.findById(id);
        }
    }

    public void getImageIntoPdf(Long id)  {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=out.pdf");
            headers.add("Content-Type", "application/pdf");
            byte[] bArray = imageRepository.findById(id).get().getData();
            OutputStream out = new FileOutputStream("F:/Development/out.pdf");
            out.write(bArray);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
