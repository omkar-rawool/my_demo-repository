package com.crossasyst.imageupload.mapper;

import com.crossasyst.imageupload.entity.ImageEntity;
import com.crossasyst.imageupload.model.ImageRequest;
import com.crossasyst.imageupload.model.ImageResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    public ImageResponse entityToModel(ImageEntity imageEntity);
    public ImageEntity modeltoEntity(ImageRequest request);
}
