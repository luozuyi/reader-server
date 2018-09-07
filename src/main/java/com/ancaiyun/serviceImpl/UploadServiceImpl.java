package com.ancaiyun.serviceImpl;

import com.ancaiyun.entity.Upload;
import com.ancaiyun.mapper.UploadMapper;
import com.ancaiyun.service.UploadService;
import com.ancaiyun.utils.Constants;
import com.ancaiyun.utils.PageHelperNew;
import com.ancaiyun.utils.Result;
import com.github.pagehelper.PageInfo;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class UploadServiceImpl implements UploadService{
    @Autowired
    private UploadMapper uploadMapper;
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Override
    public Result listPage(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<Upload> uploadList = uploadMapper.selectAll();
            PageInfo<Upload> page = new PageInfo<>(uploadList);
            code = Constants.SUCCESS;
            msg = "成功";
            result.setData(page);
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "系统繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result addOrUpdate(MultipartFile file) {
        Result result = new Result();
        String msg = "初始化";
        String code = "-1";
        try {
            StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
            String fileUrl = storePath.getFullPath();
            System.out.println("storePath:"+storePath);
            System.out.println("fileUrl:"+fileUrl);
            List<Upload> uploadList_db = uploadMapper.selectByFileRealName(file.getOriginalFilename());
            if(uploadList_db.isEmpty()){
                Upload upload = new Upload();
                upload.setId(UUID.randomUUID().toString().replace("-", ""));
                upload.setCreateTime(new Date());
                upload.setFilePath(storePath.getPath());
                upload.setGroupName(storePath.getGroup());
                upload.setFileRealName(file.getOriginalFilename());
                upload.setExt(fileUrl.substring(fileUrl.lastIndexOf(".") + 1));
                uploadMapper.insertSelective(upload);
                result.setData(upload);
            }else{
                for (Upload upload:uploadList_db) {
                    upload.setFilePath(storePath.getPath());
                    upload.setGroupName(storePath.getGroup());
                    uploadMapper.updateByPrimaryKey(upload);
                }
                result.setData(uploadList_db.get(0));
            }
            msg = "成功";
            code = "0";
        } catch (Exception e) {
            msg = "上传出错";
            code = "-2";
            e.printStackTrace();
        }
        result.setMsg(msg);
        result.setCode(code);
        return result;
    }
}
