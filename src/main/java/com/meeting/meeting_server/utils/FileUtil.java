package com.meeting.meeting_server.utils;


import com.meeting.meeting_server.conf.AppConfig;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author zcw
 */
public class FileUtil {

    public static final String baseDir = AppConfig.getBaseDir();

    /**
     * 上传文件
     * @param file
     * @return
     * @throws IOException
     */
    public static String upload(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String extension = getExtension(file.getOriginalFilename());
        fileName = DateFormatUtils.format(new Date(), "yyyy/MM/dd") + "/" + UUID.randomUUID() + "." + extension;
        File desc = getAbsoluteFile(baseDir,fileName);
        file.transferTo(desc);
        return AppConfig.getUrl()+fileName;
    }


    /**
     * 获取拓展名
     * @param name
     * @return
     */
    private static String getExtension(String name) {
        if (name.lastIndexOf('.')!=-1&&name.lastIndexOf('.')!=0){
            return name.substring(name.lastIndexOf('.')+1);
        }else{
            return "";
        }
    }

    /**
     * 获取绝对路径文件
     * @param uploadDir
     * @param fileName
     * @return
     */
    private static final File getAbsoluteFile(String uploadDir, String fileName) {
        File desc = new File(uploadDir + File.separator + fileName);
        if (!desc.exists())
        {
            if (!desc.getParentFile().exists())
            {
                desc.getParentFile().mkdirs();
            }
        }
        return desc;
    }
}
