package com.metalearning.media.mapper.service;

import com.metalearning.base.model.PageParams;
import com.metalearning.base.model.PageResult;
import com.metalearning.base.model.RestResponse;
import com.metalearning.media.model.dto.QueryMediaParamsDto;
import com.metalearning.media.model.dto.UploadFileParamsDto;
import com.metalearning.media.model.dto.UploadFileResultDto;
import com.metalearning.media.model.po.MediaFiles;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface MediaFileService {

 public PageResult<MediaFiles> queryMediaFiels(Long companyId,PageParams pageParams, QueryMediaParamsDto queryMediaParamsDto);
 public RestResponse<Boolean> checkChunk(String fileMd5, int chunkIndex);
 public RestResponse<Boolean> checkFile(String fileMd5);

 public UploadFileResultDto uploadFile(Long companyId, UploadFileParamsDto uploadFileParamsDto, byte[] bytes,String folder,String objectName);
 public RestResponse uploadChunk(String fileMd5,int chunk,byte[] bytes);
 public RestResponse mergechunks(Long companyId,String fileMd5,int chunkTotal,UploadFileParamsDto uploadFileParamsDto);
 public MediaFiles getFileById(String id);
 @Transactional
 public MediaFiles addMediaFilesToDb(Long companyId,String fileMd5,UploadFileParamsDto uploadFileParamsDto,String bucket,String objectName);
}
