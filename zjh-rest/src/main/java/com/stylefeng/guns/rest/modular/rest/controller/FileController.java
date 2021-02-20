package com.stylefeng.guns.rest.modular.rest.controller;

import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.rest.modular.rest.common.GunsProperties;
import com.stylefeng.guns.rest.modular.rest.common.ResponseCode;
import com.stylefeng.guns.rest.modular.rest.common.ResultVo;
import com.stylefeng.guns.rest.modular.rest.dao.TFileMapper;
import com.stylefeng.guns.rest.modular.rest.model.TFile;
import com.stylefeng.guns.rest.modular.rest.response.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>Description</p>
 * <p></p>
 * ======================
 * ======================
 *
 * @Author created by jy
 * @Date 2019/8/18
 */
@Controller
@RequestMapping("/file")
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private GunsProperties gunsProperties;
    @Autowired
    private TFileMapper fileMapper;

    @GetMapping("/download")
    @ResponseBody
    public Object download(String file_name, HttpServletResponse response) {
        log.info("下载文件接口： uri = /file/download  参数列表：{'fileName':{}}", new Object[]{file_name});
        ResponseVo responseVo = new ResponseVo(ResponseCode.ERROR, "下载失败");
        String path = this.gunsProperties.getFileUploadPath();
        String fileName = path + file_name;
        if (fileName != null) {
            //设置文件路径
            File file = new File(fileName);
            //File file = new File(realPath , fileName);
            if (file.exists()) {
                log.info(fileName);
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    responseVo.setCode(ResponseCode.SUCCESS);
                    responseVo.setMsg("下载成功");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return responseVo;
    }

    /**
     * 上传文件
     */
    @RequestMapping(method = RequestMethod.POST, path = "/upload")
    @ResponseBody
    public Object upload(@RequestPart("file") MultipartFile file) {
        log.info("文件上传");
        ResultVo resultVo = new ResultVo(ResponseCode.RESOURCES_NOT_EXIST, "上传文件为空");
        String path = this.gunsProperties.getFileUploadPath();
        String fileName = UUID.randomUUID().toString() + "." + ToolUtil.getFileSuffix(file.getOriginalFilename());
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 转存文件
                file.transferTo(new File(path + fileName));
                TFile tFile = new TFile();
                tFile.setCreate_time(DateUtil.getTime());
                tFile.setOld_file_name(file.getOriginalFilename());
                tFile.setNew_file_name(fileName);
                this.fileMapper.insert(tFile);
                Map<String, Object> params = new HashMap<>();
                params.put("new_file_name", fileName);
                List<TFile> files = this.fileMapper.selectByMap(params);
                TFile file2 = files.get(0);
                resultVo.setMsg("上传成功");
                resultVo.setCode(ResponseCode.SUCCESS);
                Map<String, Object> datas = new HashMap<>();
                datas.put("file", file2);
                resultVo.setDatas(datas);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultVo;
    }

}
